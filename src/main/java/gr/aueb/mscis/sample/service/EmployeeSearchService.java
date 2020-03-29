package gr.aueb.mscis.sample.service;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import gr.aueb.mscis.sample.model.*;
import gr.aueb.mscis.sample.persistence.JPAUtil;
import java.util.List;
public class EmployeeSearchService {
EntityManager em=JPAUtil.getCurrentEntityManager();
	
	public EmployeeSearchService() {
		em = JPAUtil.getCurrentEntityManager();
	}
	
	public List<Employee> employeeSearch(int offerid) {
		SearchFunctions sf=new SearchFunctions();
		try {
			JobOffer offer =sf.findJoboffer(offerid);
			List<Employee> employees=sf.searchEmployees(offer);			
			return employees;
		}
		catch(NullPointerException e) { 
			return null;
			}
	}
	
	public JobApplication companyInterest(int offerid,String email) {
		SearchFunctions sf=new SearchFunctions();
		JobOffer offer =sf.findJoboffer(offerid);
		Employee employee =sf.searchEmployee(email);
		List<JobApplication> apps=sf.searchActiveJobApplication(offer,employee.getId());
		
		if (apps.size()>0) {
			apps.get(0).setCompver(true);
			em.persist(apps.get(0));
			return apps.get(0);
		}
		else {
			JobApplication newapp=new JobApplication(offer,true,false,employee.getId());
			offer.apps.add(newapp);
			employee.applicationset.add(newapp);
	        em.persist(employee);
	        em.persist(offer);
	        em.persist(newapp);
	        return newapp;
		}
		
		
	}
	
	
}

