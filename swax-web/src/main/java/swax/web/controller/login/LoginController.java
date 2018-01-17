package swax.web.controller.login;
import java.util.Date;import java.util.Map;import javax.servlet.http.HttpServletRequest;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.ModelAttribute;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestMethod;import org.springframework.web.servlet.ModelAndView;import swax.web.form.PojoModelImportCollectionForm;import swax.web.form.PojoModelImportWantlistForm;import swax.web.form.PojoModelLoginForm;import swax.webservice.entity.User;import swax.webservice.entity.UserStatusEnum;import swax.webservice.service.IUserService;import swax.webservice.tools.DateUtils;
@Controllerpublic class LoginController {
	@Autowired	private IUserService userService = null;		@RequestMapping(value="/")	public ModelAndView loadSwax(ModelAndView mav, PojoModelLoginForm loginForm) {		String errorMsg="";		loginForm.setErrorMsg(errorMsg);		mav.getModel().put("loginModelAttribute", loginForm);		mav.setViewName("login/login");		return mav;	}
	@RequestMapping(value="/loginAction")	public ModelAndView login(@ModelAttribute(value="loginModelAttribute" ) PojoModelLoginForm loginForm,             HttpServletRequest request, ModelAndView mav) {				User user;		String errorMsg="";		String infoMsg="";		boolean hasCollection = false;		boolean hasWantlist = false;				try {			user = this.userService.findByEmailAndPassword(loginForm.getEmail(), loginForm.getPassword());		} catch (Exception e) {//			TODO Créer et gérer les exceptions			user = null;			System.out.println(e.toString());		}				// USER EXISTS		if (user != null){			user.setLastConnexion(DateUtils.dateToString(new Date()));			userService.createUpdateEntity(user);						// BANNED USER			if (user.getStatus().equals(UserStatusEnum.Banned.getUserStatus())) {				errorMsg = "There's a problem. This user has been banned from Swax. Please contact Swax administration"						+ " if there's no reason for this situation.";				loginForm.setErrorMsg(errorMsg);				request.getSession().setAttribute("user", null);				mav.getModel().put("loginModelAttribute", loginForm);				mav.setViewName("login/login");			} 						// AUTHORIZED USER			else {			request.getSession().setAttribute("user", user);			return mav = this.mySwax(user);			}				// USER DOESN'T EXIST		} else {			errorMsg="Please enter a valid identification";			loginForm.setErrorMsg(errorMsg);			request.getSession().setAttribute("user", null);			mav.getModel().put("loginModelAttribute", loginForm);			mav.setViewName("login/login");		}				mav.getModel().put("infoMsg", infoMsg);		mav.getModel().put("hasCollection", hasCollection);		mav.getModel().put("hasWantlist", hasWantlist);				return mav;	}		@RequestMapping(value="/login")	public ModelAndView loadLoginPage(ModelAndView mav, PojoModelLoginForm loginForm) {		String errorMsg="";		loginForm.setErrorMsg(errorMsg);		mav.getModel().put("loginModelAttribute", loginForm);		mav.setViewName("login/login");		return mav;	}		@RequestMapping(value="/logout", method = RequestMethod.GET)	public ModelAndView logout(ModelAndView mav, HttpServletRequest request) {		request.getSession().setAttribute("user", null);		request.getSession().setAttribute("errorMsg", "");		mav.setViewName("login/login");		mav.getModel().put("loginModelAttribute", new PojoModelLoginForm());		return mav;	}		private ModelAndView mySwax(User user) {				ModelAndView mav = new ModelAndView();		Map<String, Object> mapInitUser = userService.initUser(user);				mav.getModel().put("hasCollection", mapInitUser.get("hasCollection"));		mav.getModel().put("userCollection", mapInitUser.get("userCollection"));		mav.getModel().put("hasWantlist", mapInitUser.get("hasWantlist"));		mav.getModel().put("userWantlist", mapInitUser.get("userWantlist"));		mav.getModel().put("latestAdditions", mapInitUser.get("latestAdditions"));		if (!(boolean) mapInitUser.get("hasCollection")) {			mav.getModel().put("importCollectionModelAttribute", new PojoModelImportCollectionForm());		}		if (!(boolean) mapInitUser.get("hasWantlist")) {			mav.getModel().put("importWantlistModelAttribute", new PojoModelImportWantlistForm());				}				mav.setViewName("user/mySwax");				return mav;			}	}