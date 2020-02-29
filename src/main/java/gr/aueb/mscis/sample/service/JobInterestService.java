package gr.aueb.mscis.sample.service;

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
		//and Active like :status and Expirationdate < :currentdate
		Query query = em.createQuery("select r from JobOffer r where Job like :job");
		//System.out.println(email);
		query.setParameter("job", job.toString());
		//query.setParameter("status",true);
		//query.setParameter("currentdate",date1);
		List<JobOffer> results = query.getResultList();
		
		/*
		Query query1 = em.createQuery("select r from User r");
		List<User> userlist = query1.getResultList();		
		
		for (User u : userlist){
			System.out.println("user id: "+u.getId()+" , email: "+u.getEmail()+" , pass: "+ u.getPassword());
		}
		
		for (JobOffer i : results){
			System.out.println("Comany id: "+i.getCompid()+" , jobofferid: "+i.getId()+" --> "+ i.getJob());
		}
		*/
		
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
