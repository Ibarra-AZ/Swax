package swax.webservice.service.user;
import java.io.IOException;import java.util.List;import java.util.Map;import javax.servlet.http.HttpServletRequest;import org.springframework.web.multipart.MultipartFile;import swax.webservice.entity.album.AlbumDiscogs;import swax.webservice.entity.album.AlbumDiscogsWantlist;import swax.webservice.entity.user.User;public interface IUserService {
	public List<User> findAll();		public User findByUserId(int userId);
	public Integer createUpdateEntity(User user);
	public User findByEmailAndPassword(String email, String password);	public User findByEmail(String email);	public User findByUserName(String userName);	public User findByEmailOrUserName(String email, String userName);		public String initUserPassword();	List<AlbumDiscogs> getDiscogsCollectionUpload(MultipartFile file, HttpServletRequest request) 			throws IOException;	List<AlbumDiscogs> getDiscogsCollectionAPI();	public List<AlbumDiscogsWantlist> getDiscogsWantlistUpload(MultipartFile file, HttpServletRequest request)			throws IOException;	public Map<String, Object> initUser(User user);
}
