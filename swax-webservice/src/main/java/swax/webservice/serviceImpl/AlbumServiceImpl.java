package swax.webservice.serviceImpl;
import java.util.List;import javax.annotation.Resource;import org.springframework.stereotype.Service;import swax.webservice.dao.IAlbumDAO;import swax.webservice.entity.Album;import swax.webservice.entity.AlbumDiscogs;import swax.webservice.entity.AlbumDiscogsWantlist;import swax.webservice.service.IAlbumService;
@Service("albumService")public class AlbumServiceImpl implements IAlbumService {
	@Resource(name = "albumDAO")	private IAlbumDAO albumDAO = null;
	@Override	public List<Album> findAll() {		return this.albumDAO.findAll();	}
	@Override	public String createUpdateEntity(Album album) {		return this.albumDAO.saveAndFlush(album).getDiscogsId();	}		@Override	public void updateAlbumTable(List<AlbumDiscogs> albumsDiscogs) {		for (AlbumDiscogs albumDiscogs: albumsDiscogs) {			Album album = new Album(albumDiscogs);			this.albumDAO.save(album).getDiscogsId();		}		this.albumDAO.flush();	}	@Override	public void updateAlbumTableWithWantlist(List<AlbumDiscogsWantlist> albumsDiscogsWantlist) {		for (AlbumDiscogsWantlist albumDiscogsWanlist: albumsDiscogsWantlist) {			Album album = new Album(albumDiscogsWanlist);			this.albumDAO.save(album).getDiscogsId();		}		this.albumDAO.flush();		}
}