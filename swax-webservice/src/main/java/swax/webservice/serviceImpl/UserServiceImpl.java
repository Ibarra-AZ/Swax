package swax.webservice.serviceImpl;
import java.io.IOException;import java.util.HashMap;import java.util.List;import java.util.Map;import java.util.Random;import javax.annotation.Resource;import javax.servlet.http.HttpServletRequest;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;import org.springframework.web.multipart.MultipartFile;import swax.webservice.dao.IUserDAO;import swax.webservice.dto.AlbumDTO;import swax.webservice.entity.AlbumDiscogs;import swax.webservice.entity.AlbumDiscogsWantlist;import swax.webservice.entity.User;import swax.webservice.service.IAlbumCollectedService;import swax.webservice.service.IAlbumWantlistService;import swax.webservice.service.IUserService;import swax.webservice.tools.FilesTools;
@Service("userService")public class UserServiceImpl implements IUserService {
	@Resource(name = "userDAO")	private IUserDAO userDAO = null;		@Autowired	private IAlbumCollectedService albumCollectedService = null;		@Autowired	private IAlbumWantlistService albumWantlistService = null;
	@Override	public List<User> findAll() {		return this.userDAO.findAll();	}
	@Override	public Integer createUpdateEntity(User user) {		return this.userDAO.saveAndFlush(user).getUserId();	}
	@Override	public User findByEmailAndPassword(String email, String password) {		return userDAO.findByEmailAndPassword(email, password);	}	@Override	public User findByEmail(String email) {		return userDAO.findByEmail(email);	}	@Override	public User findByUserName(String userName) {		return userDAO.findByUserName(userName);	}	@Override	public User findByEmailOrUserName(String email, String userName) {		return userDAO.findByEmailOrUserName(email, userName);	}	@Override	public String initUserPassword() {		Random rand = new Random();		byte[] bytes = new byte[8];		for (int i=1; i==8; i++) {			rand.nextBytes(bytes);		}		System.out.println("NEW PASSWORD: "+ bytes.toString());		return bytes.toString();	}		@Override	public List<AlbumDiscogs> getDiscogsCollectionUpload(MultipartFile file, HttpServletRequest request) 			throws IOException {		FilesTools.uploadFile(file, request);		String filePath = request.getServletContext().getRealPath("files/"+file.getOriginalFilename());		return FilesTools.importCollectionCSVFile(filePath);	}		@Override	public List<AlbumDiscogsWantlist> getDiscogsWantlistUpload(MultipartFile file, HttpServletRequest request) throws IOException {		FilesTools.uploadFile(file, request);		String filePath = request.getServletContext().getRealPath("files/"+file.getOriginalFilename());		return FilesTools.importWantlistCSVFile(filePath);	}		@Override	public List<AlbumDiscogs> getDiscogsCollectionAPI() {//		TODO		return null;	}	@Override	public Map<String, Object> initUser(User user) {				boolean hasCollection = true, hasWantlist = true;		user.setCollection(albumCollectedService.findByUser(user));		user.setWantlist(albumWantlistService.findByUser(user));		List<AlbumDTO> albumsWantlistDTO = user.getAlbumsWantlistDTO();		List<AlbumDTO> albumsDTO = user.getAlbumsDTO();		Map<String, Object> mapInitUser = new HashMap<String, Object>();						if (albumsWantlistDTO.size()==0) {			hasWantlist = false;		}						if (albumsDTO.size()==0) {			hasCollection = false;		}		mapInitUser.put("userCollection", albumsDTO);		mapInitUser.put("userWantlist",albumsWantlistDTO);		mapInitUser.put("hasCollection", hasCollection);		mapInitUser.put("hasWantlist", hasWantlist);					return mapInitUser;			}
}