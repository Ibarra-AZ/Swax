package swax.webservice.service.album;

import java.util.List;

import swax.webservice.entity.album.AlbumDiscogsWantlist;

public interface IAlbumDiscogsWantlistService {

	List<AlbumDiscogsWantlist> trimAlbumsDiscogsWantlist(List<AlbumDiscogsWantlist> albumsDiscogsWantlist);
}
