package swax.webservice.service.apiDiscogs;

import java.util.List;
import java.util.Map;

import swax.webservice.apiDiscogs.model.Release;
import swax.webservice.apiDiscogs.model.Want;
import swax.webservice.dto.AlbumDTO;
import swax.webservice.dto.AlbumWantlistDTO;
import swax.webservice.entity.album.AlbumDiscogs;
import swax.webservice.entity.album.SwapAlbum;
import swax.webservice.entity.user.User;

public interface IApiDiscogsService {

	List<Release> getCollectionFromUserName(String userName) throws Exception;

	List<Want> getWantListFromUserName(String userName) throws Exception;

	List<AlbumDiscogs> getAlbumsDiscogsFromReleases(List<Release> releases);
	
	Map<String, Object> synchronizeCollectionWithDiscogs(User user);

	List<AlbumDiscogs> getAlbumsWantListFromReleases(List<Want> wants);
	
	Map<String, Object> synchronizeWantlistWithDiscogs(User user);

	List<AlbumDiscogs> getAlbumsToAdd(List<AlbumDiscogs> albumsDiscogs, List<AlbumDTO> albumsCollection);

	List<AlbumDTO> getAlbumsToDelete(List<AlbumDiscogs> albumsDiscogs, List<AlbumDTO> albumsCollection);

	Map<String, Object> getAlbumsToReallyDelete(List<AlbumDTO> albumsToDelete, List<SwapAlbum> swapAlbums);

	List<AlbumDiscogs> getWantlistAlbumsToAdd(List<AlbumDiscogs> albumsDiscogs, List<AlbumWantlistDTO> albumsWantlist);

	List<AlbumWantlistDTO> getWantlistAlbumsToDelete(List<AlbumDiscogs> albumsDiscogs, List<AlbumWantlistDTO> albumsWantlist);
	
	

}
