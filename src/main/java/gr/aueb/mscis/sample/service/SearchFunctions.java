package gr.aueb.mscis.sample.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import gr.aueb.mscis.sample.model.*;
import gr.aueb.mscis.sample.persistence.JPAUtil;
import gr.aueb.mscis.sample.webresources.Webjoboffer;

public class SearchFunctions {
EntityManager em=JPAUtil.getCurrentEntityManager();
	
	public SearchFunctions() {
		em = JPAUtil.getCurrentEntityManager();
	} 
	public Employee searchEmployee(String email) {		
		Query query = em.createQuery("select r from Employee r where email like :mail");		
		query.setParameter("mail", email);
		List<Employee> results = query.getResultList();	
		Employee employee=results.get(0);
		return employee;
	}
	
	public Company searchCompany(String email) {		
		Query query = em.createQuery("select r from Company r where email like :mail");		
		query.setParameter("mail", email);

		List<Company> results = query.getResultList();	
		Company company=results.get(0);
		return company;
	}
	
	public List<JobOffer> searchActiveJobOffers(int compid) {		
		Query query = em.createQuery("select r from JobOffer r where compid like :id");		
		query.setParameter("id", compid);
		List<JobOffer> results = query.getResultList();			
		return results;
	}
	
	public List<JobApplication> searchActiveJobApplication(JobOffer offer) {		
		Query query = em.createQuery("select r from JobApplication r where offer like :offer");		
		query.setParameter("offer", offer);
		List<JobApplication> results = query.getResultList();			
		return results;
	}
	
	public List<JobApplication> searchActiveJobApplication(JobOffer offer,int empid) {		
		Query query = em.createQuery("select r from JobApplication r where offer like :offer and empid like :empid");		
		query.setParameter("offer", offer);
		query.setParameter("empid", empid);
		List<JobApplication> results = query.getResultList();			
		return results;
	}
	
	public JobOffer findJoboffer(int id) {				
		JobOffer offer = em.find(JobOffer.class, id);
		return offer;
	}
	
	public JobApplication findJobApplication(int id) {				
		JobApplication app = em.find(JobApplication.class, id);
		return app;
	}

}
