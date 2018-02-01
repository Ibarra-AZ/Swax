package swax.web.mav.utils;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import swax.web.form.PojoModelImportCollectionForm;
import swax.web.form.PojoModelImportWantlistForm;
import swax.web.form.PojoModelLoginForm;
import swax.webservice.entity.user.User;
import swax.webservice.service.user.IUserService;

/**
 * 
 * @author Matthieu Ibarra
 *
 */

@Service("mavService")
public class MavUtil {
	
	private Logger logger = Logger.getLogger(MavUtil.class);
	
	@Autowired
	private IUserService userService = null;

	public ModelAndView mySwax(User user) {
		
		ModelAndView mav = new ModelAndView();
		Map<String, Object> mapInitUser;
		
		// Controls if user is still connected
		try {
			mapInitUser = userService.initUser(user);
		} catch (Exception e) {
			logger.warn(this.getClass().getName()+": User has been disconnected");
			String errorMsg = "Your session has expired. Please log in again.";
			PojoModelLoginForm loginForm = new PojoModelLoginForm();
			loginForm.setErrorMsg(errorMsg);
			mav.getModel().put("loginModelAttribute", loginForm);
			mav.setViewName("login/login");
			return mav;			
		}
		
		mav.getModel().put("hasCollection", mapInitUser.get("hasCollection"));
		mav.getModel().put("userCollection", mapInitUser.get("userCollection"));
		mav.getModel().put("hasWantlist", mapInitUser.get("hasWantlist"));
		mav.getModel().put("userWantlist", mapInitUser.get("userWantlist"));
		mav.getModel().put("latestAdditions", mapInitUser.get("latestAdditions"));
		mav.getModel().put("hasSwapProposition", mapInitUser.get("hasSwapProposition"));
		mav.getModel().put("userSwapPropositions", mapInitUser.get("userSwapPropositions"));
		mav.getModel().put("perfectMatchesMap", mapInitUser.get("perfectMatchesMap"));
		
		if (!(boolean) mapInitUser.get("hasCollection")) {
			mav.getModel().put("importCollectionModelAttribute", new PojoModelImportCollectionForm());
		}
		if (!(boolean) mapInitUser.get("hasWantlist")) {
			mav.getModel().put("importWantlistModelAttribute", new PojoModelImportWantlistForm());		
		}
		
		mav.setViewName("user/mySwax");
		
		return mav;		
	}


}
