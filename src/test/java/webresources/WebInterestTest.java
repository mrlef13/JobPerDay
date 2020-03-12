package webresources;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
	import javax.ws.rs.core.Response;
	import javax.ws.rs.core.Response.Status;

	import org.glassfish.jersey.server.ResourceConfig;
	import org.glassfish.jersey.test.JerseyTest;
	import org.junit.Assert;
	import org.junit.Test;

	import gr.aueb.mscis.sample.model.JOB;
import gr.aueb.mscis.sample.model.JobOffer;
import gr.aueb.mscis.sample.persistence.Initializer;


	
	public class WebInterestTest extends JerseyTest {
		private Initializer dataHelper;
		
		@Override
		protected Application configure() {			
			return new ResourceConfig( Webinterest.class);
		}
		
		@Override
		public void setUp() throws Exception {
			super.setUp();
			dataHelper = new Initializer();
			dataHelper.prepareData();
		}
		
		public  WebInterestTest() {
			super();
		}
		
		@Test
		public void testGetJobOffer() {
			Client client=ClientBuilder.newClient();
			WebTarget jobTarget=client.target("http://localhost:9000/jpd/");
			WebTarget target =jobTarget.path("interest?job=Chef");			
			Invocation.Builder builder=target.request().accept(MediaType.APPLICATION_XML);
			List<JobOffer> joboffers = builder.get(new GenericType<List<JobOffer>>() {});
			
			//Webinterest service=new Webinterest();
			
			//Invocation.Builder builder = target("interest/job=Chef").request();
			//List<JobOffer> joboffers= builder.get(new GenericType<List<JobOffer>>() {});
			//List<JobOffer> joboffers= service.getActiveJobOffers("Chef");
			Assert.assertEquals(2,joboffers.size());
		}

	}

	

