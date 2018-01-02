package swax.web.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import swax.web.form.PojoModelRegisterForm;
import swax.web.form.PojoModelLoginForm;
@Controllerpublic class LoginController {
//	@Autowired//	private IUserService userService = null;
	@RequestMapping(value="/")	public String loadSwax(Model model, PojoModelLoginForm loginForm) {		model.addAttribute("loginModelAttribute", loginForm);		return "login";	}
	@RequestMapping(value="/login")	public String loadLoginPage(Model model, PojoModelLoginForm loginForm) {		model.addAttribute("loginModelAttribute", loginForm);		return "login";	}
	@RequestMapping(value="/register")	public String loadRegisterPage(Model model, PojoModelRegisterForm registerForm) {		model.addAttribute("registerModelAttribute", registerForm);		return "register";	}}