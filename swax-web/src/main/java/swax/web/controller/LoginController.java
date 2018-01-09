package swax.web.controller;
import java.util.List;import javax.servlet.http.HttpServletRequest;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.ModelAttribute;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestMethod;import org.springframework.web.servlet.ModelAndView;import swax.web.form.PojoModelChangePasswordForm;import swax.web.form.PojoModelLoginForm;import swax.web.form.PojoModelRegisterForm;import swax.webservice.dto.AlbumDTO;import swax.webservice.entity.User;import swax.webservice.service.IUserService;
@Controllerpublic class LoginController {
	@Autowired	private IUserService userService = null;
	@RequestMapping(value="/")	public ModelAndView loadSwax(ModelAndView mav, PojoModelLoginForm loginForm) {		String errorMsg="";		loginForm.setErrorMsg(errorMsg);		mav.getModel().put("loginModelAttribute", loginForm);		mav.setViewName("login/login");		return mav;	}
	@RequestMapping(value="/loginAction")	public ModelAndView login(@ModelAttribute(value="loginModelAttribute" ) PojoModelLoginForm loginForm,             HttpServletRequest request, ModelAndView mav) {				User user;		String errorMsg="";		String infoMsg="";		boolean hasCollection = false;				try {			user = this.userService.findByEmailAndPassword(loginForm.getEmail(), loginForm.getPassword());		} catch (Exception e) {//			TODO Créer et gérer les exceptions			user = null;			System.out.println(e.toString());		}				if (user != null){			request.getSession().setAttribute("user", user);			List<AlbumDTO> albumsDTO = user.getAlbumsDTO();			if (albumsDTO.size() == 0) {				infoMsg = "It seems that you don't have any collection.";			} else {				infoMsg = "You can now browse your collection and start to swap your wax ;-)";				hasCollection = true;				mav.getModel().put("userCollection", albumsDTO);			}			mav.setViewName("mySwax");		} else {			errorMsg="Please enter a valid identification";			loginForm.setErrorMsg(errorMsg);			request.getSession().setAttribute("user", null);			mav.getModel().put("loginModelAttribute", loginForm);			mav.setViewName("login/login");		}				mav.getModel().put("infoMsg", infoMsg);		mav.getModel().put("hasCollection", hasCollection);				return mav;	}		@RequestMapping(value="/login")	public ModelAndView loadLoginPage(ModelAndView mav, PojoModelLoginForm loginForm) {		String errorMsg="";		loginForm.setErrorMsg(errorMsg);		mav.getModel().put("loginModelAttribute", loginForm);		mav.setViewName("login/login");		return mav;	}		@RequestMapping(value="/logout", method = RequestMethod.GET)	public ModelAndView logout(ModelAndView mav, HttpServletRequest request) {		request.getSession().setAttribute("user", null);		request.getSession().setAttribute("errorMsg", "");		mav.setViewName("login/login");		mav.getModel().put("loginModelAttribute", new PojoModelLoginForm());		return mav;	}
	@RequestMapping(value="/register")	public ModelAndView loadRegisterPage(ModelAndView mav, PojoModelRegisterForm registerForm) {		mav.getModel().put("registerModelAttribute", registerForm);		mav.setViewName("login/register");		return mav;	}		@RequestMapping(value="/changePassword")	public ModelAndView loadChangePasswordPage(ModelAndView mav, PojoModelChangePasswordForm changePasswordForm) {		mav.getModel().put("changePasswordModelAttribute", changePasswordForm);		mav.setViewName("login/changePassword");		return mav;	}	}