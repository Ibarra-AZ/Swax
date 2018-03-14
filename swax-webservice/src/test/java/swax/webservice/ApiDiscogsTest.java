package swax.webservice;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import swax.webservice.apiDiscogs.model.Release;
import swax.webservice.apiDiscogs.model.Want;
import swax.webservice.entity.album.AlbumDiscogs;
import swax.webservice.entity.album.AlbumWantlist;
import swax.webservice.entity.user.User;
import swax.webservice.service.apiDiscogs.IApiDiscogsService;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations="/context-test.xml")
public class ApiDiscogsTest{

	@Autowired
	private IApiDiscogsService apiDiscogsService;

//	@Test
//	public void getCollectionFromUserNameTest(){
//		try {
//			List<Release> collection = apiDiscogsService.getCollectionFromUserName("Ibarra-AZ");
//			System.out.println("La collection de Matthieu compte "+collection.size()+" éléments : "+collection);
//			Assert.assertTrue(true);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			Assert.assertTrue(false);
//		}
//	}
//
	@Test
	public void getWantListFromUserTest(){
		try {

			List<Want> wantList = apiDiscogsService.getWantListFromUserName("Ibarra-AZ");
			System.out.println("La wantlist de Matthieu compte "+wantList.size()+" éléments : "+wantList);
			Assert.assertTrue(!wantList.isEmpty());
			
			User user = new User();
			user.setDiscogsName("Ibarra-AZ");
			
			List<AlbumWantlist> wantListSwax = apiDiscogsService.getAlbumsWantListFromReleases(wantList,user);
			System.out.println("Premier album = " +wantListSwax.get(0));
			Assert.assertTrue(!wantListSwax.isEmpty());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void getCollectionFormatSwaxFromUserNameTest(){
		try {
			// TEST avec tytos77 - 1598 items dans la collection
			List<Release> collection = apiDiscogsService.getCollectionFromUserName("tytos77");
			List<AlbumDiscogs> collectionFormatSwax = apiDiscogsService.getAlbumsDiscogsFromReleases(collection);
			System.out.println(collectionFormatSwax);
			Assert.assertTrue(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

}
