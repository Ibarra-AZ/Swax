package swax.web.controller.user;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

//	@ExceptionHandler(MultipartException.class)
//	public String handleError(MultipartException e, RedirectAttributes redirectAttributes) {
//        redirectAttributes.addFlashAttribute("errorMsg", e.getCause().getMessage());
//        return "redirect:swapAlbum?albumId="+swapAlbumForm.getAlbumId();
//    }
	

}
