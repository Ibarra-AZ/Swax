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
import swax.webservice.dto.AlbumDTO;
import swax.webservice.entity.album.AlbumDiscogs;
import swax.webservice.entity.album.SwapAlbum;
import swax.webservice.entity.user.User;
import swax.webservice.service.album.IAlbumCollectedService;
import swax.webservice.service.album.IAlbumDiscogsService;
import swax.webservice.service.album.IAlbumService;
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
	private MavUtil mavUtil;

	@Autowired
	private SessionUser sessionUser;
	
	@Autowired
	private UserCollection userCollectionSession;
	
	private Logger logger = Logger.getLogger(this.getClass());

	@RequestMapping(value="/synchronizeCollectionWithDiscogs", method = RequestMethod.GET)
	public ModelAndView synchronizeCollectionWithDiscogs(ModelAndView mav) {

		logger.debug(this.getClass().getName()+this.getClass()+": synchronizeCollectionWithDiscogs");

		User user = sessionUser.getSessionUser();
		List<Release> releases = new ArrayList<Release>();
		
		try {
			releases = apiDiscogsService.getCollectionFromUserName(user.getDiscogsName());	
		} 
		catch(Exception e) {
			// TODO : faire marcher l'affichage du message d'erreur
			String errorMsg = "Erreur dans la synchronisation de la collection avec Discogs";
			e.printStackTrace();
			mav.getModel().put("errorMsg", errorMsg);
			mav = mavUtil.mySwax(user);
			return mav;
		}

		List<AlbumDiscogs> albumsDiscogs = apiDiscogsService.getAlbumsDiscogsFromReleases(releases);

		albumsDiscogs = albumDiscogsService.trimAlbumsDiscogsAPI(albumsDiscogs);
		albumService.updateAlbumTable(albumsDiscogs);
		albumCollectedService.createUserCollection(user, albumsDiscogs);
		
		// MISE A JOUR BDD EN ENLEVANT LES ALBUMS QUI NE SONT PLUS DANS DISCOGS
		List<AlbumDTO> albumsCollection = userCollectionSession.getUserCollection();
		List<String> albumsDiscogsId = new ArrayList<>();
		
		albumsDiscogs.forEach(albumDiscogs -> albumsDiscogsId.add(albumDiscogs.getCollection_id()));
		
		albumsCollection.forEach(albumCollection -> {
			if (!albumsDiscogsId.contains(albumCollection.getAlbumId())) {
				
				List<SwapAlbum> swapAlbums = swapAalbumService.findByUser(user);
				
				swapAlbums.forEach(swapAlbum -> {
					if (swapAlbum.getAlbumCollected().getAlbumCollectedId().equals(albumCollection.getAlbumId())) {
						if (swapAlbum.isAlbumToSwap()==false) {
							swapAalbumService.delete(swapAlbum);
							albumCollectedService.deleteByAlbumCollectedId(albumCollection.getAlbumId());
						}
						else {
							// TODO: IMPORTANT! L'album à supprimer est proposé à l'échange
							System.out.println("TODO: L'album à supprimer est proposé à l'échange");
						}
					}
					else {
						albumCollectedService.deleteByAlbumCollectedId(albumCollection.getAlbumId());
					}
				});			
			}
		});
		// FIN
		
		mav = mavUtil.mySwax(user);
		return mav;
	}
	
	// TODO: Synchroniser la wantlist avec Discogs
	@RequestMapping(value="/synchronizeWantlistWithDiscogs", method = RequestMethod.GET)
	public ModelAndView synchronizeWantlistWithDiscogs(ModelAndView mav) {

		logger.debug(this.getClass().getName()+this.getClass()+": synchronizeWantlistWithDiscogs");

		User user = sessionUser.getSessionUser();
		
		mav = mavUtil.mySwax(user);
		return mav;
	}


}
