package swax.webservice.service.apiDiscogs;

import java.util.List;

import swax.webservice.apiDiscogs.model.Release;
import swax.webservice.apiDiscogs.model.Want;

public interface IApiDiscogsService {

	List<Release> getCollectionFromUserName(String userName) throws Exception;

	List<Want> getWantListFromUserName(String userName) throws Exception;

}
