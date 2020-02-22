package gr.aueb.mscis.sample.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.mscis.sample.model.JOB;
import gr.aueb.mscis.sample.model.JobOffer;
import gr.aueb.mscis.sample.persistence.Initializer;
import gr.aueb.mscis.sample.persistence.JPAUtil;

public class JobOfferServiceTest {

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
		public void testPersistVallidOffer(){
			
			JobOfferService service = new JobOfferService();
			JobOffer newJobOffer = service.createJoboffer(112, JOB.Barista, "22/02/2020", 13, 18, "25/02/2020", 8);
			// EntityManager.persist() updates the ID of the persisted object
			//Assert.assertNotEquals(0, newEmployee.getemployeeid());
			JobOffer savedJobOffer = em.find(JobOffer.class, newJobOffer.getId()); 
			em = JPAUtil.getCurrentEntityManager();	
			if (newJobOffer.checkHour()) {
				em.persist(newJobOffer);	
			}
			// new session, data will be retrieved from database			
			EntityTransaction tx = em.getTransaction();
	        tx.begin();
	        tx.commit();
			Assert.assertNotNull(newJobOffer);
		//	Assert.assertEquals(0, savedEmployee.getId());
		}
		@Test
		public void testPersistInvalidJobOffer(){
			
			JobOfferService service = new JobOfferService();
			JobOffer newJobOffer = service.createJoboffer(112, JOB.Barista, "22/02/2020", 18 , 13, "25/02/2020", 8);
			// EntityManager.persist() updates the ID of the persisted object
			//Assert.assertNotEquals(0, newEmployee.getemployeeid());
			JobOffer savedJobOffer = em.find(JobOffer.class, newJobOffer.getId()); 
			em = JPAUtil.getCurrentEntityManager();	
			em.persist(newJobOffer);		
			// new session, data will be retrieved from database	
			EntityTransaction tx = em.getTransaction();
	        tx.begin();
	        tx.commit();
		}		
	}