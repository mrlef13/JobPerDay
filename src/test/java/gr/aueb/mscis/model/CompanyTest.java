package gr.aueb.mscis.model;

import org.junit.Assert;
import org.junit.Test;

import gr.aueb.mscis.sample.model.Company;


public class CompanyTest {

		
	@Test
	public void NewCompanyData() {
		Company c= new Company("company@test.com", "denmpaineis", "comp", "987654321");
		Assert.assertEquals(0, c.getId());
		Assert.assertEquals("company@test.com", c.getEmail());
		Assert.assertEquals("denmpaineis", c.getPassword());
		Assert.assertEquals("comp", c.getCompname());
		Assert.assertEquals("987654321", c.getAFM());
	}
	
}