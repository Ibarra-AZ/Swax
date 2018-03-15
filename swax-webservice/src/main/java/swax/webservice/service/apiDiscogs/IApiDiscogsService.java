package swax.webservice.service.apiDiscogs;

import java.util.List;
import java.util.Map;

import swax.webservice.apiDiscogs.model.Release;
import swax.webservice.apiDiscogs.model.Want;
import swax.webservice.entity.album.AlbumDiscogs;
import swax.webservice.entity.user.User;

public interface IApiDiscogsService {

	List<Release> getCollectionFromUserName(String userName) throws Exception;

	List<Want> getWantListFromUserName(String userName) throws Exception;

	List<AlbumDiscogs> getAlbumsDiscogsFromReleases(List<Release> releases);
	
	Map<String, Object> synchronizeCollectionWithDiscogs(User user);

	List<AlbumDiscogs> getAlbumsWantListFromReleases(List<Want> wants);

}
