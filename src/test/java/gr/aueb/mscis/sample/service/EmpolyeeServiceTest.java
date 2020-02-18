package gr.aueb.mscis.sample.service;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.mscis.sample.model.Employee;
import gr.aueb.mscis.sample.persistence.Initializer;
import gr.aueb.mscis.sample.persistence.JPAUtil;

public class EmpolyeeServiceTest {

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
		
		EmployeeService service = new EmployeeService();
		Employee newEmployee = service.Registeremployee("xxx111@kkk.com", "denmpaineis", "denmpaineis", "Nikos", "Fousekis", "0904987333");
		// EntityManager.persist() updates the ID of the persisted object
		//Assert.assertNotEquals(0, newEmployee.getemployeeid());
		Employee savedEmployee = em.find(Employee.class, newEmployee.getId()); 
		em = JPAUtil.getCurrentEntityManager();	
		em.persist(newEmployee);		
		// new session, data will be retrieved from database				
		//Assert.assertNotNull(savedEmployee);
		Assert.assertEquals(1, savedEmployee.getId());
	}
	@Test
	public void testPersistAnInValidEmployee(){
		
		EmployeeService service = new EmployeeService();
		Employee newEmployee = service.Registeremployee("xxx111@kkk.com", "denmpaineis", "denmp", "Nikos", "Fousekis", "0904987333");
		// EntityManager.persist() updates the ID of the persisted object
		//Assert.assertNotEquals(0, newEmployee.getemployeeid());		
		Assert.assertNull(newEmployee);
	}
}
