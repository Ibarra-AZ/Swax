package swax.web.controller.user;
import javax.servlet.http.HttpServletRequest;import javax.validation.Valid;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.ui.ModelMap;import org.springframework.validation.BindingResult;import org.springframework.web.bind.annotation.ModelAttribute;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestMethod;import org.springframework.web.servlet.ModelAndView;import swax.web.form.PojoModelRegisterForm;import swax.web.mav.utils.MavUtil;import swax.webservice.entity.user.User;import swax.webservice.service.album.IAlbumDiscogsService;import swax.webservice.service.user.IUserService;/** *  * @author Matthieu Ibarra * */
@Controllerpublic class UserProfileController {
	@Autowired	private IUserService userService;		@Autowired	IAlbumDiscogsService albumDiscogsService;		@Autowired	private MavUtil mavUtil = null;
	@RequestMapping(value="/loadUserProfilePage", method = RequestMethod.GET)	public ModelAndView changeUserProfile(@Valid @ModelAttribute(value="registerModelAttribute") 		final PojoModelRegisterForm registerForm, 		final BindingResult pBindingResult, HttpServletRequest request, final ModelMap pModel) {				ModelAndView mav = new ModelAndView();		User user = (User) request.getSession().getAttribute("user");				registerForm.setEmail(user.getEmail());		registerForm.setUserName(user.getUserName());		registerForm.setCountry(user.getCountry());		registerForm.setDiscogsName(user.getDiscogsName());				mav.getModel().put("registerModelAttribute", registerForm);		mav.setViewName("user/changeProfile");				return mav;	}		@RequestMapping(value="/changeProfileAction", method = RequestMethod.POST)	public ModelAndView changeProfileAction(@Valid @ModelAttribute(value="registerModelAttribute") 		final PojoModelRegisterForm registerForm, 		final BindingResult pBindingResult, HttpServletRequest request, ModelAndView mav) {				// TODO Contrôles et avertissement en cas de changement de Discogs User Name		// Si changement de Discogs User Name confirmé, recharger collection et wantlist		// Et gros ménage et vérifs à faire sur les albums en échange...				User user = (User) request.getSession().getAttribute("user");				user.setUserName(registerForm.getUserName());		user.setEmail(registerForm.getEmail());		user.setPassword(registerForm.getPassword());		user.setCountry(registerForm.getCountry());		user.setDiscogsName(registerForm.getDiscogsName());				userService.createUpdateEntity(user);				return mav = mavUtil.mySwax(user);	}		@RequestMapping(value="/backToMySwax")	public ModelAndView backToMySwax(HttpServletRequest request, ModelAndView mav) {		User user = (User) request.getSession().getAttribute("user");		return mav = mavUtil.mySwax(user);	}	
}