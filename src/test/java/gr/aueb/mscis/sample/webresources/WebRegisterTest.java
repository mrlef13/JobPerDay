package gr.aueb.mscis.sample.webresources;

import java.net.URI;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Response.Status;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.spi.TestContainerFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import gr.aueb.mscis.sample.persistence.Initializer;
import gr.aueb.mscis.sample.persistence.JPAUtil;
import junit.framework.Assert;

public class WebRegisterTest extends JerseyTest {
	private Initializer dataHelper;
	    	
	@Override
	protected Application configure() {
		
		return new ResourceConfig(Webregister.class);
	}
	@Override
	public void setUp() throws Exception {
		
		super.setUp();
		dataHelper = new Initializer();
		dataHelper.prepareData();
	}
	
	public WebRegisterTest() {
		super();
	}
	
	@Test
	public void testCreateEmployee() {
		
//		Movie movie = new Movie("Halvai", 2020, "Seferlis");
		Webemployee webemployee = new Webemployee("lefko","lala","lala","And","Brou","666");
		System.out.println(Entity.entity(webemployee, MediaType.APPLICATION_JSON));
		Response response = target("/registration").request().post(Entity.entity(webemployee, MediaType.APPLICATION_JSON));
		System.out.println(response.getStatus());
		Assert.assertEquals(Status.OK.getStatusCode(),response.getStatus());
	}
	@Test
	public void testCreateCompany() {
		
		Webcompany webcompany = new Webcompany("andbrou","1234","1234","LefKo","999");
		System.out.println(Entity.entity(webcompany, MediaType.APPLICATION_XML));
		Response response = target("/registration").request().post(Entity.entity(webcompany, MediaType.APPLICATION_XML));
		System.out.println(response.getStatus());
		Assert.assertEquals(Status.OK.getStatusCode(),response.getStatus());
	}
}
