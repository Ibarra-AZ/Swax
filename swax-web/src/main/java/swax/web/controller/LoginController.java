package swax.web.controller;
import javax.servlet.http.HttpServletRequest;import javax.validation.Valid;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.ui.Model;import org.springframework.validation.BindingResult;import org.springframework.web.bind.annotation.ModelAttribute;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestMethod;import org.springframework.web.servlet.ModelAndView;import swax.web.form.PojoModelChangePasswordForm;import swax.web.form.PojoModelLoginForm;import swax.web.form.PojoModelRegisterForm;import swax.webservice.entity.AlbumCollected;import swax.webservice.entity.User;import swax.webservice.service.IUserService;
@Controllerpublic class LoginController {
	@Autowired	private IUserService userService = null;
	@RequestMapping(value="/")	public String loadSwax(Model model, PojoModelLoginForm loginForm) {		String errorMsg="";		loginForm.setErrorMsg(errorMsg);		model.addAttribute("loginModelAttribute", loginForm);		return "login";	}
	@RequestMapping(value="/loginAction")	public String login(@Valid @ModelAttribute(value="loginModelAttribute" ) PojoModelLoginForm loginForm,             BindingResult pBindingResult, HttpServletRequest request, Model model) {		User user;		String errorMsg="";		try {			user = this.userService.findByEmailAndPassword(loginForm.getEmail(), loginForm.getPassword());		} catch (Exception e) {//			TODO Créer et gérer les exceptions			user = null;			System.out.println(e.toString());		}				if (user != null){			request.getSession().setAttribute("user", user);	        model.addAttribute("user", user);			model.addAttribute("userCollection", user.getCollection());			for (AlbumCollected album: user.getCollection()) {				System.out.println(album.getAlbum().getAlbumName());				}			return "mySwax";		} else {			errorMsg="Please enter a valid identification";			loginForm.setErrorMsg(errorMsg);			request.getSession().setAttribute("user", null);			model.addAttribute("loginModelAttribute", loginForm);		}		return "login";	}		@RequestMapping(value="/login")	public String loadLoginPage(Model model, PojoModelLoginForm loginForm) {		String errorMsg="";		loginForm.setErrorMsg(errorMsg);		model.addAttribute("loginModelAttribute", loginForm);		return "login";	}		@RequestMapping(value="/logout", method = RequestMethod.GET)	public ModelAndView logout(HttpServletRequest request) {		request.getSession().setAttribute("user", null);		request.getSession().setAttribute("errorMsg", "");		ModelAndView mav = new ModelAndView("login");		mav.getModel().put("loginModelAttribute", new PojoModelLoginForm());		return mav;	}
	@RequestMapping(value="/register")	public String loadRegisterPage(Model model, PojoModelRegisterForm registerForm) {		model.addAttribute("registerModelAttribute", registerForm);		return "register";	}		@RequestMapping(value="/changePassword")	public ModelAndView loadChangePasswordPage(Model model, PojoModelChangePasswordForm changePasswordForm) {		model.addAttribute("changePasswordModelAttribute", changePasswordForm);		ModelAndView mav = new ModelAndView("changePassword");		return mav;	}	}