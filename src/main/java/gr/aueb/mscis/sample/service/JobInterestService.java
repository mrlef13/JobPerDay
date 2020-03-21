package gr.aueb.mscis.sample.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import gr.aueb.mscis.sample.model.*;
import gr.aueb.mscis.sample.persistence.JPAUtil;

public class JobInterestService {
	EntityManager em=JPAUtil.getCurrentEntityManager();
	
	public JobInterestService() {
		em = JPAUtil.getCurrentEntityManager();
		} 
	
	public List<JobOffer> searchJobOffers(JOB job) {		
		Date date1 = new Date();
		Query query = em.createQuery("select r from JobOffer r where Job like :job and Active=true and Expirationdate > :currentdate");		
		query.setParameter("job", job.toString());
		query.setParameter("currentdate",date1);		
		List<JobOffer> results = query.getResultList();
		System.out.println("searchJobOffers --> "+results.size());
		return results;
	}

	public JobApplication employeeInterest(int employeeid,int jobofferid) {
				
		JobApplication app = new JobApplication();		
		Employee e = em.find(Employee.class,employeeid);
		JobOffer j = em.find(JobOffer.class,jobofferid);

		if (e.getId()>0 && j.getId()>0 ) {			
			app.setEmpid(employeeid);
			app.setOffer(j);
		
			e.applicationset.add(app);
			j.apps.add(app);	
			em.persist(app);		
			return app;
		}
		else return null;
	}
}
