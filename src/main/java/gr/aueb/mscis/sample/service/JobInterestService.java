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
		
		return results;
	}

	public JobApplication employeeInterest(int employeeid,int jobofferid) {
		
		//System.out.println("app init -->"+employeeid+", "+jobofferid) ;
		
		JobApplication app = new JobApplication();
		
		//System.out.println("app :"+app.getId());
		
		Employee e = em.find(Employee.class,employeeid);
		//System.out.println("app before if --> e:"+e.getId());
		JobOffer j = em.find(JobOffer.class,jobofferid);
		//System.out.println("app before if --> j:"+j.getId());
		//System.out.println(e.getEmail());
		//System.out.println("app before if -->"+e.getId()+", "+j.getId()) ;
		if (e.getId()>0 && j.getId()>0 ) {
			//System.out.println("app in if -->"+e.getId()+", "+j.getId()) ;
			app.setEmpid(employeeid);
			app.setOffer(j);
		
			e.applicationset.add(app);
			j.apps.add(app);
		//System.out.println("app1 -->"+app.getEmpid()+", "+app.getId()+", "+app.getCompver()+","+app.getEmpver()) ;
			em.persist(app);
		//System.out.println("app2 -->"+app.getEmpid()+", "+app.getId()+", "+app.getCompver()+","+app.getEmpver()) ;
			return app;
		}
		else return null;
}

	
	
}
