package gr.aueb.mscis.sample.service;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.mscis.sample.model.*;
import gr.aueb.mscis.sample.persistence.Initializer;
import gr.aueb.mscis.sample.persistence.JPAUtil;

public class JobInterestServiceTest {
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
			//Initializer dataHelper = new Initializer();
			//dataHelper.eraseData();
			em.close();
		}
		
		@Test
		public void testPersistSearchJob(){			
			JobInterestService service = new JobInterestService();
			List<JobOffer> joboffers = service.searchJobOffers(JOB.Chef);			
			Assert.assertEquals(2,joboffers.size());							
		}
		
		@Test
		public void testEmployeeInterest(){			
			JobInterestService service = new JobInterestService();
			Employee e = searchEmployee("employee@prepare.com");
			JobOffer offer= searchOffer("company@prepare.com","Chef");
			JobApplication application = service.employeeInterest(e.getId(),offer.getId());
			
			JobApplication savedApplication= em.find(JobApplication.class, application.getId());
			
			Assert.assertNotNull(savedApplication);
		}
		
		
		public Employee searchEmployee(String email){
			Query query = em.createQuery("select u from User u where USERTYPE like :type and email like :mail");
			//System.out.println(email);
			query.setParameter("mail", email);
			query.setParameter("type", "employee");
			
			List<Employee> users = query.getResultList();
			
			return users.get(0);
		}
		
		public JobOffer searchOffer(String email,String job){
			Company c = searchCompany(email);			
			Query query = em.createQuery("select o from JobOffer o where Active=true and compid like :cid and Job like :jobdescr");
			//System.out.println(email);
			query.setParameter("cid", c.getId());
			query.setParameter("jobdescr", job);
			
			List<JobOffer> offers = query.getResultList();
			
			return offers.get(0);
		}
		
		public Company searchCompany(String email){
			Query query = em.createQuery("select u from User u where USERTYPE like :type and email like :mail");			
			query.setParameter("mail", email);
			query.setParameter("type", "company");
			List<Company> users = query.getResultList();			
			return users.get(0);
		}
		
					
	}