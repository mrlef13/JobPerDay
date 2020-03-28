package gr.aueb.mscis.sample.webresources;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import gr.aueb.mscis.sample.model.Employee;
import gr.aueb.mscis.sample.model.JobApplication;
import gr.aueb.mscis.sample.persistence.Initializer;
import gr.aueb.mscis.sample.persistence.JPAUtil;
import gr.aueb.mscis.sample.service.SearchFunctions;

public class WebEditProfileTest extends JerseyTest{
	private Initializer dataHelper;
	protected EntityManager em=JPAUtil.getCurrentEntityManager();			
    	    
    @Override
	public Application configure() {						
		return new ResourceConfig( WebEditProfile.class);			
	}
    
	@Override		
	public void setUp() throws Exception {
		super.setUp();
		dataHelper = new Initializer();
		dataHelper.prepareData();
	}

	public  WebEditProfileTest() {
		super();
	}
		
	@Test
	public void testAddToJobList() {
		SearchFunctions sf =new SearchFunctions();
		Employee employee = sf.searchEmployee("employee@prepare.com");		
		Response response = target("/edit/"+employee.getId()+"/addjob/Barista/").request().get();					
		Assert.assertEquals(Status.OK.getStatusCode(),response.getStatus());
		
	}
	
	@Test
	public void testRemoveFromJobList() {
		SearchFunctions sf =new SearchFunctions();
		Employee employee = sf.searchEmployee("employee@prepare.com");		
		Response response = target("/edit/"+employee.getId()+"/removejob/Chef/").request().get();					
		Assert.assertEquals(Status.OK.getStatusCode(),response.getStatus());
	}
	
	@Test
	public void testAvailableTrue() {
		SearchFunctions sf =new SearchFunctions();
		Employee employee = sf.searchEmployee("employee@prepare.com");		
		Response response = target("/edit/"+employee.getId()+"/available/").request().get();					
		Assert.assertEquals(Status.OK.getStatusCode(),response.getStatus());
	}
	
	@Test
	public void testAvailableFalse() {
		SearchFunctions sf =new SearchFunctions();
		Employee employee = sf.searchEmployee("employee@prepare.com");		
		Response response = target("/edit/"+employee.getId()+"/unavailable/").request().get();					
		Assert.assertEquals(Status.OK.getStatusCode(),response.getStatus());
	}
	
	
	@Test
	public void testUpdateEmployee() {
		SearchFunctions sf =new SearchFunctions();				
		Employee employee = sf.searchEmployee("employee@prepare.com");	
		Webemployee webemployee = new Webemployee("employee2@prepare.com","lala","lala","And1","Brou1","42069");		
		Response response = target("/edit/"+employee.getId()+"/update/").request().put(Entity.entity(webemployee, MediaType.APPLICATION_JSON));
		Assert.assertEquals(Status.OK.getStatusCode(),response.getStatus());
	}
	



}
