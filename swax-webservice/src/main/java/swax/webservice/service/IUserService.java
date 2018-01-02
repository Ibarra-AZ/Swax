package swax.webservice.service;
import java.util.List;
import swax.webservice.entity.User;public interface IUserService {
	public List<User> findAll();
	public Integer createUpdateEntity(User user);
	public User findByEmailAndPassword(String email, String password);
}
