package gr.aueb.mscis.sample.webresources;


import java.net.URI;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import gr.aueb.mscis.sample.model.JobOffer;
import gr.aueb.mscis.sample.persistence.Initializer;


	
	public class WebInterestTest extends JerseyTest {
		private Initializer dataHelper;
		
	    public static final URI BASE_URI =UriBuilder.fromUri("http://localhost/").port(9998).build();
	    private HttpServer server;
	    private WebTarget target;
	    
	    /*@Before
	    public void startServer() throws Exception {

	        ResourceConfig rc = new ResourceConfig(Webinterest.class);
	        server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, rc);

	        //server.start();
	        //Client c = ClientBuilder.newClient();
	        //target = c.target(BASE_URI);
	    }*/

	    @After
	    public void tearDown() throws Exception {
	        server.shutdownNow();
	    }
		
		@Override
		protected Application configure() {			
			return new ResourceConfig( Webinterest.class);
		}
		
		@Override
		@Before
		public void setUp() throws Exception {
			super.setUp();
			dataHelper = new Initializer();
			dataHelper.prepareData();
			ResourceConfig rc = new ResourceConfig(Webinterest.class);
	        server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, rc);
		}

		public  WebInterestTest() {
			super();
		}
			
		
		@Test
		public void testGetJobOffer() {
			Client client=ClientBuilder.newClient();
			WebTarget jobTarget=client.target("http://localhost:9998/jpd/");
			target =jobTarget.path("interest?job=Chef");			
			Invocation.Builder builder=target.request().accept(MediaType.APPLICATION_XML);
			List<JobOffer> joboffers = builder.get(new GenericType<List<JobOffer>>() {});
			
			//Webinterest service=new Webinterest();
			
			//Invocation.Builder builder = target("interest/job=Chef").request();
			//List<JobOffer> joboffers= builder.get(new GenericType<List<JobOffer>>() {});
			//List<JobOffer> joboffers= service.getActiveJobOffers("Chef");
			Assert.assertEquals(2,joboffers.size());
		}

	}

	

