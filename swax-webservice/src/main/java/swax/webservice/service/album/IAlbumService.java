package swax.webservice.service.album;
import java.util.List;import swax.webservice.entity.album.Album;import swax.webservice.entity.album.AlbumDiscogs;import swax.webservice.entity.album.AlbumDiscogsWantlist;public interface IAlbumService {
	public List<Album> findAll();
	public String createUpdateEntity(Album album);	void updateAlbumTable(List<AlbumDiscogs> albumsDiscogs);	public void updateAlbumTableWithWantlist(List<AlbumDiscogsWantlist> albumsDiscogsWantlist);		
}
