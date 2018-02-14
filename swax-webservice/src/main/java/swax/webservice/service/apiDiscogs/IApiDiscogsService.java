package swax.webservice.service.apiDiscogs;

import java.util.List;

import swax.webservice.apiDiscogs.model.Release;
import swax.webservice.apiDiscogs.model.Want;
import swax.webservice.entity.album.AlbumDiscogs;

public interface IApiDiscogsService {

	List<Release> getCollectionFromUserName(String userName) throws Exception;

	List<Want> getWantListFromUserName(String userName) throws Exception;

	List<AlbumDiscogs> getAlbumsDiscogsFromReleases(List<Release> releases);


}
