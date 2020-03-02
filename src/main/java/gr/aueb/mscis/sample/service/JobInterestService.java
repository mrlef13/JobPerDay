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
		//em = JPAUtil.getCurrentEntityManager();
		Date date1 = new Date();
		Query query = em.createQuery("select r from JobOffer r where Job like :job and Active=true and Expirationdate > :currentdate");
		//System.out.println(email);
		query.setParameter("job", job.toString());
		query.setParameter("currentdate",date1);		
		List<JobOffer> results = query.getResultList();
		
		return results;
	}

	public JobApplication employeeInterest(int employeeid,int jobofferid) {
				
		JobApplication app = new JobApplication();
		
		Employee e = em.find(Employee.class,employeeid);
		
		app.setEmpid(employeeid);
		e.applicationset.add(app);
		
		em.persist(app);
		return app;
}

	
	
}
