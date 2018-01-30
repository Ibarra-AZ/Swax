package swax.web.mav.utils;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import swax.web.form.PojoModelImportCollectionForm;
import swax.web.form.PojoModelImportWantlistForm;
import swax.webservice.entity.user.User;
import swax.webservice.service.user.IUserService;

@Service("mavService")
public class MavUtil {
	
	@Autowired
	private IUserService userService = null;

	public ModelAndView mySwax(User user) {
		
		ModelAndView mav = new ModelAndView();
		Map<String, Object> mapInitUser = userService.initUser(user);
		
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
