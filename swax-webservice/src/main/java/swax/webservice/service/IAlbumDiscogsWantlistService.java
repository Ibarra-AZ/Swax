package swax.webservice.service;

import java.util.List;

import swax.webservice.entity.AlbumDiscogsWantlist;

public interface IAlbumDiscogsWantlistService {

	List<AlbumDiscogsWantlist> trimAlbumsDiscogsWantlist(List<AlbumDiscogsWantlist> albumsDiscogsWantlist);
}
