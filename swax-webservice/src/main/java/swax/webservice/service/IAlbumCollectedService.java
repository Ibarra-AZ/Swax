package swax.webservice.service;
import java.text.ParseException;import java.util.List;import swax.webservice.entity.AlbumCollected;import swax.webservice.entity.AlbumDiscogs;import swax.webservice.entity.User;public interface IAlbumCollectedService {
	public List<AlbumCollected> findAll();	public Integer createUpdateEntity(AlbumCollected albumCollected);	void createUserCollection(User user, List<AlbumDiscogs> albumsDiscogs) throws ParseException;
}
