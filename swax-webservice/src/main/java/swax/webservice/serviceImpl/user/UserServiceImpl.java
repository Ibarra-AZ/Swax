package swax.webservice.serviceImpl.user;
import java.io.IOException;import java.util.ArrayList;import java.util.HashMap;import java.util.List;import java.util.Map;import java.util.Random;import javax.annotation.Resource;import javax.servlet.http.HttpServletRequest;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;import org.springframework.web.multipart.MultipartFile;import swax.webservice.dao.user.IUserDAO;import swax.webservice.dto.AlbumDTO;import swax.webservice.dto.AlbumWantlistDTO;import swax.webservice.dto.PossibleSwapDTO;import swax.webservice.entity.album.AlbumDiscogs;import swax.webservice.entity.album.AlbumDiscogsWantlist;import swax.webservice.entity.album.SwapAlbum;import swax.webservice.entity.user.User;import swax.webservice.service.album.IAlbumCollectedService;import swax.webservice.service.album.IAlbumWantlistService;import swax.webservice.service.album.ISwapAlbumService;import swax.webservice.service.home.IHomeService;import swax.webservice.service.user.IUserService;import swax.webservice.tools.FilesTools;
@Service("userService")public class UserServiceImpl implements IUserService {
	@Resource(name = "userDAO")	private IUserDAO userDAO = null;		@Autowired	private IAlbumCollectedService albumCollectedService = null;		@Autowired	private IAlbumWantlistService albumWantlistService = null;		@Autowired	private ISwapAlbumService swapAlbumService = null;		@Autowired	private IHomeService homeService = null;		@Override	public User findByUserId(int userId) {		return this.userDAO.findByUserId(userId);	}
	@Override	public List<User> findAll() {		return this.userDAO.findAll();	}
	@Override	public Integer createUpdateEntity(User user) {		return this.userDAO.saveAndFlush(user).getUserId();	}
	@Override	public User findByEmailAndPassword(String email, String password) {		return userDAO.findByEmailAndPassword(email, password);	}	@Override	public User findByEmail(String email) {		return userDAO.findByEmail(email);	}	@Override	public User findByUserName(String userName) {		return userDAO.findByUserName(userName);	}	@Override	public User findByEmailOrUserName(String email, String userName) {		return userDAO.findByEmailOrUserName(email, userName);	}	/**	 * Initialize a new password	 * @return String	 */	@Override	public String initUserPassword() {		Random rand = new Random();		byte[] bytes = new byte[8];		for (int i=1; i==8; i++) {			rand.nextBytes(bytes);		}		System.out.println("NEW PASSWORD: "+ bytes.toString());		return bytes.toString();	}		/**	 * Uploads the discogs collection	 * @param file, request	 * @return list of AlbumDiscogs	 */	@Override	public List<AlbumDiscogs> getDiscogsCollectionUpload(MultipartFile file, HttpServletRequest request) 			throws IOException {		FilesTools.uploadFile(file, request);		String filePath = request.getServletContext().getRealPath("files/"+file.getOriginalFilename());		return FilesTools.importCollectionCSVFile(filePath);	}		/**	 * Uploads the discogs wantlist	 * @param file, request	 * @return list of AlbumDiscogsWantlist	 */	@Override	public List<AlbumDiscogsWantlist> getDiscogsWantlistUpload(MultipartFile file, HttpServletRequest request) throws IOException {		FilesTools.uploadFile(file, request);		String filePath = request.getServletContext().getRealPath("files/"+file.getOriginalFilename());		return FilesTools.importWantlistCSVFile(filePath);	}	//	@Override//	public List<AlbumDiscogs> getDiscogsCollectionAPI() {////		TODO//		return null;//	}	/**	 * Initialize user's collection, wantist, possible swaps and perfect matches with other users	 * @param User	 * @return Map of String and Objects for the controller to push to the view	 */	@Override	public Map<String, Object> initUser(User user) {				boolean hasCollection = false, hasWantlist = false, hasSwapProposition = false;		Map<String, Object> mapInitUser = new HashMap<String, Object>();		Map<Integer, List<SwapAlbum>> perfectMatchesMap = new HashMap<Integer, List<SwapAlbum>>();				user.setCollection(albumCollectedService.findByUser(user));		user.setWantlist(albumWantlistService.findByUser(user));				List<SwapAlbum> userSwapPropositions = swapAlbumService.findByUser(user);		List<PossibleSwapDTO> possibleSwaps = homeService.initPossibleSwaps(user);		List<AlbumWantlistDTO> albumsWantlistDTO = albumWantlistService.getAlbumsWantlistDTO(user, possibleSwaps);				List<AlbumDTO> albumsDTO = AlbumDTO.getAlbumsDTO(user.getCollection());				if (!possibleSwaps.isEmpty() && !userSwapPropositions.isEmpty()) {			perfectMatchesMap = homeService.initPerfectSwaps(possibleSwaps, userSwapPropositions);		}				if (albumsWantlistDTO.size()!=0) {			hasWantlist = true;		}				if (albumsDTO.size()!=0) {			hasCollection = true;			mapInitUser.put("latestAdditions", homeService.initHome(user));		} else {			mapInitUser.put("latestAdditions", null);		}				if (userSwapPropositions.size()!=0) {			hasSwapProposition = true;			List<SwapAlbum> result = new ArrayList<>();			for (SwapAlbum swapAlbum: userSwapPropositions) {				if (swapAlbum.isAlbumToSwap()==true) {					result.add(swapAlbum);				}			}			userSwapPropositions = result;		} else {			userSwapPropositions = null;		}				mapInitUser.put("userCollection", albumsDTO);		mapInitUser.put("userWantlist", albumsWantlistDTO);		mapInitUser.put("hasCollection", hasCollection);		mapInitUser.put("hasWantlist", hasWantlist);		mapInitUser.put("possibleSwaps", possibleSwaps);		mapInitUser.put("hasSwapProposition", hasSwapProposition);		mapInitUser.put("userSwapPropositions",	userSwapPropositions);		mapInitUser.put("perfectMatchesMap", perfectMatchesMap);				return mapInitUser;			}	@Override	public void deleteUser(User user) {		this.userDAO.delete(user);	}	@Override	public int countUsers() {		return this.userDAO.countUsers();	}
}