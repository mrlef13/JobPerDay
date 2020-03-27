package gr.aueb.mscis.sample.webresources;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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

import gr.aueb.mscis.sample.model.Company;
import gr.aueb.mscis.sample.model.Employee;
import gr.aueb.mscis.sample.model.JobApplication;
import gr.aueb.mscis.sample.model.JobOffer;
import gr.aueb.mscis.sample.persistence.Initializer;
import gr.aueb.mscis.sample.persistence.JPAUtil;
import gr.aueb.mscis.sample.service.SearchFunctions;

public class WebEmployeeChoiceTest extends JerseyTest {
	private Initializer dataHelper;
	protected EntityManager em=JPAUtil.getCurrentEntityManager();			
    	    
    @Override
	public Application configure() {						
		return new ResourceConfig( WebEmployeeChoice.class);			
	}
    
	@Override		
	public void setUp() throws Exception {
		super.setUp();
		dataHelper = new Initializer();
		dataHelper.prepareData();
	}

	public  WebEmployeeChoiceTest() {
		super();
	}
	
	@Test
	public void testGetValidOffers() {
		SearchFunctions sf =new SearchFunctions();
		Company company = sf.searchCompany("company@prepare.com");		
		Invocation.Builder builder=target("/employeechoice/companyoffers/"+company.getId()).request().accept(MediaType.APPLICATION_JSON);					
		List<Webjoboffer> joboffers= builder.get(new GenericType<List<Webjoboffer>>() {});		
		Assert.assertEquals(2,joboffers.size());
	}
	
	@Test
	public void testGetApplications() {
		SearchFunctions sf =new SearchFunctions();
		Company company = sf.searchCompany("company@prepare.com");		
		Webjoboffer webjoboffer = new Webjoboffer("company@prepare.com","Barista","10/06/2020",10,19,"19/06/2020",100);
		//Response response = target("/applications").request().get 
		//Invocation.Builder builder=target("/applications/").request().post(Entity.entity(webjoboffer, MediaType.APPLICATION_JSON));
		//List<JobApplication> apps= builder.get(new GenericType<List<JobApplication>>() {});
		//List<JobApplication> apps= target("/employeechoice/applications/").request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(Entity.json(webjoboffer), MediaType.APPLICATION_JSON);
		Response output= target("/employeechoice/applications/").request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(Entity.json(webjoboffer));
				//.accept(MediaType.TEXT_PLAIN_TYPE).post(Entity.entity(webjoboffer, MediaType.APPLICATION_JSON),JobApplication.class);
		System.out.println("testGetApplications-->"+output.getEntity());     
		//Assert.assertEquals(,);
		/*
		target("customers").request(MediaType.APPLICATION_JSON) .accept(MediaType.TEXT_PLAIN_TYPE)
        //this time we are calling post to make a HTTP POST call
        .post(, String.class);*/
	}
	
	
	
	@Test
	public void testAppVerification() {
		SearchFunctions sf =new SearchFunctions();		
		Company company = sf.searchCompany("company@prepare.com");
		Employee employee = sf.searchEmployee("employee@prepare.com");
		List<JobOffer> offers = sf.searchActiveJobOffers(company.getId());		
		List<JobApplication> apps=sf.searchActiveJobApplication(offers.get(0), employee.getId());
		WebApplication webapp=new WebApplication(apps.get(0).getId(), apps.get(0).getCompver(),apps.get(0).getEmpver(),apps.get(0).getEmpid(),apps.get(0).getOffer().getId());		
		Response response = target("/employeechoice/verify/").request().post(Entity.entity(webapp, MediaType.APPLICATION_JSON));		
		Assert.assertEquals(Status.OK.getStatusCode(),response.getStatus());
	}
	

}
