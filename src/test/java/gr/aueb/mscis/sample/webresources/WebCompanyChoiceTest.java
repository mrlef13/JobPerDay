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

public class WebCompanyChoiceTest extends JerseyTest{
	private Initializer dataHelper;
	protected EntityManager em=JPAUtil.getCurrentEntityManager();			
    	    
    @Override
	public Application configure() {						
		return new ResourceConfig( WebCompanyChoice.class);			
	}
    
	@Override		
	public void setUp() throws Exception {
		super.setUp();
		dataHelper = new Initializer();
		dataHelper.prepareData();
	}

	public  WebCompanyChoiceTest() {
		super();
	}
	
	@Test
	public void testGetApplications() {
		SearchFunctions sf =new SearchFunctions();
		Employee employee = sf.searchEmployee("employee@prepare.com");		
		Invocation.Builder builder=target("/companychoice/employeeapps/"+employee.getId()).request().accept(MediaType.APPLICATION_JSON);					
		List<WebApplication> webapps= builder.get(new GenericType<List<WebApplication>>() {});		
		Assert.assertEquals(1,webapps.size());
	}
	
	
	@Test
	public void testAppVerification() {
		SearchFunctions sf =new SearchFunctions();				
		Employee employee = sf.searchEmployee("employee@prepare.com");		
		List<JobApplication> apps=sf.searchActiveJobApplication( employee.getId());
		WebApplication webapp=new WebApplication(apps.get(0).getId(), apps.get(0).getCompver(),apps.get(0).getEmpver(),apps.get(0).getEmpid(),apps.get(0).getOffer().getId());		
		Response response = target("/companychoice/verify/").request().put(Entity.entity(webapp, MediaType.APPLICATION_JSON));
		Assert.assertEquals(Status.OK.getStatusCode(),response.getStatus());
	}
	


}
