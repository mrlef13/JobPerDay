package gr.aueb.mscis.sample.webresources;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import gr.aueb.mscis.sample.model.Company;
import gr.aueb.mscis.sample.model.Employee;
import gr.aueb.mscis.sample.model.JobOffer;
import gr.aueb.mscis.sample.persistence.Initializer;
import gr.aueb.mscis.sample.persistence.JPAUtil;
import gr.aueb.mscis.sample.service.SearchFunctions;

public class WebEmployeeSearchTest extends JerseyTest {
	private Initializer dataHelper;
	protected EntityManager em=JPAUtil.getCurrentEntityManager();			
    	    
    @Override
	public Application configure() {						
		return new ResourceConfig( WebEmployeeSearchService.class);			
	}
    
	@Override		
	public void setUp() throws Exception {
		super.setUp();
		dataHelper = new Initializer();
		dataHelper.prepareData();
	}

	public  WebEmployeeSearchTest() {
		super();
	}
	
	@Test
	public void testEmployeeSearch() {
		SearchFunctions sf =new SearchFunctions();
		Company company = sf.searchCompany("company@prepare.com");					
		List<JobOffer> joboffers = sf.searchActiveJobOffers(company.getId());
		
		Invocation.Builder builder=target("/employee/search/"+joboffers.get(0).getId()).request().accept(MediaType.APPLICATION_JSON);					
		List<Webemployee> webemployees= builder.get(new GenericType<List<Webemployee>>() {});		
		Assert.assertEquals(2,webemployees.size());
	}
	
	@Test
	public void testCompanyInterest() {
		SearchFunctions sf =new SearchFunctions();
		Company company = sf.searchCompany("company@prepare.com");
		Employee employee = sf.searchEmployee("employee@prepare.com");		
		List<JobOffer> joboffers = sf.searchActiveJobOffers(company.getId());
		
		Invocation.Builder builder=target("/employee/search/"+joboffers.get(0).getId()+"/interest/employee@prepare.com").request().accept(MediaType.APPLICATION_JSON);					
		List<WebApplication> webapps= builder.get(new GenericType<List<WebApplication>>() {});		
		Assert.assertEquals(1,webapps.size());
		Assert.assertNotEquals(0,webapps.get(0).getId());
		Assert.assertEquals(joboffers.get(0).getId(),webapps.get(0).getOfferid());
		Assert.assertEquals(true,webapps.get(0).isCompver());		
		Assert.assertEquals(employee.getId(),webapps.get(0).getEmpid());			
	}

}
