package swax.webservice.service.album;
import java.util.List;import swax.webservice.entity.album.AlbumDiscogsWantlist;import swax.webservice.entity.album.AlbumWantlist;import swax.webservice.entity.user.User;public interface IAlbumWantlistService {
	public List<AlbumWantlist> findAll();	public Integer createUpdateEntity(AlbumWantlist albumWantlist);	void createUserWantlist(User user, List<AlbumDiscogsWantlist> albumsDiscogsWantlist);	public List<AlbumWantlist> findByUser(User user);
}
