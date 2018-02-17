package swax.web.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import swax.web.mav.utils.MavUtil;
import swax.webservice.entity.user.User;
import swax.webservice.service.apiDiscogs.IApiDiscogsService;

@Controller
public class SynchronizeWithDiscogsController {
	
	@Autowired
	private IApiDiscogsService apiDscogsService;
	
	@Autowired
	private MavUtil mavUtil;
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(value="/synchronizeWithDiscogs", method = RequestMethod.GET)
	public ModelAndView synchronizeWithDiscogs(
			HttpServletRequest request, ModelAndView mav) {
		
		logger.debug(this.getClass().getName()+this.getClass()+": synchronizeWithDiscogs");
		
		User user = (User) request.getSession().getAttribute("user");
		
		try{
			apiDscogsService.getCollectionFromUserName(user.getUserName());
			
		}catch(Exception e){
			// TODO : faire marcher l'affichage du message d'erreur
			String errorMsg = "Erreur dans la synchronisation de la collection avec Discogs";
			mav.getModel().put("errorMsg", errorMsg);

		}
		// TODO : rediriger vers la vue d'origine ?
		mav = mavUtil.mySwax(user, request);

		return mav;
	}
	
	
}
