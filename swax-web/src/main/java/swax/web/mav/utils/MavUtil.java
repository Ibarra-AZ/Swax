package swax.web.mav.utils;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import swax.web.component.sessionscope.HasCollection;
import swax.web.component.sessionscope.HasSwapProposition;
import swax.web.component.sessionscope.HasWantlist;
import swax.web.component.sessionscope.LatestAdditions;
import swax.web.component.sessionscope.PerfectMatchesMap;
import swax.web.component.sessionscope.PossibleSwaps;
import swax.web.component.sessionscope.SessionUser;
import swax.web.component.sessionscope.UserCollection;
import swax.web.component.sessionscope.UserSwapPropositions;
import swax.web.component.sessionscope.UserWantlist;
import swax.web.form.PojoModelImportCollectionForm;
import swax.web.form.PojoModelImportWantlistForm;
import swax.web.form.PojoModelLoginForm;
import swax.webservice.dto.AlbumDTO;
import swax.webservice.dto.AlbumWantlistDTO;
import swax.webservice.dto.LatestAdditionDTO;
import swax.webservice.dto.PossibleSwapDTO;
import swax.webservice.entity.album.SwapAlbum;
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
	
	@Autowired
	private HasCollection hasCollectionSession;
	
	@Autowired
	private HasWantlist hasWantlistSession;
	
	@Autowired
	private HasSwapProposition hasSwapPropositionSession;

	@Autowired
	private LatestAdditions latestAdditionsSession;
	
	@Autowired
	private PerfectMatchesMap perfectMatchesMapSession;
	
	@Autowired
	private PossibleSwaps possibleSwapsSession;
	
	@Autowired
	private UserCollection userCollectionSession;
	
	@Autowired
	private UserSwapPropositions userSwapPropositionsSession;
	
	@Autowired
	private SessionUser sessionUser;
	
	@Autowired
	private UserWantlist userWantlistSession;
	
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
		
		initSession(mapInitUser);
		initMav(mav, mapInitUser);
		
		if (!(boolean) mapInitUser.get("hasCollection")) {
			mav.getModel().put("importCollectionModelAttribute", new PojoModelImportCollectionForm());
		}
		if (!(boolean) mapInitUser.get("hasWantlist")) {
			mav.getModel().put("importWantlistModelAttribute", new PojoModelImportWantlistForm());		
		}
		
		mav.setViewName("user/mySwax");
		
		return mav;
	}
	

	public ModelAndView mySwaxUsingSession(User user) {
		
		ModelAndView mav = new ModelAndView();
		
		user = sessionUser.getSessionUser();
		
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
			mav = this.initMavWithSession(mav);
			mav.setViewName("user/mySwax");
			return mav;
		}
	
	}
	
	@SuppressWarnings("unchecked")
	public void initSession(Map<String, Object> mapInitUser) {
		
		hasCollectionSession.setHasCollection((boolean) mapInitUser.get("hasCollection"));
		hasWantlistSession.setHasWantlist((boolean) mapInitUser.get("hasWantlist"));
		hasSwapPropositionSession.setHasSwapProposition((boolean) mapInitUser.get("hasSwapProposition"));
		latestAdditionsSession.setLatestAdditions((List<LatestAdditionDTO>) mapInitUser.get("latestAdditions"));
		perfectMatchesMapSession.setPerfectMatchesMap((Map<Integer, List<SwapAlbum>>) mapInitUser.get("perfectMatchesMap"));
		possibleSwapsSession.setPossibleSwaps((List<PossibleSwapDTO>) mapInitUser.get("possibleSwaps"));
		userCollectionSession.setUserCollection((List<AlbumDTO>) mapInitUser.get("userCollection"));
		userSwapPropositionsSession.setUserSwapPropositions((List<SwapAlbum>) mapInitUser.get("userSwapPropositions"));
		userWantlistSession.setUserWantlist((List<AlbumWantlistDTO>) mapInitUser.get("userWantlist"));
		
	}
	
	public ModelAndView initMavWithSession (ModelAndView mav) {
		
		mav.getModel().put("hasCollection", hasCollectionSession.isHasCollection());
		mav.getModel().put("userCollection", userCollectionSession.getUserCollection());
		mav.getModel().put("hasWantlist", hasWantlistSession.isHasWantlist());
		mav.getModel().put("userWantlist", userWantlistSession.getUserWantlist());
		mav.getModel().put("possibleSwaps", possibleSwapsSession.getPossibleSwaps());
		mav.getModel().put("latestAdditions", latestAdditionsSession.getLatestAdditions());
		mav.getModel().put("hasSwapProposition", hasSwapPropositionSession.isHasSwapProposition());
		mav.getModel().put("userSwapPropositions", userSwapPropositionsSession.getUserSwapPropositions());
		mav.getModel().put("perfectMatchesMap", perfectMatchesMapSession.getPerfectMatchesMap());
		mav.getModel().put("user", sessionUser.getSessionUser());
		
		return mav;
	}
	
	public void initMav(ModelAndView mav, Map<String, Object> mapInitUser) {
		
		mav.getModel().put("hasCollection", mapInitUser.get("hasCollection"));
		mav.getModel().put("userCollection", mapInitUser.get("userCollection"));
		mav.getModel().put("hasWantlist", mapInitUser.get("hasWantlist"));
		mav.getModel().put("userWantlist", mapInitUser.get("userWantlist"));
		mav.getModel().put("latestAdditions", mapInitUser.get("latestAdditions"));
		mav.getModel().put("possibleSwaps", mapInitUser.get("possibleSwaps"));
		mav.getModel().put("hasSwapProposition", mapInitUser.get("hasSwapProposition"));
		mav.getModel().put("userSwapPropositions", mapInitUser.get("userSwapPropositions"));
		mav.getModel().put("perfectMatchesMap", mapInitUser.get("perfectMatchesMap"));
		mav.getModel().put("user", sessionUser.getSessionUser());
		
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