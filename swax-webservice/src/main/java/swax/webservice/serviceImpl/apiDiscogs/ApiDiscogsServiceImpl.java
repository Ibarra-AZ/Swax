package swax.webservice.serviceImpl.apiDiscogs;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.ClientBuilder;

import org.springframework.stereotype.Service;

import swax.webservice.apiDiscogs.model.Release;
import swax.webservice.apiDiscogs.model.RetourCollection;
import swax.webservice.apiDiscogs.model.RetourWantList;
import swax.webservice.apiDiscogs.model.Want;
import swax.webservice.service.apiDiscogs.IApiDiscogsService;

@Service("apiDiscogsService")
public class ApiDiscogsServiceImpl implements IApiDiscogsService {
	
	@Override
	public List<Release> getCollectionFromUserName (String userName) throws Exception{
		List<Release> collection = new ArrayList<Release>();

		RetourCollection premierRetour = firstCollectionCall(userName);

		if(premierRetour!=null
				&&premierRetour.getPagination()!=null){
			Integer nbPagesCollection = premierRetour.getPagination().getPages();
			Integer numberPerPage = premierRetour.getPagination().getPerPage();
			RetourCollection retourCourant;
			for (Integer page = 2; page <= nbPagesCollection; page++) {
				retourCourant=getCollectionFromUserNameAndPageNumber(userName,page,numberPerPage);
				if(retourCourant.getReleases()!=null){
					collection.addAll(retourCourant.getReleases());
				}
			}
		}
		return collection;
	}

	private RetourCollection firstCollectionCall(String userName) throws Exception{
		return ClientBuilder.newClient()
				.target("https://api.discogs.com").path("users/"+userName+"/collection")
				.request().get(RetourCollection.class);
	}
	

	private RetourCollection getCollectionFromUserNameAndPageNumber(String userName, Integer pageNumber, Integer numberPerPage){
		RetourCollection retour = ClientBuilder.newClient()
				.target("https://api.discogs.com").path("users/"+userName+"/collection")
				.queryParam("per_page", numberPerPage).queryParam("page", pageNumber)
				.request().get(RetourCollection.class);

		return retour;
	}
	
//	----------------------------------------- WANTLIST ----------------------------------------- 
	
	@Override
	public List<Want> getWantListFromUserName(String userName) throws Exception{
		List<Want> collection = new ArrayList<Want>();

		RetourWantList premierRetour = firstWantListCall(userName);

		if(premierRetour!=null
				&&premierRetour.getPagination()!=null){
			Integer nbPagesCollection = premierRetour.getPagination().getPages();
			Integer numberPerPage = premierRetour.getPagination().getPerPage();
			RetourWantList retourCourant;
			for (Integer page = 2; page <= nbPagesCollection; page++) {
				retourCourant=getWantListFromUserNameAndPageNumber(userName,page,numberPerPage);
				if(retourCourant.getWants()!=null){
					collection.addAll(retourCourant.getWants());
				}
			}
		}
		return collection;
	}
	
	private RetourWantList firstWantListCall(String userName) throws Exception{
		return ClientBuilder.newClient()
				.target("https://api.discogs.com").path("users/"+userName+"/wants")
				.request().get(RetourWantList.class);
	}
	

	private RetourWantList getWantListFromUserNameAndPageNumber(String userName, Integer pageNumber, Integer numberPerPage){
		RetourWantList retour = ClientBuilder.newClient()
				.target("https://api.discogs.com").path("users/"+userName+"/wants")
				.queryParam("per_page", numberPerPage).queryParam("page", pageNumber)
				.request().get(RetourWantList.class);

		return retour;
	}


}
