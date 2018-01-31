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
import swax.webservice.service.apiDiscogs.IApiDiscogsService;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations="/context-test.xml")
public class ApiDiscogsTest{

	@Autowired
	private IApiDiscogsService apiDiscogsService;

	@Test
	public void getCollectionFromUserNameTest(){
		try {
			List<Release> collection = apiDiscogsService.getCollectionFromUserName("Ibarra-AZ");
			System.out.println("La collection de Matthieu compte "+collection.size()+" éléments : "+collection);
			Assert.assertTrue(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@Test
	public void getWantListFromUserTest(){
		try {

			List<Want> wantList = apiDiscogsService.getWantListFromUserName("Ibarra-AZ");
			System.out.println("La wantlist de Matthieu compte "+wantList.size()+" éléments : "+wantList);
			Assert.assertTrue(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

}
