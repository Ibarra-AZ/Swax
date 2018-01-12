package swax.webservice.service;
import java.util.List;import swax.webservice.entity.Album;import swax.webservice.entity.AlbumDiscogs;import swax.webservice.entity.AlbumDiscogsWantlist;public interface IAlbumService {
	public List<Album> findAll();
	public String createUpdateEntity(Album album);	void updateAlbumTable(List<AlbumDiscogs> albumsDiscogs);	public void updateAlbumTableWithWantlist(List<AlbumDiscogsWantlist> albumsDiscogsWantlist);		
}
