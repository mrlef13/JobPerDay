package gr.aueb.mscis.sample.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import gr.aueb.mscis.sample.model.*;
import gr.aueb.mscis.sample.persistence.JPAUtil;

public class EmployeeChoiceService {
	EntityManager em=JPAUtil.getCurrentEntityManager();
	
	public EmployeeChoiceService() {
		em = JPAUtil.getCurrentEntityManager();
	} 
		
	public List<JobOffer> getValidOffers(int compid) {
		SearchFunctions sf =new SearchFunctions();
		List<JobOffer> joboffers=sf.searchActiveJobOffers(compid);
		
		System.out.println("getValidOffers -->"+joboffers.get(0).getCompid()+", "+joboffers.get(0).getJob());
		return joboffers;
	}
	
	public List<JobApplication> getApplications(JobOffer offer) {
		SearchFunctions sf =new SearchFunctions();
		List<JobApplication> jobapps=sf.searchActiveJobApplication(offer);
		return jobapps;
	}
	
	public void appVerification (JobApplication app) {
		
		app.setCompver(true);
		JobOffer offer=	app.getOffer();
		offer.setActive(false);
		
		em.persist(app);
		em.persist(offer);
		
	}
	
}
