package swax.web.controller.user;
import javax.servlet.http.HttpServletRequest;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestMethod;import org.springframework.web.bind.annotation.RequestParam;import org.springframework.web.servlet.ModelAndView;import swax.web.form.PojoModelSwapAlbumForm;import swax.webservice.dto.AlbumDTO;import swax.webservice.entity.AlbumCollected;import swax.webservice.service.IAlbumCollectedService;import swax.webservice.service.IAlbumDiscogsService;
@Controllerpublic class CollectionTableController {
	@Autowired	private IAlbumCollectedService albumCollectedService = null;		@Autowired	IAlbumDiscogsService albumDiscogsService = null;		@RequestMapping(value="/swapAlbum", method = RequestMethod.GET)	public ModelAndView importDiscogsCollection(@RequestParam(value="albumId") final Integer albumId, 			HttpServletRequest request, final ModelAndView mav) {				AlbumDTO albumSelected = null;		AlbumCollected albumCollected = albumCollectedService.findByAlbumCollectedId(albumId);		albumSelected = albumCollectedService.getAlbumDTO(albumCollected);				mav.getModel().put("album", albumSelected);		mav.getModel().put("swapAlbumModelAttribute", new PojoModelSwapAlbumForm());		mav.setViewName("user/swapAlbum");				return mav;	}
}