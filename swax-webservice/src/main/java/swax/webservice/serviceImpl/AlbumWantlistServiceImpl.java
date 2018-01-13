package swax.webservice.serviceImpl;
import java.util.List;import javax.annotation.Resource;import org.springframework.stereotype.Service;import swax.webservice.dao.IAlbumWantlistDAO;import swax.webservice.entity.AlbumDiscogsWantlist;import swax.webservice.entity.AlbumWantlist;import swax.webservice.entity.User;import swax.webservice.service.IAlbumWantlistService;
@Service("albumWantlistService")public class AlbumWantlistServiceImpl implements IAlbumWantlistService {
	@Resource(name = "albumWantlistDAO")	private IAlbumWantlistDAO albumWantlistDAO = null;
	@Override	public List<AlbumWantlist> findAll() {		return this.albumWantlistDAO.findAll();	}
	@Override	public Integer createUpdateEntity(AlbumWantlist albumWantlist) {		return this.albumWantlistDAO.saveAndFlush(albumWantlist).getAlbumWantlistId();	}		@Override	public void createUserWantlist(User user, List<AlbumDiscogsWantlist> albumsDiscogsWantlist) {		for (AlbumDiscogsWantlist albumDiscogsWantlist: albumsDiscogsWantlist) {			AlbumWantlist albumWantlist = new AlbumWantlist(user, albumDiscogsWantlist);			this.albumWantlistDAO.save(albumWantlist).getAlbumWantlistId();		}		this.albumWantlistDAO.flush();	}	@Override	public List<AlbumWantlist> findByUser(User user) {		return this.albumWantlistDAO.findByUser(user);	}}