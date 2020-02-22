package gr.aueb.mscis.model;

import java.util.Date;
import java.text.*;  
import org.junit.Assert;
import org.junit.Test;

import gr.aueb.mscis.sample.model.*;

public class JobOfferTest {

	@Test
	public void NewJobOffer() {
		Date d = new Date();
	    String initdate= "22/09/2020";
	    
	    Date date1 = null;
		try {
			date1 = new SimpleDateFormat("dd/MM/yyyy").parse(initdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		JobOffer c= new JobOffer(101,d,2,5,date1,8);
		
		//public JobOffer(int id , Date Entrydate, int Entryhour, int Endhour, Date Exprirationdate, int Payment, boolean active) {
		Assert.assertEquals(101, c.getId());
		Assert.assertEquals(d, c.getEntrydate());
		Assert.assertEquals(2, c.getEntryHour());
		Assert.assertEquals(5, c.getEndhour());
		Assert.assertEquals(date1, c.getExprirationdate());
		Assert.assertEquals(8, c.getPayment());
	}
}
