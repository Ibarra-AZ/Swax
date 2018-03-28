package swax.web.controller.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import swax.web.component.sessionscope.SessionUser;
import swax.web.component.sessionscope.UserCollection;
import swax.web.component.sessionscope.UserWantlist;
import swax.web.mav.utils.MavUtil;
import swax.webservice.apiDiscogs.model.Release;
import swax.webservice.apiDiscogs.model.Want;
import swax.webservice.dto.AlbumDTO;
import swax.webservice.dto.AlbumWantlistDTO;
import swax.webservice.entity.album.AlbumDiscogs;
import swax.webservice.entity.album.SwapAlbum;
import swax.webservice.entity.notification.Notification;
import swax.webservice.entity.notification.NotificationTypeEnum;
import swax.webservice.entity.user.User;
import swax.webservice.service.album.IAlbumCollectedService;
import swax.webservice.service.album.IAlbumDiscogsService;
import swax.webservice.service.album.IAlbumService;
import swax.webservice.service.album.IAlbumWantlistService;
import swax.webservice.service.album.ISwapAlbumService;
import swax.webservice.service.apiDiscogs.IApiDiscogsService;
import swax.webservice.service.notification.INotificationService;

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
	private INotificationService notificationService; 

	@Autowired
	private MavUtil mavUtil;

	@Autowired
	private SessionUser sessionUser;
	
	@Autowired
	private UserCollection userCollectionSession;
	
	@Autowired
	private UserWantlist userWantlistSession;
	
	private Logger logger = Logger.getLogger(this.getClass());

	private String errorMsg = "";
	
	private Notification notification = null;

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/synchronizeCollectionWithDiscogs", method = RequestMethod.GET)
	public ModelAndView synchronizeCollectionWithDiscogs(ModelAndView mav) {

		logger.debug(this.getClass().getName()+this.getClass()+": synchronizeCollectionWithDiscogs");

		User user = sessionUser.getSessionUser();
		List<Release> releases = new ArrayList<Release>();
		errorMsg = "";
		
		try {
			releases = apiDiscogsService.getCollectionFromUserName(user.getDiscogsName());	
		} 
		catch(Exception e) {
			errorMsg = "Erreur dans la synchronisation de la collection avec Discogs. "+e.getCause().getMessage();
			notification = notificationService.getNotification(user, NotificationTypeEnum.Error_Synchro_Collection, errorMsg);
			notificationService.createUpdateEntity(notification);
			mav = mavUtil.mySwax(user);
			mav.getModel().put("errorMsg", errorMsg);
			return mav;
		}

		List<AlbumDiscogs> albumsDiscogs = apiDiscogsService.getAlbumsDiscogsFromReleases(releases);
		albumsDiscogs = albumDiscogsService.trimAlbumsDiscogsAPI(albumsDiscogs);
		
		List<AlbumDTO> albumsCollection = userCollectionSession.getUserCollection();
		List<SwapAlbum> swapAlbums = swapAalbumService.findByUser(user);
		
		// ALBUMS TO ADD, DELETE, REALLY DELETE, IMPOSSIBLE TO DELETE
		List<AlbumDiscogs> albumsToAdd = apiDiscogsService.getAlbumsToAdd(albumsDiscogs, albumsCollection);
		List<AlbumDTO> albumsToDelete = apiDiscogsService.getAlbumsToDelete(albumsDiscogs, albumsCollection);
		Map<String, Object> result = apiDiscogsService.getAlbumsToReallyDelete(albumsToDelete, swapAlbums);
		List<AlbumDTO> albumsToReallyDelete = (List<AlbumDTO>) result.get("albumsToDelete");
		List<SwapAlbum> albumsImpossibleToDelete = (List<SwapAlbum>) result.get("albumsToDelete");
		
		System.out.println("ALBUMS A AJOUTER: "+albumsToAdd.size());
		System.out.println("ALBUMS A SUPPRIMER: "+albumsToDelete.size());
		System.out.println("ALBUMS A VRAIMENT SUPPRIMER: "+albumsToReallyDelete.size());
		System.out.println("ALBUMS IMPOSSIBLE A SUPPRIMER: "+albumsImpossibleToDelete.size());
		
		// UPDATE DB
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
		
		// CHECK ERRORS AND GET A NOTIFICATION
		if (albumsImpossibleToDelete.size() != 0) {
			errorMsg = "Certains albums n'ont pas pu être supprimés de la collection alors qu'ils ne sont plus présents"
					+ " dans ta collection discogs car ils sont toujours proposés à l'échange:";
			albumsImpossibleToDelete.forEach(item -> 
				errorMsg = errorMsg.concat("\n - "+item.getAlbum().getArtist()+" - "+item.getAlbum().getAlbumName()));
			notification = notificationService.getNotification(user, NotificationTypeEnum.Error_Synchro_Collection, errorMsg);
			notificationService.createUpdateEntity(notification);	
		}
		
		mav = mavUtil.mySwax(user);
		mav.getModel().put("errorMsg", errorMsg);
		
		return mav;
	}
	
	@RequestMapping(value="/synchronizeWantlistWithDiscogs", method = RequestMethod.GET)
	public ModelAndView synchronizeWantlistWithDiscogs(ModelAndView mav) {

		logger.debug(this.getClass().getName()+this.getClass()+": synchronizeWantlistWithDiscogs");

		User user = sessionUser.getSessionUser();
		List<Want> wantlist = new ArrayList<Want>();
		errorMsg = "";
		
		try{
			wantlist = apiDiscogsService.getWantListFromUserName(user.getUserName());	
		}
		catch(Exception e){
			errorMsg = "Erreur dans la synchronisation de la wantlist avec Discogs"+e.getCause().getMessage();
			notification = notificationService.getNotification(user, NotificationTypeEnum.Error_Synchro_Wantlist, errorMsg);
			notificationService.createUpdateEntity(notification);
			mav = mavUtil.mySwax(user);
			mav.getModel().put("errorMsg", errorMsg);
			return mav;
		}

		List<AlbumDiscogs> albumsDiscogs = apiDiscogsService.getAlbumsWantListFromReleases(wantlist);
		albumsDiscogs = albumDiscogsService.trimAlbumsDiscogsAPI(albumsDiscogs);
		
		List<AlbumWantlistDTO> albumsWantlist = userWantlistSession.getUserWantlist();
		
		// ALBUMS TO ADD, DELETE
		List<AlbumDiscogs> albumsToAdd = apiDiscogsService.getWantlistAlbumsToAdd(albumsDiscogs, albumsWantlist);
		List<AlbumWantlistDTO> albumsToDelete = apiDiscogsService.getWantlistAlbumsToDelete(albumsDiscogs, albumsWantlist);
		
		System.out.println("ALBUMS A AJOUTER: "+albumsToAdd.size());
		System.out.println("ALBUMS A SUPPRIMER: "+albumsToDelete.size());
		
		// UPDATE DB
		albumService.updateAlbumTable(albumsToAdd);
		albumWantlistService.createUserWantlist(user, albumsToAdd);
		albumWantlistService.delete(albumsToDelete);
		
		mav = mavUtil.mySwax(user);
		mav.getModel().put("errorMsg", errorMsg);
		
		return mav;
	}


}