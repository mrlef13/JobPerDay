package gr.aueb.mscis.sample.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.mscis.sample.model.*;
import gr.aueb.mscis.sample.persistence.Initializer;
import gr.aueb.mscis.sample.persistence.JPAUtil;

public class RegistrationServiceTest {

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
	public void testPersistAValidEmployee(){
		
		RegistrationService service = new RegistrationService();
		Employee newEmployee = service.registerEmployee("xxx111@kkk.com", "denmpaineis", "denmpaineis", "Nikos", "Fousekis", "0904987333");
		// EntityManager.persist() updates the ID of the persisted object
		//Assert.assertNotEquals(0, newEmployee.getemployeeid());
		Employee savedEmployee = em.find(Employee.class, newEmployee.getId()); 
		
		em = JPAUtil.getCurrentEntityManager();	
		em.persist(savedEmployee);		
		// new session, data will be retrieved from database	
		EntityTransaction tx = em.getTransaction();
        tx.begin();
        tx.commit();
		Assert.assertNotNull(newEmployee);
		Assert.assertNotNull(savedEmployee);
	//	Assert.assertEquals(0, savedEmployee.getId());
	}
	@Test
	public void testPersistAnInvalidEmployee(){
		
		RegistrationService service = new RegistrationService();
		Employee newEmployee = service.registerEmployee("xxx111@kkk.com", "denmpaineis", "denmp", "Nikos", "Fousekis", "0904987333");
		// EntityManager.persist() updates the ID of the persisted object
		//Assert.assertNotEquals(0, newEmployee.getemployeeid());		
		Assert.assertNull(newEmployee);
	}
	
	@Test
	public void testPersistAValidCompany(){		
		RegistrationService service = new RegistrationService();
		Company newCompany = service.registerCompany("myCompany@aueb.com", "denmpaineis", "denmpaineis", "AUEB test", "1023785446");
		Company savedCompany = em.find(Company.class, newCompany.getId());
		em = JPAUtil.getCurrentEntityManager();	
		em.persist(newCompany);		
		//Assert.assertEquals(0, savedCompany.getId());		
		Assert.assertNotNull(newCompany);
	}
	
	@Test
	public void testPersistAnInvalidCompany(){		
		RegistrationService service = new RegistrationService();
		Company newCompany = service.registerCompany("myCompany@aueb.com", "denmpaineis", "denmp", "AUEB test", "1023785446");
		Assert.assertNull(newCompany);
	}
}
