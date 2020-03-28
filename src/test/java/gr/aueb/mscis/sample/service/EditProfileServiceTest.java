package gr.aueb.mscis.sample.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.mscis.sample.model.Employee;
import gr.aueb.mscis.sample.persistence.Initializer;
import gr.aueb.mscis.sample.persistence.JPAUtil;

public class EditProfileServiceTest {
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
		public void testAddToJobList(){			
			EditProfileService service = new EditProfileService();
			SearchFunctions sf =new SearchFunctions();
			Employee employee = sf.searchEmployee("employee@prepare.com");
			
			boolean result = service.addToJobList(employee.getId(), "Barista");
			
			Employee check = sf.searchEmployee("employee@prepare.com");
			
			Assert.assertEquals(true,result);
			Assert.assertEquals(true,check.JOBList.contains("Barista"));
		}
		
		@Test
		public void testRemoveInvalidJob(){			
			EditProfileService service = new EditProfileService();
			SearchFunctions sf =new SearchFunctions();
			Employee employee = sf.searchEmployee("employee@prepare.com");
			
			boolean result = service.removeFromJobList(employee.getId(), "Barista");
			
			Employee check = sf.searchEmployee("employee@prepare.com");
			
			Assert.assertEquals(true,result);
			Assert.assertEquals(false,check.JOBList.contains("Barista"));
		}
		
		@Test
		public void testRemoveValidJob(){			
			EditProfileService service = new EditProfileService();
			SearchFunctions sf =new SearchFunctions();
			Employee employee = sf.searchEmployee("employee@prepare.com");
			
			boolean result = service.removeFromJobList(employee.getId(), "Chef");
			
			Employee check = sf.searchEmployee("employee@prepare.com");
			
			Assert.assertEquals(true,result);
			Assert.assertEquals(false,check.JOBList.contains("Chef"));
		}
		
		@Test
		public void testPutAvailiabilityTrue(){			
			EditProfileService service = new EditProfileService();
			SearchFunctions sf =new SearchFunctions();
			Employee employee = sf.searchEmployee("employee@prepare.com");
			
			boolean result = service.putAvailiability(employee.getId(), true);
			
			Employee check = sf.searchEmployee("employee@prepare.com");
			
			Assert.assertEquals(true,result);
			Assert.assertEquals(true,check.availability);
		}
		
		@Test
		public void testPutAvailiabilityFalse(){			
			EditProfileService service = new EditProfileService();
			SearchFunctions sf =new SearchFunctions();
			Employee employee = sf.searchEmployee("employee@prepare.com");
			
			boolean result = service.putAvailiability(employee.getId(), false);
			
			Employee check = sf.searchEmployee("employee@prepare.com");
			
			Assert.assertEquals(true,result);
			Assert.assertEquals(false,check.availability);
		}
		
		@Test
		public void testeditProfile(){			
			EditProfileService service = new EditProfileService();
			SearchFunctions sf =new SearchFunctions();
			Employee employee = sf.searchEmployee("employee@prepare.com");
			
			Employee result = service.editProfile(employee.getId(), "employee1@prepare.com", "123", "123", "fname", "lname", "7896541235");
			
			
			Assert.assertEquals("employee1@prepare.com",result.getEmail());
			Assert.assertEquals("123",result.getPassword());
			Assert.assertEquals("fname",result.getFirstName());
			Assert.assertEquals("lname",result.getLastName());
			Assert.assertEquals("7896541235",result.getphonenumber());
		}

}
