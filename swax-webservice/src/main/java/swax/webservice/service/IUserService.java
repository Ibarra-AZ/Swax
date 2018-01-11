package swax.webservice.service;
import java.io.IOException;import java.util.List;import javax.servlet.http.HttpServletRequest;import org.springframework.web.multipart.MultipartFile;import swax.webservice.entity.AlbumDiscogs;import swax.webservice.entity.User;public interface IUserService {
	public List<User> findAll();
	public Integer createUpdateEntity(User user);
	public User findByEmailAndPassword(String email, String password);	public User findByEmail(String email);	public User findByUserName(String userName);	public User findByEmailOrUserName(String email, String userName);		public String initUserPassword();	List<AlbumDiscogs> getDiscogsCollectionUpload(MultipartFile file, HttpServletRequest request) throws IOException;	List<AlbumDiscogs> getDiscogsCollectionAPI();
}
