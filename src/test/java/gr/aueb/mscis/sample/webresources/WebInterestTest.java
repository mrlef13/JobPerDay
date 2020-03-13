package gr.aueb.mscis.sample.webresources;


import java.net.URI;
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
	    	     
	    @Override
		public Application configure() {			
			
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

			Invocation.Builder builder=target("/interest/Chef").request().accept(MediaType.APPLICATION_JSON);					
			List<JobOffer> joboffers= builder.get(new GenericType<List<JobOffer>>() {});
			Assert.assertEquals(2,joboffers.size());
		}

	}

	

