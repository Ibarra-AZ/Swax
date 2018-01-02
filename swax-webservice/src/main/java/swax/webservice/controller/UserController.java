package swax.webservice.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RestController;
import swax.webservice.entity.User;import swax.webservice.service.IUserService;
@RestController//@CrossOriginpublic class UserController {
	@Autowired	private IUserService userService;	@RequestMapping(value="/users")	public List<User> getUsers(){		return userService.findAll();	}
//	@RequestMapping(value="/user")//	public User getUserByEmail(@RequestParam(value="email") String email){//		return userService.findByEmail(email);//	}
	
//	@RequestMapping(name="/createUpdate", method=RequestMethod.POST)
//	public void createUpdateUser(User user) {
//		user.setEmail("testEmail");
//		user.setPassword("testPwd");
//		user.setPseudo("testPseudo");
//		userService.createUpdateEntity(user);
//	}
	

}
