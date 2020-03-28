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

public class CompanyChoiceServiceTest {
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
			CompanyChoiceService service = new CompanyChoiceService();
			SearchFunctions sf =new SearchFunctions();
			Employee employee = sf.searchEmployee("employee@prepare.com");
			
			List<JobApplication>  apps = service.getApplications(employee.getId());
			Assert.assertNotNull(apps);
			Assert.assertEquals(1,apps.size());
		}
		
		@Test
		public void testGetApplications(){			
			CompanyChoiceService service = new CompanyChoiceService();
			SearchFunctions sf =new SearchFunctions();
			Employee employee = sf.searchEmployee("employee@prepare.com");
			
			List<JobApplication>  apps = service.getApplications(employee.getId());
			
			Boolean flag=service.appVerification(apps.get(0));			
			Assert.assertNotNull(flag);
			Assert.assertEquals(true,flag);
		}

}
