package swax.webservice.service.user;
import java.io.IOException;
	public List<User> findAll();
	public Integer createUpdateEntity(User user);
	public User findByEmailAndPassword(String email, String password);
}