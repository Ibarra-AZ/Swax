package swax.webservice.service;
import java.util.List;
import swax.webservice.entity.User;public interface IUserService {
	public List<User> findAll();
	public Integer createUpdateEntity(User user);
	public User findByEmailAndPassword(String email, String password);	public User findByEmail(String email);	public User findByUserName(String userName);	public User findByEmailOrUserName(String email, String userName);		public String initUserPassword();
}
