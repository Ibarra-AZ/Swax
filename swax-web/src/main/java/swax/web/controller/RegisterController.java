package swax.web.controller;
import javax.servlet.http.HttpServletRequest;import javax.validation.Valid;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.ui.ModelMap;import org.springframework.validation.BindingResult;import org.springframework.web.bind.annotation.ModelAttribute;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestMethod;import swax.web.form.PojoModelRegisterForm;import swax.webservice.entity.User;import swax.webservice.service.IUserService;
@Controllerpublic class RegisterController {
	@Autowired	private IUserService userService = null;
	@RequestMapping(value="/registerAction", method = RequestMethod.POST)	public String registerUser(@Valid @ModelAttribute(value="registerModelAttribute" ) final PojoModelRegisterForm registerForm,             final BindingResult pBindingResult, HttpServletRequest request, final ModelMap pModel) {				User user = new User(registerForm.getEmail(), registerForm.getPassword(), registerForm.getUserName(),				registerForm.getCountry());		userService.createUpdateEntity(user);		request.getSession().setAttribute("user", user);		return "mySwax";			}
}