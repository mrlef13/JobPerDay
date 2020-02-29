package gr.aueb.mscis.sample.service;
import java.util.List;

import javax.persistence.EntityManager;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.mscis.sample.model.JOB;
import gr.aueb.mscis.sample.model.JobOffer;
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
			System.out.println(joboffers.size());
			Assert.assertEquals(2,joboffers.size());							
		}
				
	}