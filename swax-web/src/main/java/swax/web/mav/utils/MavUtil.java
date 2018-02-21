package swax.web.mav.utils;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import swax.web.form.PojoModelImportCollectionForm;
import swax.web.form.PojoModelImportWantlistForm;
import swax.web.form.PojoModelLoginForm;
import swax.webservice.entity.user.User;
import swax.webservice.service.album.ISwapAlbumService;
import swax.webservice.service.user.IUserService;

/**
 * 
 * @author Matthieu Ibarra
 *
 */

@Service("mavService")
public class MavUtil {
	
	private Logger logger = Logger.getLogger(MavUtil.class);
	
	@Value("${number.max.users}")
	private String maximumUsersProp;
	
	@Autowired
	private IUserService userService = null;
	
	@Autowired
	private ISwapAlbumService swapAlbumService = null;

	public ModelAndView mySwax(User user, HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		Map<String, Object> mapInitUser;
		
		// Controls if user is still connected
		try {
			mapInitUser = userService.initUser(user);
		} catch (Exception e) {
			logger.warn(this.getClass().getName()+": User has been disconnected");
			e.printStackTrace();
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
		mav.getModel().put("possibleSwaps", mapInitUser.get("possibleSwaps"));
		mav.getModel().put("hasSwapProposition", mapInitUser.get("hasSwapProposition"));
		mav.getModel().put("userSwapPropositions", mapInitUser.get("userSwapPropositions"));
		mav.getModel().put("perfectMatchesMap", mapInitUser.get("perfectMatchesMap"));
		
		request = this.initSession(mav, request);
		
		if (!(boolean) mapInitUser.get("hasCollection")) {
			mav.getModel().put("importCollectionModelAttribute", new PojoModelImportCollectionForm());
		}
		if (!(boolean) mapInitUser.get("hasWantlist")) {
			mav.getModel().put("importWantlistModelAttribute", new PojoModelImportWantlistForm());		
		}
		
		mav.setViewName("user/mySwax");
		
		return mav;		
	}
	
	public ModelAndView mySwaxUsingSession(User user, HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		user = (User) request.getSession().getAttribute("user");
		
		// Controls if user is still connected
		if (user==null) {
			logger.warn(this.getClass().getName()+": User has been disconnected");
			String errorMsg = "Your session has expired. Please log in again.";
			PojoModelLoginForm loginForm = new PojoModelLoginForm();
			loginForm.setErrorMsg(errorMsg);
			mav.getModel().put("loginModelAttribute", loginForm);
			mav.setViewName("login/login");
			return mav;			
		} else {
			mav = this.initMavWithSession(mav, request);
			mav.setViewName("user/mySwax");
			return mav;
		}
	
	}
	
	public HttpServletRequest initSession(ModelAndView mav, HttpServletRequest request) {
		request.getSession().setAttribute("userCollection", mav.getModel().get("userCollection"));
		request.getSession().setAttribute("userWantlist", mav.getModel().get("userWantlist"));
		request.getSession().setAttribute("hasCollection", mav.getModel().get("hasCollection"));
		request.getSession().setAttribute("hasWantlist", mav.getModel().get("hasWantlist"));
		request.getSession().setAttribute("possibleSwaps", mav.getModel().get("possibleSwaps"));
		request.getSession().setAttribute("latestAdditions", mav.getModel().get("latestAdditions"));
		request.getSession().setAttribute("hasSwapProposition", mav.getModel().get("hasSwapProposition"));
		request.getSession().setAttribute("userSwapPropositions", mav.getModel().get("userSwapPropositions"));
		request.getSession().setAttribute("perfectMatchesMap", mav.getModel().get("perfectMatchesMap"));
		return request;		
	}
	
	public ModelAndView initMavWithSession (ModelAndView mav, HttpServletRequest request) {
		mav.getModel().put("hasCollection", request.getSession().getAttribute("hasCollection"));
		mav.getModel().put("userCollection", request.getSession().getAttribute("userCollection"));
		mav.getModel().put("hasWantlist", request.getSession().getAttribute("hasWantlist"));
		mav.getModel().put("userWantlist", request.getSession().getAttribute("userWantlist"));
		mav.getModel().put("possibleSwaps", request.getSession().getAttribute("possibleSwaps"));
		mav.getModel().put("latestAdditions", request.getSession().getAttribute("latestAdditions"));
		mav.getModel().put("hasSwapProposition", request.getSession().getAttribute("hasSwapProposition"));
		mav.getModel().put("userSwapPropositions", request.getSession().getAttribute("userSwapPropositions"));
		mav.getModel().put("perfectMatchesMap", request.getSession().getAttribute("perfectMatchesMap"));
		return mav;
	}
	
	public ModelAndView initStartCounts(ModelAndView mav) {
		
		int countUsers = userService.countUsers();		
		int countSwaps = swapAlbumService.countSwaps();
		
		mav.getModel().put("maximumUsers", Integer.parseInt(maximumUsersProp));
		mav.getModel().put("countSwaps", countSwaps);
		mav.getModel().put("countUsers", countUsers);
		
		return mav;
	}

}