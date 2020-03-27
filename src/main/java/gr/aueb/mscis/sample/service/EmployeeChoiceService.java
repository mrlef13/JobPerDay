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
				
		return joboffers;
	}
	
	public List<JobApplication> getApplications(JobOffer offer) {
		SearchFunctions sf =new SearchFunctions();
		List<JobApplication> jobapps=sf.searchActiveJobApplication(offer);		
		return jobapps;
	}
	
	public boolean appVerification (JobApplication app) {
		
		JobOffer offer=	app.getOffer();
		if (offer.getActive()) {
			app.setCompver(true);
			offer.setActive(false);			
			em.persist(app);
			em.persist(offer);
			return true;			
		}else return false;
	}
	
}
