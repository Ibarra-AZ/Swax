package swax.web.controller.user;
import java.io.IOException;import java.util.Date;import javax.servlet.http.HttpServletRequest;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.ModelAttribute;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestMethod;import org.springframework.web.bind.annotation.RequestParam;import org.springframework.web.multipart.MultipartFile;import org.springframework.web.servlet.ModelAndView;import swax.web.form.PojoModelSwapAlbumForm;import swax.web.mav.utils.MavUtil;import swax.webservice.entity.album.AlbumCollected;import swax.webservice.entity.album.SwapAlbum;import swax.webservice.entity.user.User;import swax.webservice.service.album.IAlbumCollectedService;import swax.webservice.service.album.ISwapAlbumService;import swax.webservice.tools.DateUtils;import swax.webservice.tools.FilesTools;
@Controllerpublic class SwapAlbumController {
	@Autowired	private IAlbumCollectedService albumCollectedService;		@Autowired	private ISwapAlbumService swapAlbumService;		@Autowired	private MavUtil mavUtil = null;	
	@RequestMapping(value="/saveAndSwapAlbum", method = RequestMethod.POST)	public ModelAndView saveAndSwapAlbum(@RequestParam(value="albumToSwap") final boolean albumToSwap, 			@ModelAttribute(value="swapAlbumModelAttribute" ) final PojoModelSwapAlbumForm swapAlbumForm, 			HttpServletRequest request, ModelAndView mav) throws IOException {				User user = (User) request.getSession().getAttribute("user");		AlbumCollected albumCollected = albumCollectedService.findByAlbumCollectedId(swapAlbumForm.getAlbumId());		SwapAlbum swapAlbum;				// Generation of the name of the image uploaded and upload		String imgFileName = albumCollected.getAlbumCollectedId()+"-"+new Date().getTime();		MultipartFile file = swapAlbumForm.getImgFilePath();			String pathResult = FilesTools.uploadImg(file, imgFileName, request);				try {			swapAlbum = swapAlbumService.findByAlbumCollected(albumCollected);			swapAlbum.setSwapAlbumId(swapAlbum.getSwapAlbumId());		} catch (Exception e) {			swapAlbum = new SwapAlbum();		}				swapAlbum.setAlbumCollected(albumCollected);		swapAlbum.setAlbum(albumCollected.getAlbum());		swapAlbum.setUser(user);		swapAlbum.setMediaGrading(swapAlbumForm.getMediaGrading());		swapAlbum.setSleeveGrading(swapAlbumForm.getSleeveGrading());		swapAlbum.setWaxValue(swapAlbumForm.getWaxValue());		swapAlbum.setDescription(swapAlbumForm.getDescription());		swapAlbum.setDateAdded(DateUtils.dateToString(new Date()));		swapAlbum.setAlbumToSwap(albumToSwap);				if (!pathResult.isEmpty()) {			String filePath = request.getSession().getServletContext().getRealPath("img/swapAlbums/"+swapAlbum.getImgName());			FilesTools.deleteFile(filePath);			swapAlbum.setImgName(imgFileName+".jpg");		}				// Here to face synchronization issues		try {			Thread.sleep(5000);		} catch (InterruptedException e) {			// TODO Auto-generated catch block			e.printStackTrace();		}				swapAlbumService.createUpdateEntity(swapAlbum);				return mav = mavUtil.mySwax(user);	}	
}