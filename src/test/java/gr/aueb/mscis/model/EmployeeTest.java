package gr.aueb.mscis.model;

import org.junit.Assert;
import org.junit.Test;

import gr.aueb.mscis.sample.model.Employee;
public class EmployeeTest {

	@Test
	public void NewEmployeeAvailability() {
		Employee e= new Employee();
		Assert.assertEquals(true,e.availability);
	}
	
	@Test
	public void NewEmployeeid() {
		Employee e= new Employee("employee@test.com", "denmpaineis", "Nikos", "Fousekis", "0904987333");
		//Employee testEmployee = new Employee(1,"dvyewjcfu@kkk.com", "denmpaineis", "Nikos", "Fousekis", "0904987333");
		Assert.assertEquals(0, e.getId());
		Assert.assertEquals("employee@test.com", e.getEmail());
		Assert.assertEquals("denmpaineis", e.getPassword());
		Assert.assertEquals("Nikos", e.getFirstName());
		Assert.assertEquals("Fousekis", e.getLastName());
		Assert.assertEquals("0904987333", e.getphonenumber());
	}
	
}
