package swax.web.controller.advice;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@ExceptionHandler(Exception.class)
	public ModelAndView allExceptionHandler(Exception e) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("errorPage");
		logger.warn("EXCEPTION: "+e.getCause().toString());
		e.printStackTrace();
		return mav;
		
	}

}