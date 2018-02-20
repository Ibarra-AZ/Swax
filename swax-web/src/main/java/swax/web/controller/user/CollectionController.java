package swax.web.controller.user;
import javax.servlet.http.HttpServletRequest;import org.apache.log4j.Logger;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestMethod;import org.springframework.web.bind.annotation.RequestParam;import org.springframework.web.servlet.ModelAndView;import swax.web.form.PojoModelSwapAlbumForm;import swax.web.mav.utils.MavUtil;import swax.webservice.dto.AlbumDTO;import swax.webservice.entity.album.AlbumCollected;import swax.webservice.entity.album.SwapAlbum;import swax.webservice.entity.user.User;import swax.webservice.service.album.IAlbumCollectedService;import swax.webservice.service.album.IAlbumDiscogsService;import swax.webservice.service.album.ISwapAlbumService;
@Controllerpublic class CollectionController {
	@Autowired	private IAlbumCollectedService albumCollectedService = null;		@Autowired	IAlbumDiscogsService albumDiscogsService = null;		@Autowired	private ISwapAlbumService swapAlbumService = null;		@Autowired	private MavUtil mavUtil = null;		private Logger logger = Logger.getLogger(this.getClass());		@RequestMapping(value="/swapAlbum", method = RequestMethod.GET)	public ModelAndView importDiscogsCollection(@RequestParam(value="albumId") final String albumId, 			HttpServletRequest request, ModelAndView mav) {				logger.debug(this.getClass().getName()+this.getClass()+": importDiscogsCollection");				User user = (User) request.getSession().getAttribute("user");		AlbumDTO albumSelected = null;		AlbumCollected albumCollected = albumCollectedService.findByAlbumCollectedId(albumId);		albumSelected = albumCollectedService.getAlbumDTO(albumCollected);				// Controls if the user has the right to display the album selected by the albumId		String errorMsg = "";		if (albumCollected.getUser().getUserId() != user.getUserId()) {			errorMsg = "This album is not in your collection. You don't have the right to see or modify it.";			mav = mavUtil.mySwaxUsingSession(user, request);			mav.getModel().put("errorMsg", errorMsg);			return mav;		}				SwapAlbum swapAlbum;		try {			swapAlbum = swapAlbumService.findByAlbumCollected(albumCollected);			mav.getModel().put("imgURL", swapAlbum.getImgName());			mav.getModel().put("waxValue", swapAlbum.getWaxValue());			mav.getModel().put("mediaGrading", swapAlbum.getMediaGrading());			mav.getModel().put("sleeveGrading", swapAlbum.getSleeveGrading());			mav.getModel().put("description", swapAlbum.getDescription());		} catch (Exception e) {			mav.getModel().put("imgURL", "");			mav.getModel().put("waxValue", "");		}				mav.getModel().put("album", albumSelected);		PojoModelSwapAlbumForm swapAlbumForm = new PojoModelSwapAlbumForm();		mav.getModel().put("swapAlbumModelAttribute", swapAlbumForm);		mav.setViewName("user/swapAlbum");				return mav;	}
}