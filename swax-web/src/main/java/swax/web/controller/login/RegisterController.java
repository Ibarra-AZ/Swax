package swax.web.controller.login;
import java.util.Date;import java.util.List;import java.util.Map;import javax.servlet.http.HttpServletRequest;import javax.validation.Valid;import org.apache.log4j.Logger;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.ModelAttribute;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestMethod;import org.springframework.web.servlet.ModelAndView;import swax.web.form.PojoModelRegisterForm;import swax.web.mav.utils.MavUtil;import swax.webservice.entity.album.AlbumDiscogs;import swax.webservice.entity.user.User;import swax.webservice.entity.user.UserStatusEnum;import swax.webservice.service.album.IAlbumCollectedService;import swax.webservice.service.album.IAlbumDiscogsService;import swax.webservice.service.album.IAlbumService;import swax.webservice.service.album.IAlbumWantlistService;import swax.webservice.service.album.ISwapAlbumService;import swax.webservice.service.apiDiscogs.IApiDiscogsService;import swax.webservice.service.user.IUserService;import swax.webservice.tools.DateUtils;/** *  * @author Matthieu Ibarra *  * Controller for: * /register  * /registerAction * /deleteAccount * /deleteAccountConfirm * */
@Controllerpublic class RegisterController {
	@Autowired	private IUserService userService = null;		@Autowired	private IAlbumCollectedService albumCollectedService = null;		@Autowired	private IAlbumWantlistService albumWantlistService = null;		@Autowired	private ISwapAlbumService swapAlbumService = null;		@Autowired	private IApiDiscogsService apiDiscogsService;		@Autowired	private IAlbumDiscogsService albumDiscogsService;		@Autowired	private IAlbumService albumService;		@Autowired	private MavUtil mavUtil = null;		private Logger logger = Logger.getLogger(this.getClass());		/**	 * 	 * @param mav	 * @param registerForm	 * @return ModelAndView mav	 * 	 * @Must go the register view with a register form	 * 	 */	@RequestMapping(value="/register")	public ModelAndView loadRegisterPage(ModelAndView mav, PojoModelRegisterForm registerForm) {				logger.debug(this.getClass().getName()+this.getClass()+": loadRegisterPage");				mav.getModel().put("registerModelAttribute", registerForm);		mav.setViewName("login/register");				return mav;	}	/**	 * MUST create user if user is not already in DB.	 * MUST get collection and wantlist from discogs.	 * @param registerForm	 * @param request	 * @return mav	 */
	@SuppressWarnings("unchecked")	@RequestMapping(value="/registerAction", method = RequestMethod.POST)	public ModelAndView registerUser(@Valid @ModelAttribute(value="registerModelAttribute" ) final PojoModelRegisterForm registerForm, 			HttpServletRequest request) {				logger.debug(this.getClass().getName()+this.getClass()+": registerUser");				String errorMsg = "";		User user;		ModelAndView mav = new ModelAndView();		boolean exception = false;			try {			user = userService.findByEmailOrUserName(registerForm.getEmail(), registerForm.getUserName());		} catch (Exception e) {			// The request returns more than one user			user = null;			exception = true;			errorMsg="This User Name or this Email is already used in Swax.";			registerForm.setEmail("");			registerForm.setUserName("");			mav.setViewName("login/register");			mav.getModel().put("registerModelAttribute", registerForm);			return mav;		}				if (user != null) {			if (user.getEmail().equals(registerForm.getEmail())) {				errorMsg = "A user with the same Email adress has already registered to Swax.";				registerForm.setEmail("");							}			if (user.getUserName().equals(registerForm.getUserName())) {				errorMsg = errorMsg + "\n" + "A user with the same User Name has already registered to Swax.";				registerForm.setUserName("");			}						mav.setViewName("login/register");			mav.getModel().put("registerModelAttribute", registerForm);			return mav;		} 				else if (exception==false) {			user = new User(registerForm.getEmail(), registerForm.getPassword(), registerForm.getUserName(), 					registerForm.getDiscogsName(), registerForm.getCountry(), DateUtils.dateToString(new Date()), 					DateUtils.dateToString(new Date()), UserStatusEnum.Authorized.toString());						Map<String, Object> synchroResult = apiDiscogsService.synchronizeCollectionWithDiscogs(user);						// Syncho SUCCESS			if (synchroResult.get("errorMsg").equals("")) {				userService.createUpdateEntity(user);				List<AlbumDiscogs> albumsDiscogs = (List<AlbumDiscogs>) synchroResult.get("albumsDiscogs");				albumsDiscogs = albumDiscogsService.trimAlbumsDiscogsAPI(albumsDiscogs);				albumService.updateAlbumTable(albumsDiscogs);				albumCollectedService.createUserCollection(user, albumsDiscogs);				mav.getModel().put("user", user);				request.getSession().setAttribute("user", user);				mav = mavUtil.mySwax(user, request);			}			// Synchro FAILURE			else {				registerForm.setErrorMsg(errorMsg);				mav.getModel().put("registerModelAttribute", registerForm);				mav.setViewName("login/register");			}						return mav;		}				errorMsg = "Problème inconnu.";		registerForm.setErrorMsg(errorMsg);		mav.getModel().put("registerModelAttribute", registerForm);		mav.setViewName("login/register");		return mav;					}		/**	 * MUST go to the delete account view	 * @param mav	 * @param request	 * @return mav	 * 	 */	@RequestMapping(value="/deleteAccount", method = RequestMethod.GET)	public ModelAndView deleteAccount(ModelAndView mav, HttpServletRequest request) {		logger.debug(this.getClass().getName()+": deleteAccount");		mav.setViewName("login/deleteAccount");				return mav;	}			/**	 * 	 * @param mav	 * @param request	 * @return mav	 */	@RequestMapping(value="/deleteAccountConfirm", method = RequestMethod.GET)	public ModelAndView deleteAccountConfirm(ModelAndView mav, HttpServletRequest request) {		logger.debug(this.getClass().getName()+": deleteAccountConfirm");		User user = (User) request.getSession().getAttribute("user");		userService.deleteUser(user);		swapAlbumService.deleteByUser(user);		albumWantlistService.deleteByUser(user);		albumCollectedService.deleteByUser(user);		user = null;		request.getSession().setAttribute("user", null);		mav.getModel().put("user", null);		System.out.println("Compte supprimé");		mav.setViewName("login/start");				return mav;	}	
}