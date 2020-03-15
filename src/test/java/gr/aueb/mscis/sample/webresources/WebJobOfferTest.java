package gr.aueb.mscis.sample.webresources;

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
		
		return new ResourceConfig( WebOffer.class);
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
		
		Webjoboffer webjoboffer = new Webjoboffer("company@prepare.com","Barista","10/06/2020",10,19,"19/06/2020",100);
		Webjoboffer webjoboffer1 = new Webjoboffer("company@prepare.com","Chef","11/06/2020",10,19,"20/06/2020",50);
	
		Response response = target("/joboffer").request().post(Entity.entity(webjoboffer, MediaType.APPLICATION_JSON));
		Response response1 = target("/joboffer").request().post(Entity.entity(webjoboffer1, MediaType.APPLICATION_JSON));
		Assert.assertEquals(Status.OK.getStatusCode(),response.getStatus());
		Assert.assertEquals(Status.OK.getStatusCode(),response1.getStatus());
	}

}
