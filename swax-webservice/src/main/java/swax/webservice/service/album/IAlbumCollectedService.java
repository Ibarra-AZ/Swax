package swax.webservice.service.album;
import java.util.List;import swax.webservice.dto.AlbumDTO;import swax.webservice.entity.album.AlbumCollected;import swax.webservice.entity.album.AlbumDiscogs;import swax.webservice.entity.user.User;public interface IAlbumCollectedService {
	public List<AlbumCollected> findAll();	public String createUpdateEntity(AlbumCollected albumCollected);	void createUserCollection(User user, List<AlbumDiscogs> albumsDiscogs);	public List<AlbumCollected> findByUser(User user);	public AlbumCollected findByAlbumCollectedId(String albumId);	public AlbumDTO getAlbumDTO(AlbumCollected albumCollected);	void deleteByUser(User user);
}
