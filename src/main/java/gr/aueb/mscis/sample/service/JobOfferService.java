package gr.aueb.mscis.sample.service;

import javax.persistence.EntityManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import gr.aueb.mscis.sample.model.*;
import gr.aueb.mscis.sample.persistence.JPAUtil;

public class JobOfferService {
	EntityManager em;
	
	public JobOfferService() {
		em = JPAUtil.getCurrentEntityManager();
		}


	public JobOffer createJoboffer(int comp_id,JOB job,String entry, int entry_hour,int end_hour, String Exprirationdate, int payment )  {		
		JobOffer joboffer = new JobOffer();
		
	    Date date1 = null;
		try {
			date1 = new SimpleDateFormat("dd/MM/yyyy").parse(entry);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		joboffer.setEntrydate(date1);
		joboffer.setEntryHour(entry_hour);
		joboffer.setEndhour(end_hour);
		try {
			date1 = new SimpleDateFormat("dd/MM/yyyy").parse(Exprirationdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		joboffer.setExprirationdate(date1);
		Company comp = new Company();
		//comp.setId(comp_id);
		comp.jobofferset.add(joboffer);
		return joboffer;
	}
	
}
