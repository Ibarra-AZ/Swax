package swax.webservice.serviceImpl.apiDiscogs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.ws.rs.client.ClientBuilder;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import swax.webservice.apiDiscogs.model.BasicInformation;
import swax.webservice.apiDiscogs.model.Release;
import swax.webservice.apiDiscogs.model.RetourCollection;
import swax.webservice.apiDiscogs.model.RetourWantList;
import swax.webservice.apiDiscogs.model.Want;
import swax.webservice.dto.AlbumDTO;
import swax.webservice.dto.AlbumWantlistDTO;
import swax.webservice.entity.album.AlbumDiscogs;
import swax.webservice.entity.album.SwapAlbum;
import swax.webservice.entity.user.User;
import swax.webservice.service.apiDiscogs.IApiDiscogsService;

@Service("apiDiscogsService")
public class ApiDiscogsServiceImpl implements IApiDiscogsService {
	
	private final int NB_ITEM_MAX_PAGE = 500;
	private Logger logger = Logger.getLogger(this.getClass());
	
	/**
	 * 
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	private RetourCollection firstCollectionCall(String userName) throws Exception{
		
		return ClientBuilder.newClient()
				.target("https://api.discogs.com")
				.path("users/"+userName+"/collection/folders/0/releases")
				.queryParam("per_page", NB_ITEM_MAX_PAGE)
				.request()
				.get(RetourCollection.class);
	}

	/**
	 * 
	 * @param userName
	 * @param pageNumber
	 * @param numberPerPage
	 * @return
	 */
	private RetourCollection getCollectionFromUserNameAndPageNumber(String userName, Integer pageNumber, Integer numberPerPage){
		
		RetourCollection retour = ClientBuilder.newClient()
				.target("https://api.discogs.com")
				.path("users/"+userName+"/collection/folders/0/releases")
				.queryParam("per_page", numberPerPage)
				.queryParam("page", pageNumber)
				.request().get(RetourCollection.class);

		return retour;
	}
	

	/**
	 * @param releases
	 */
	@Override
	public List<AlbumDiscogs> getAlbumsDiscogsFromReleases(List<Release> releases){
		List<AlbumDiscogs> albums = new ArrayList<AlbumDiscogs>();
		for (Release release : releases) {
			albums.add(getAlbumDiscogsFromRelease(release));
		}
		return albums;
	}
	
	/**
	 * @param release
	 * @return AlbumDiscogs
	 */
	private AlbumDiscogs getAlbumDiscogsFromRelease(Release release) {
		
		AlbumDiscogs album = new AlbumDiscogs();
		BasicInformation infosAlbums = release.getBasicInformation();
		
		if(infosAlbums!=null){
			if(infosAlbums.getArtists()!=null&&infosAlbums.getArtists().size()>0){
				album.setArtist(infosAlbums.getArtists().stream().map(Object::toString)
						.collect(Collectors.joining(", ")));
			}
			if(infosAlbums.getFormats()!=null&&infosAlbums.getFormats().size()>0){
				album.setFormat(infosAlbums.getFormats().stream().map(Object::toString)
						.collect(Collectors.joining(", ")));
			}
			if(infosAlbums.getLabels()!=null&&infosAlbums.getLabels().size()>0){
				album.setLabel(infosAlbums.getLabels().stream().map(Object::toString)
						.collect(Collectors.joining(", ")));
			}
		}
		
		if(release.getInstanceId()!=null){
		album.setCollection_id(release.getInstanceId().toString());
		}
		
		if(release.getRating()!=null){
			album.setRating(release.getRating().toString());
		}
		
		if(release.getId()!=null){
			album.setRelease_id(release.getId().toString());
		}
		
		album.setTitle(infosAlbums.getTitle());
		album.setDateAdded(release.dateAdded);
		album.setReleased(Integer.toString(infosAlbums.year));

		return album;
	}
	
