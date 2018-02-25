package swax.webservice.serviceImpl.album;
import java.util.List;import javax.annotation.Resource;import org.springframework.stereotype.Service;import swax.webservice.dao.album.IAlbumCollectedDAO;import swax.webservice.dto.AlbumDTO;import swax.webservice.entity.album.Album;import swax.webservice.entity.album.AlbumCollected;import swax.webservice.entity.album.AlbumDiscogs;import swax.webservice.entity.user.User;import swax.webservice.service.album.IAlbumCollectedService;
@Service("albumCollectedService")public class AlbumCollectedServiceImpl implements IAlbumCollectedService {
	@Resource(name = "albumCollectedDAO")	private IAlbumCollectedDAO albumCollectedDAO = null;
	@Override	public List<AlbumCollected> findAll() {		return this.albumCollectedDAO.findAll();	}
	@Override	public String createUpdateEntity(AlbumCollected albumCollected) {		return this.albumCollectedDAO.saveAndFlush(albumCollected).getAlbumCollectedId();	}		@Override	public void createUserCollection(User user, List<AlbumDiscogs> albumsDiscogs) {		for (AlbumDiscogs albumDiscogs: albumsDiscogs) {			AlbumCollected albumCollected = new AlbumCollected(user, albumDiscogs);			this.albumCollectedDAO.save(albumCollected).getAlbumCollectedId();		}		this.albumCollectedDAO.flush();	}		public List<AlbumCollected> findByUser(User user) {		return this.albumCollectedDAO.findByUser(user);	}	@Override	public AlbumCollected findByAlbumCollectedId(String albumId) {		return this.albumCollectedDAO.findByAlbumCollectedId(albumId);	}	@Override	public AlbumDTO getAlbumDTO(AlbumCollected albumCollected) {		Album album = albumCollected.getAlbum();		AlbumDTO albumDTO = new AlbumDTO(albumCollected.getAlbumCollectedId(), album.getAlbumName(), album.getArtist(),				album.getLabel(), album.getCatalogNumber(), album.getFormat(), albumCollected.getMediaGrading(),				albumCollected.getSleeveGrading(), albumCollected.getNotes(), album.getReleaseDate(), 				albumCollected.getDateAdded(), album.getDiscogsId());		return albumDTO;	}	@Override	public void deleteByUser(User user) {		this.albumCollectedDAO.deleteByUser(user);	}	@Override	public void delete(AlbumCollected albumCollection) {		this.albumCollectedDAO.delete(albumCollection);			}	@Override	public void deleteByAlbumCollectedId(String albumId) {		this.albumCollectedDAO.deleteByAlbumCollectedId(albumId);	}
}