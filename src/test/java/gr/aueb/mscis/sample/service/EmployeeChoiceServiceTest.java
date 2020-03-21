package gr.aueb.mscis.sample.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.mscis.sample.model.*;
import gr.aueb.mscis.sample.persistence.Initializer;
import gr.aueb.mscis.sample.persistence.JPAUtil;

public class EmployeeChoiceServiceTest {
protected EntityManager em;
	
	@Before
		public void setup(){	
			// prepare database for each test
			em = JPAUtil.getCurrentEntityManager();
			Initializer dataHelper = new Initializer();
			dataHelper.prepareData();	
		}
		
		@After
		public void tearDown(){		
			em.close();
		}
		
		@Test
		public void testGetValidOffers(){			
			EmployeeChoiceService service = new EmployeeChoiceService();
			SearchFunctions sf =new SearchFunctions();
			Company company = sf.searchCompany("company@prepare.com");
			
			List<JobOffer> joboffers = service.getValidOffers(company.getId());
			Assert.assertNotNull(joboffers);
			Assert.assertEquals(2,joboffers.size());
		}
		
		@Test
		public void testGetApplications(){			
			EmployeeChoiceService service = new EmployeeChoiceService();
			SearchFunctions sf =new SearchFunctions();
			Company company = sf.searchCompany("company@prepare.com");
			
			List<JobOffer> joboffers = service.getValidOffers(company.getId());
			List<JobApplication> jobapps=service.getApplications(joboffers.get(0));
			
			Assert.assertNotNull(jobapps);
			Assert.assertEquals(1,jobapps.size());
		}
		
}
