package swax.webservice.service;
import java.util.List;import swax.webservice.entity.AlbumDiscogsWantlist;import swax.webservice.entity.AlbumWantlist;import swax.webservice.entity.User;public interface IAlbumWantlistService {
	public List<AlbumWantlist> findAll();	public Integer createUpdateEntity(AlbumWantlist albumWantlist);	void createUserWantlist(User user, List<AlbumDiscogsWantlist> albumsDiscogsWantlist);
}
