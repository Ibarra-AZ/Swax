package swax.web.controller.user;
import java.io.IOException;import java.util.ArrayList;import java.util.Date;import java.util.List;import javax.servlet.http.HttpServletRequest;import org.apache.log4j.Logger;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.ModelAttribute;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestMethod;import org.springframework.web.bind.annotation.RequestParam;import org.springframework.web.multipart.MultipartFile;import org.springframework.web.servlet.ModelAndView;import org.springframework.web.servlet.mvc.support.RedirectAttributes;import swax.web.form.PojoModelSwapAlbumForm;import swax.web.mav.utils.MavUtil;import swax.webservice.entity.album.AlbumCollected;import swax.webservice.entity.album.SwapAlbum;import swax.webservice.entity.user.User;import swax.webservice.service.album.IAlbumCollectedService;import swax.webservice.service.album.ISwapAlbumService;import swax.webservice.tools.DateUtils;import swax.webservice.tools.FilesTools;/** *  * @author Matthieu Ibarra * Controller for: * /saveAndSwapAlbum * */
@Controllerpublic class SwapAlbumController {		private String errMsg = null;	@Autowired	private ISwapAlbumService swapAlbumService;		@Autowired	private IAlbumCollectedService albumCollectedService;		@Autowired	private MavUtil mavUtil = null;		private Logger logger = Logger.getLogger(this.getClass());		@SuppressWarnings("unchecked")	@RequestMapping(value="/saveAndSwapAlbum", method = RequestMethod.POST)	public ModelAndView saveAndSwapAlbum(@RequestParam(value="albumToSwap") final boolean albumToSwap, 			@ModelAttribute(value="swapAlbumModelAttribute" ) final PojoModelSwapAlbumForm swapAlbumForm, 			HttpServletRequest request, RedirectAttributes redirectAttributes, ModelAndView mav) {				logger.debug(this.getClass().getName()+": saveAndSwapAlbum");		System.out.println("Début saveAndSwap: "+Thread.currentThread().getName());				User user = (User) request.getSession().getAttribute("user");		AlbumCollected albumCollected = albumCollectedService.findByAlbumCollectedId(swapAlbumForm.getAlbumId());		SwapAlbum swapAlbum;				// Generation of the name of the image uploaded and upload		String imgFileName = albumCollected.getAlbumCollectedId()+"-"+new Date().getTime();		MultipartFile file = swapAlbumForm.getImgFilePath();					try {			System.out.println("SaveAndSwap - envoi à FileTools: "+Thread.currentThread().getName());			errMsg = FilesTools.uploadImg(file, imgFileName, request);		} catch (IOException e1) {			e1.printStackTrace();		}				// Gets the album if it has been already proposed for swapping		try {			swapAlbum = swapAlbumService.findByAlbumCollected(albumCollected);			swapAlbum.setSwapAlbumId(swapAlbum.getSwapAlbumId());		} catch (Exception e) {			swapAlbum = new SwapAlbum();		}				// Updates the swapAlbum		swapAlbum.setAlbumCollected(albumCollected);		swapAlbum.setAlbum(albumCollected.getAlbum());		swapAlbum.setUser(user);		swapAlbum.setMediaGrading(swapAlbumForm.getMediaGrading());		swapAlbum.setSleeveGrading(swapAlbumForm.getSleeveGrading());		swapAlbum.setWaxValue(swapAlbumForm.getWaxValue());		swapAlbum.setDescription(swapAlbumForm.getDescription());		swapAlbum.setDateAdded(DateUtils.dateToString(new Date()));		swapAlbum.setAlbumToSwap(albumToSwap);				//Updates the album in collection		albumCollected.setMediaGrading(swapAlbumForm.getMediaGrading());		albumCollected.setSleeveGrading(swapAlbumForm.getSleeveGrading());		albumCollected.setNotes(swapAlbumForm.getDescription());				// if the album was proposed for swapping in the past and the image wasn't updated then 		// it gets the image used before		if ((errMsg.isEmpty()) || (errMsg.equals("No image") && (swapAlbum.getImgName()!=null))) {			if (errMsg.isEmpty()) {				String filePath = request.getSession().getServletContext().getRealPath("img/swapAlbums/"+swapAlbum.getImgName());				FilesTools.deleteFile(filePath);				swapAlbum.setImgName(imgFileName+".jpg");			}						System.out.println("saveAndSwap - Création BDD: "+Thread.currentThread().getName());			swapAlbumService.createUpdateEntity(swapAlbum);			albumCollectedService.createUpdateEntity(albumCollected);						// Updates the list of albums to swap in the session			List<SwapAlbum> userSwapPropositions = (List<SwapAlbum>) request.getSession().getAttribute("userSwapPropositions");			if (userSwapPropositions == null) {				userSwapPropositions = new ArrayList<SwapAlbum>();			}			if(userSwapPropositions.contains(swapAlbum)) {				int index = userSwapPropositions.indexOf(swapAlbum);				userSwapPropositions.remove(index);			}						if (albumToSwap) {				userSwapPropositions.add(swapAlbum);				// Here to face synchronization issues in case we add a new album to swap//				try {//					Thread.sleep(4600);//				} catch (InterruptedException e) {//					e.printStackTrace();//				}			}						request.getSession().setAttribute("userSwapPropositions", userSwapPropositions);						mav = mavUtil.mySwaxUsingSession(user, request);		}				// Upload has an error		else {			System.out.println(errMsg);			redirectAttributes.addFlashAttribute("errorMsg", errMsg);			mav.setViewName("redirect:swapAlbum?albumId="+swapAlbumForm.getAlbumId());		}				System.out.println("saveAndSwap - Retour mav: "+Thread.currentThread().getName());				return mav;			}	
}