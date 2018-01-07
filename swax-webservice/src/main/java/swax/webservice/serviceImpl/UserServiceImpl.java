package swax.webservice.serviceImpl;
import java.util.List;import java.util.Random;import javax.annotation.Resource;import org.springframework.stereotype.Service;import swax.webservice.dao.IUserDAO;import swax.webservice.entity.User;import swax.webservice.service.IUserService;
@Service("userService")public class UserServiceImpl implements IUserService{
	@Resource(name = "userDAO")	private IUserDAO userDAO = null;
	@Override	public List<User> findAll() {		return this.userDAO.findAll();	}
	@Override	public Integer createUpdateEntity(User user) {		return this.userDAO.saveAndFlush(user).getUserId();	}
	@Override	public User findByEmailAndPassword(String email, String password) {		return userDAO.findByEmailAndPassword(email, password);	}	@Override	public User findByEmail(String email) {		return userDAO.findByEmail(email);	}	@Override	public User findByUserName(String userName) {		return userDAO.findByUserName(userName);	}	@Override	public User findByEmailOrUserName(String email, String userName) {		return userDAO.findByEmailOrUserName(email, userName);	}	@Override	public String initUserPassword() {		Random rand = new Random();		byte[] bytes = new byte[8];		for (int i=1; i==8; i++) {			rand.nextBytes(bytes);		}		System.out.println("NEW PASSWORD: "+ bytes.toString());		return bytes.toString();	}
}