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

public class EmployeeSearchServiceTest {
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
		public void testEmployeeSearch(){			
			EmployeeSearchService service = new EmployeeSearchService();
			SearchFunctions sf =new SearchFunctions();
			Company company = sf.searchCompany("company@prepare.com");			
			
			List<JobOffer> joboffers = sf.searchActiveJobOffers(company.getId());	
			List<Employee> employees=service.employeeSearch(joboffers.get(0).getId());
			Assert.assertEquals(2,employees.size());
		}
		@Test
		public void testCompanyInterest() {
			EmployeeSearchService service = new EmployeeSearchService();
			SearchFunctions sf =new SearchFunctions();
			Company company = sf.searchCompany("company@prepare.com");
			Employee employee = sf.searchEmployee("employee@prepare.com");			
			
			List<JobOffer> joboffers = sf.searchActiveJobOffers(company.getId());
			JobApplication app=service.companyInterest(joboffers.get(0).getId(), "employee@prepare.com");
			
			Assert.assertEquals(joboffers.get(0).getId(),app.getOffer().getId());
			Assert.assertEquals(true,app.getCompver());
			Assert.assertEquals(employee.getId(),app.getEmpid());
			
			
		}
		
		@Test
		public void testCompanyInterest2() {
			EmployeeSearchService service = new EmployeeSearchService();
			SearchFunctions sf =new SearchFunctions();
			Company company = sf.searchCompany("company@prepare.com");
			Employee employee = sf.searchEmployee("employee2@prepare.com");			
			
			List<JobOffer> joboffers = sf.searchActiveJobOffers(company.getId());
			JobApplication app=service.companyInterest(joboffers.get(0).getId(), "employee2@prepare.com");
			
			Assert.assertNotEquals(0,app.getId());
			Assert.assertEquals(joboffers.get(0).getId(),app.getOffer().getId());
			Assert.assertEquals(true,app.getCompver());
			Assert.assertEquals(false,app.getEmpver());
			Assert.assertEquals(employee.getId(),app.getEmpid());					
			
		}

}
