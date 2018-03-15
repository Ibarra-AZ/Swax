package swax.web.controller.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import swax.web.component.sessionscope.SessionUser;
import swax.web.component.sessionscope.UserCollection;
import swax.web.mav.utils.MavUtil;
import swax.webservice.apiDiscogs.model.Release;
import swax.webservice.apiDiscogs.model.Want;
import swax.webservice.dto.AlbumDTO;
import swax.webservice.entity.album.AlbumDiscogs;
import swax.webservice.entity.album.SwapAlbum;
import swax.webservice.entity.user.User;
import swax.webservice.service.album.IAlbumCollectedService;
import swax.webservice.service.album.IAlbumDiscogsService;
import swax.webservice.service.album.IAlbumService;
import swax.webservice.service.album.IAlbumWantlistService;
import swax.webservice.service.album.ISwapAlbumService;
import swax.webservice.service.apiDiscogs.IApiDiscogsService;

@Controller
public class SynchronizeWithDiscogsController {

	@Autowired
	private IApiDiscogsService apiDiscogsService;
	
	@Autowired
	private IAlbumDiscogsService albumDiscogsService;
	
	@Autowired
	private IAlbumService albumService;
	
	@Autowired
	private IAlbumCollectedService albumCollectedService;
	
	@Autowired
	private ISwapAlbumService swapAalbumService;
	
	@Autowired
	private IAlbumWantlistService albumWantlistService; 

	@Autowired
	private MavUtil mavUtil;

	@Autowired
	private SessionUser sessionUser;
	
	@Autowired
	private UserCollection userCollectionSession;
	
	private Logger logger = Logger.getLogger(this.getClass());

	private String errorMsg = "";

