package gr.aueb.mscis.sample.service;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import gr.aueb.mscis.sample.model.*;
import gr.aueb.mscis.sample.persistence.*;

public class JobOfferService {
	EntityManager em;
	
	public JobOfferService() {
		em = JPAUtil.getCurrentEntityManager();
		}


	public JobOffer createJoboffer(String email,JOB job,String entry, int entry_hour,int end_hour, String Exprirationdate, int payment ){
		JobOffer joboffer = new JobOffer();
		
		Query query = em.createQuery("select c from User c where USERTYPE like :type and email like :mail");
		//System.out.println(email);
		query.setParameter("mail", email);
		query.setParameter("type", "company");
		
		List<Company> results = query.getResultList();		
		//@SuppressWarnings("unused")
		int compid =results.get(0).getId();
		//System.out.println(compid);
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
		//comp.setId(comp_id);
		joboffer.setCompid(compid);
		joboffer.setJob(job.toString());
		results.get(0).jobofferset.add(joboffer);
		return joboffer;
	}
	
}
