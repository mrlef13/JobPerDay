package webresources;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import gr.aueb.mscis.sample.model.JOB;
import gr.aueb.mscis.sample.persistence.Initializer;



public class WebJobOfferTest extends JerseyTest {
	private Initializer dataHelper;
	
	@Override
	protected Application configure() {
		
		return new ResourceConfig( WebJobOfferTest.class);
	}
	@Override
	public void setUp() throws Exception {
		
		super.setUp();
		dataHelper = new Initializer();
		dataHelper.prepareData();
	}
	
	public  WebJobOfferTest() {
		super();
	}
	
	@Test
	public void testCreateJobOffer() {
		
//		Movie movie = new (JOB Job,String Entrydate, int Entryhour, int Endhour, String Exprirationdate, int Payment)
		Webjoboffer webjoboffer = new Webjoboffer("company@prepare.com",JOB.Barista,"10/06/2020",10,19,"19/06/2020",100);
		System.out.println(Entity.entity(webjoboffer, MediaType.APPLICATION_XML));
		Response response = target("/joboffer").request().post(Entity.entity(webjoboffer, MediaType.APPLICATION_XML));
		System.out.println(response.getStatus());
		Assert.assertEquals(Status.OK.getStatusCode(),response.getStatus());
	}

}