	@RequestMapping(value="/synchronizeCollectionWithDiscogs", method = RequestMethod.GET)
	public ModelAndView synchronizeCollectionWithDiscogs(ModelAndView mav) {

		logger.debug(this.getClass().getName()+this.getClass()+": synchronizeCollectionWithDiscogs");

		User user = sessionUser.getSessionUser();
		List<Release> releases = new ArrayList<Release>();
		
		try {
			releases = apiDiscogsService.getCollectionFromUserName(user.getDiscogsName());	
		} 
		catch(Exception e) {
			errorMsg = "Erreur dans la synchronisation de la collection avec Discogs";
			e.printStackTrace();
			mav = mavUtil.mySwax(user);
			mav.getModel().put("errorMsg", errorMsg);
			return mav;
		}

		List<AlbumDiscogs> albumsDiscogs = apiDiscogsService.getAlbumsDiscogsFromReleases(releases);
		albumsDiscogs = albumDiscogsService.trimAlbumsDiscogsAPI(albumsDiscogs);
		
		// MISE A JOUR BDD EN ENLEVANT LES ALBUMS QUI NE SONT PLUS DANS DISCOGS
		// TODO: A RENVOYER VERS COUCHE SERVICE ???
		
		List<AlbumDTO> albumsCollection = userCollectionSession.getUserCollection();
		List<AlbumDiscogs> albumsToAdd = new ArrayList<>();
		List<AlbumDTO> albumsToDelete = new ArrayList<>();
		List<SwapAlbum> albumsImpossibleToDelete = new ArrayList<>();
		List<SwapAlbum> swapAlbums = swapAalbumService.findByUser(user);
		
		// ALBUMS TO ADD
		for (AlbumDiscogs albumDiscogs: albumsDiscogs) {
			boolean foundInCollection = false;
			for (AlbumDTO albumCollection: albumsCollection) {
				if (albumDiscogs.getCollection_id().equals(albumCollection.getAlbumId())) {
					foundInCollection = true;
				}
			}
			if (!foundInCollection) {
				albumsToAdd.add(albumDiscogs);
			}
		}
		
		// ALBUMS TO DELETE
		for (AlbumDTO albumCollection: albumsCollection) {
			boolean foundInDiscogs = false;
			for (AlbumDiscogs albumDiscogs: albumsDiscogs) {
				if (albumCollection.getAlbumId().equals(albumDiscogs.getCollection_id())) {
					foundInDiscogs = true;
				}
			}
			if (!foundInDiscogs) {
				albumsToDelete.add(albumCollection);
			}
		}
		
		List<AlbumDTO> albumsToReallyDelete = new ArrayList<>();
		
		for (AlbumDTO albumCollection: albumsToDelete) {
			boolean toDelete = true;
			for (SwapAlbum swapAlbum: swapAlbums) {
				if (swapAlbum.getAlbumCollected().getAlbumCollectedId().equals(albumCollection.getAlbumId())) {
					if (swapAlbum.isAlbumToSwap()==true) {
						albumsImpossibleToDelete.add(swapAlbum);
						toDelete = false;
					}
				}
			}
			if (toDelete) {
				albumsToReallyDelete.add(albumCollection);
			}
		}
		
		System.out.println("ALBUMS A AJOUTER: "+albumsToAdd.size());
		System.out.println("ALBUMS A SUPPRIMER: "+albumsToDelete.size());
		System.out.println("ALBUMS A VRAIMENT SUPPRIMER: "+albumsToReallyDelete.size());
		System.out.println("ALBUMS IMPOSSIBLE A SUPPRIMER: "+albumsImpossibleToDelete.size());
		
		albumService.updateAlbumTable(albumsToAdd);
		albumCollectedService.createUserCollection(user, albumsToAdd);
		
		for (AlbumDTO albumToDelete: albumsToReallyDelete) {
			for (SwapAlbum swapAlbum: swapAlbums) {
				if (swapAlbum.getAlbumCollected().getAlbumCollectedId().equals(albumToDelete.getAlbumId())) {
					swapAalbumService.delete(swapAlbum);
				}
			}
		}
		
		albumCollectedService.delete(albumsToReallyDelete);
		
		// TODO: BILAN SYNCHRO A GERER PAR UNE NOTIFICATION
		if (albumsImpossibleToDelete.size() != 0) {
			errorMsg = "Certains albums n'ont pas pu être supprimés de la collection alors qu'ils ne sont plus présents"
					+ " dans ta collection discogs car ils sont toujours proposés à l'échange:";
			albumsImpossibleToDelete.forEach(item -> 
				errorMsg = errorMsg.concat("\n - "+item.getAlbum().getArtist()+" - "+item.getAlbum().getAlbumName()));
		}
		
		System.out.println(errorMsg);
		// FIN
		
		mav = mavUtil.mySwax(user);
		mav.getModel().put("errorMsg", errorMsg);
		
		return mav;
	}
	
	// TODO: Synchroniser la wantlist avec Discogs
	@RequestMapping(value="/synchronizeWantlistWithDiscogs", method = RequestMethod.GET)
	public ModelAndView synchronizeWantlistWithDiscogs(ModelAndView mav) {

		logger.debug(this.getClass().getName()+this.getClass()+": synchronizeWantlistWithDiscogs");

		User user = sessionUser.getSessionUser();
		
		List<Want> wantlist = new ArrayList<Want>();
		
		try{
			wantlist = apiDiscogsService.getWantListFromUserName(user.getUserName());	
		}
		catch(Exception e){
			errorMsg = "Erreur dans la synchronisation de la wantlist avec Discogs";
			mav.getModel().put("errorMsg", errorMsg);
			mav = mavUtil.mySwax(user);
			return mav;
		}

		List<AlbumDiscogs> albumsWantlist = apiDiscogsService.getAlbumsWantListFromReleases(wantlist);
		albumsWantlist = albumDiscogsService.trimAlbumsDiscogsAPI(albumsWantlist);
		
		albumService.updateAlbumTable(albumsWantlist);
		albumWantlistService.createUserWantlist(user, albumsWantlist);
		
		mav = mavUtil.mySwax(user);
		return mav;
	}


}
