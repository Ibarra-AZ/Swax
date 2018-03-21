package swax.web.controller.user;
import org.apache.log4j.Logger;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.ui.ModelMap;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestMethod;import org.springframework.web.bind.annotation.RequestParam;import org.springframework.web.servlet.ModelAndView;import swax.web.component.sessionscope.HasCollection;import swax.web.component.sessionscope.SessionUser;import swax.web.form.PojoModelSwapAlbumForm;import swax.webservice.dto.AlbumDTO;import swax.webservice.entity.album.AlbumCollected;import swax.webservice.entity.album.SwapAlbum;import swax.webservice.entity.user.User;import swax.webservice.service.album.IAlbumCollectedService;import swax.webservice.service.album.IAlbumDiscogsService;import swax.webservice.service.album.ISwapAlbumService;
@Controllerpublic class CollectionController {
	@Autowired	private IAlbumCollectedService albumCollectedService = null;		@Autowired	IAlbumDiscogsService albumDiscogsService = null;		@Autowired	private ISwapAlbumService swapAlbumService = null;		@Autowired	private HasCollection hasCollectionSession;		@Autowired	private SessionUser sessionUser;		private Logger logger = Logger.getLogger(this.getClass());		String errorMsg = "";		@RequestMapping(value="/swapAlbum", method = RequestMethod.GET)	public ModelAndView importDiscogsCollection(@RequestParam(value="albumId") final String albumId, 			ModelAndView mav, ModelMap model) {				logger.debug(this.getClass().getName()+this.getClass()+": importDiscogsCollection");		System.out.println("Session Scope: hasCollection = "+hasCollectionSession.isHasCollection());				User user = sessionUser.getSessionUser();		AlbumDTO albumSelected = null;		AlbumCollected albumCollected = albumCollectedService.findByAlbumCollectedId(albumId);		albumSelected = albumCollectedService.getAlbumDTO(albumCollected);				// Controls if the user has the right to display the album selected by the albumId//		if (albumCollected.getUser().getUserId() != user.getUserId()) {//			errorMsg = "This album is not in your collection. You don't have the right to see or modify it.";//			mav = mavUtil.mySwaxUsingSession(user);//			mav.getModel().put("errorMsg", errorMsg);//			return mav;//		}				SwapAlbum swapAlbum;				try {			swapAlbum = swapAlbumService.findByAlbumCollected(albumCollected);			mav.getModel().put("imgURL", swapAlbum.getImgName());			mav.getModel().put("waxValue", swapAlbum.getWaxValue());			mav.getModel().put("mediaGrading", swapAlbum.getMediaGrading());			mav.getModel().put("sleeveGrading", swapAlbum.getSleeveGrading());			mav.getModel().put("description", swapAlbum.getDescription());		} catch (Exception e) {			mav.getModel().put("imgURL", "");			mav.getModel().put("waxValue", "");		}				mav.getModel().put("album", albumSelected);		PojoModelSwapAlbumForm swapAlbumForm = new PojoModelSwapAlbumForm();		mav.getModel().put("swapAlbumModelAttribute", swapAlbumForm);		mav.getModel().put("user", user);		mav.setViewName("user/swapAlbum");				return mav;	}
}