	/**
	 * @param userName
	 */
	@Override
	public List<Release> getCollectionFromUserName (String userName) throws Exception{
		
		List<Release> collection = new ArrayList<Release>();
		RetourCollection premierRetour = firstCollectionCall(userName);

		if(premierRetour!=null
				&&premierRetour.getPagination()!=null){
			collection.addAll(premierRetour.getReleases());
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
	
	/**
	 * @param user
	 */
	@Override
	public Map<String, Object> synchronizeCollectionWithDiscogs(User user) {
		
		logger.debug(this.getClass().getName()+this.getClass()+": synchronizeCollectionWithDiscogs");
		List<Release> releases = new ArrayList<Release>();
		String errorMsg = "";
		Map<String, Object> result = new HashMap<>();
		
		try{
			releases = this.getCollectionFromUserName(user.getDiscogsName());
			List<AlbumDiscogs> albumsDiscogs = this.getAlbumsDiscogsFromReleases(releases);
			if (albumsDiscogs.size() == 0 || albumsDiscogs == null) {
				System.out.println("La collection est vide ou n'existe pas.");
				albumsDiscogs = null;
			}
			result.put("albumsDiscogs", albumsDiscogs);
		}
		catch(Exception e){
			errorMsg = "Erreur dans la synchronisation de la collection avec Discogs";
			result.put("albumsDiscogs", null);
			e.printStackTrace();
		}
		
		result.put("errorMsg", errorMsg);
		
		return result;
	}
	

	/**
	 * 
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	private RetourWantList firstWantListCall(String userName) throws Exception{
		return ClientBuilder.newClient()
				.target("https://api.discogs.com").path("users/"+userName+"/wants").queryParam("per_page", NB_ITEM_MAX_PAGE)
				.request().get(RetourWantList.class);
	}
	
	/**
	 * @param userName
	 */
	@Override
	public List<Want> getWantListFromUserName(String userName) throws Exception{
		List<Want> collection = new ArrayList<Want>();

		RetourWantList premierRetour = firstWantListCall(userName);

		if(premierRetour!=null &&premierRetour.getPagination()!=null){
			collection.addAll(premierRetour.getWants()); 
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
	
	/**
	 * @param wants
	 */
	@Override
	public List<AlbumDiscogs> getAlbumsWantListFromReleases(List<Want> wants){
		List<AlbumDiscogs> albums = new ArrayList<AlbumDiscogs>();
		for (Want want : wants) {
			AlbumDiscogs albumDiscogs = getAlbumWantListFromRelease(want);
			albums.add(albumDiscogs);
		}
		return albums;
	}
	
	/**
	 * @param want
	 * @return AlbumDiscogs
	 */
	private AlbumDiscogs getAlbumWantListFromRelease(Want want) {
		
		AlbumDiscogs albumDiscogs = new AlbumDiscogs();
		BasicInformation infosAlbums = want.getBasicInformation();
		
		if(infosAlbums!=null){
			if(infosAlbums.getArtists()!=null&&infosAlbums.getArtists().size()>0){
				albumDiscogs.setArtist(infosAlbums.getArtists().stream().map(Object::toString)
						.collect(Collectors.joining(", ")));
			}
			if(infosAlbums.getFormats()!=null&&infosAlbums.getFormats().size()>0){
				albumDiscogs.setFormat(infosAlbums.getFormats().stream().map(Object::toString)
						.collect(Collectors.joining(", ")));
			}
			if(infosAlbums.getLabels()!=null&&infosAlbums.getLabels().size()>0){
				albumDiscogs.setLabel(infosAlbums.getLabels().stream().map(Object::toString)
						.collect(Collectors.joining(", ")));
			}
			albumDiscogs.setTitle(infosAlbums.getTitle());
			
			if(infosAlbums.getYear()!=null){
				albumDiscogs.setReleased(String.valueOf(infosAlbums.getYear()));
			}
		}
		
		albumDiscogs.setCollection_id(String.valueOf(want.getId()));
		albumDiscogs.setRelease_id(String.valueOf(want.getId()));
		albumDiscogs.setDateAdded(want.getDateAdded().substring(0, 10));
		
		return albumDiscogs;
	}	

	/**
	 * 
	 * @param userName
	 * @param pageNumber
	 * @param numberPerPage
	 * @return
	 */
	private RetourWantList getWantListFromUserNameAndPageNumber(String userName, Integer pageNumber, Integer numberPerPage){
		RetourWantList retour = ClientBuilder.newClient()
				.target("https://api.discogs.com").path("users/"+userName+"/wants")
				.queryParam("per_page", numberPerPage).queryParam("page", pageNumber)
				.request().get(RetourWantList.class);

		return retour;
	}
	
	/**
	 * @param user
	 */
	@Override
	public Map<String, Object> synchronizeWantlistWithDiscogs(User user) {
		
		logger.debug(this.getClass().getName()+this.getClass()+": synchronizeWantlistWithDiscogs");
		List<Want> wants= new ArrayList<Want>();
		String errorMsg = "";
		Map<String, Object> result = new HashMap<>();
		
		try{
			wants = this.getWantListFromUserName(user.getDiscogsName());
			List<AlbumDiscogs> albumsDiscogs = this.getAlbumsWantListFromReleases(wants);
			if (albumsDiscogs.size() == 0 || albumsDiscogs == null) {
				System.out.println("La wantlist est vide ou n'existe pas.");
				albumsDiscogs = null;
			}
			result.put("albumsDiscogs", albumsDiscogs);
		}
		catch(Exception e){
			errorMsg = "Erreur dans la synchronisation de la collection avec Discogs";
			result.put("albumsDiscogs", null);
			e.printStackTrace();
		}
		
		result.put("errorMsg", errorMsg);
		
		return result;
	}
	
	@Override
	public List<AlbumDiscogs> getAlbumsToAdd(List<AlbumDiscogs> albumsDiscogs, List<AlbumDTO> albumsCollection) {
		
		List<AlbumDiscogs> albumsToAdd = new ArrayList<>();
		
		for (AlbumDiscogs albumDiscogs: albumsDiscogs) {
			boolean foundInCollection = false;
			for (AlbumDTO albumCollection: albumsCollection) {
				if (albumDiscogs.getCollection_id().equals(albumCollection.getAlbumId())) {
					foundInCollection = true;
				}
			}
			if (!foundInCollection) {
				albumsToAdd.add(albumDiscogs);
			}
		}
		
		return albumsToAdd;
		
	}
	
	@Override
	public List<AlbumDTO> getAlbumsToDelete(List<AlbumDiscogs> albumsDiscogs, List<AlbumDTO> albumsCollection) {
		
		List<AlbumDTO> albumsToDelete = new ArrayList<>();
		
		for (AlbumDTO albumCollection: albumsCollection) {
			boolean foundInDiscogs = false;
			for (AlbumDiscogs albumDiscogs: albumsDiscogs) {
				if (albumCollection.getAlbumId().equals(albumDiscogs.getCollection_id())) {
					foundInDiscogs = true;
				}
			}
			if (!foundInDiscogs) {
				albumsToDelete.add(albumCollection);
			}
		}
		
		return albumsToDelete;
	}
	
	@Override
	public Map<String, Object> getAlbumsToReallyDelete(List<AlbumDTO> albumsToDelete, List<SwapAlbum> swapAlbums) {
		
		List<AlbumDTO> albumsToReallyDelete = new ArrayList<>();
		List<SwapAlbum> albumsImpossibleToDelete = new ArrayList<>();
		Map<String, Object> result = new HashMap<>();
		
		for (AlbumDTO albumCollection: albumsToDelete) {
			boolean toDelete = true;
			for (SwapAlbum swapAlbum: swapAlbums) {
				if (swapAlbum.getAlbumCollected().getAlbumCollectedId().equals(albumCollection.getAlbumId())) {
					if (swapAlbum.isAlbumToSwap()==true) {
						albumsImpossibleToDelete.add(swapAlbum);
						toDelete = false;
					}
				}
			}
			if (toDelete) {
				albumsToReallyDelete.add(albumCollection);
			}
		}
		
		result.put("albumsToReallyDelete", albumsToReallyDelete);
		result.put("albumsImpossibleToDelete", albumsImpossibleToDelete);
		
		return result;
		
	}
	
	@Override
	public List<AlbumDiscogs> getWantlistAlbumsToAdd(List<AlbumDiscogs> albumsDiscogs, List<AlbumWantlistDTO> albumsWantlist) {
		
		List<AlbumDiscogs> albumsToAdd = new ArrayList<>();
			
		for (AlbumDiscogs albumDiscogs: albumsDiscogs) {
			boolean foundInWantlist = false;
			for (AlbumWantlistDTO albumWantlist: albumsWantlist) {
				if (albumDiscogs.getCollection_id().equals(albumWantlist.getAlbumId().toString())) {
					foundInWantlist = true;
				}
			}
			if (!foundInWantlist) {
				albumsToAdd.add(albumDiscogs);
			}
		}
		
		return albumsToAdd;
	}
	
	@Override
	public List<AlbumWantlistDTO> getWantlistAlbumsToDelete(List<AlbumDiscogs> albumsDiscogs, List<AlbumWantlistDTO> albumsWantlist) {
		
		List<AlbumWantlistDTO> albumsToDelete = new ArrayList<>();
			
		for (AlbumWantlistDTO albumWantlistDTO: albumsWantlist) {
			boolean foundInDiscogs = false;
			for (AlbumDiscogs albumDiscogs: albumsDiscogs) {
				if (albumWantlistDTO.getAlbumId().toString().equals(albumDiscogs.getCollection_id())) {
					foundInDiscogs = true;
				}
			}
			if (!foundInDiscogs) {
				albumsToDelete.add(albumWantlistDTO);
			}
		}
		
		return albumsToDelete;
	}
	
}
