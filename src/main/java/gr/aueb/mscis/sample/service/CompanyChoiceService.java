package gr.aueb.mscis.sample.service;

import java.util.List;

import javax.persistence.EntityManager;

import gr.aueb.mscis.sample.model.JobApplication;
import gr.aueb.mscis.sample.model.JobOffer;
import gr.aueb.mscis.sample.persistence.JPAUtil;

public class CompanyChoiceService {
EntityManager em=JPAUtil.getCurrentEntityManager();
	
	public CompanyChoiceService() {
		em = JPAUtil.getCurrentEntityManager();
	} 
		
	public List<JobApplication> getApplications(int empid) {
		SearchFunctions sf =new SearchFunctions();
		List<JobApplication> apps=sf.searchActiveJobApplication(empid);				
		return apps;
	}
	
	
	public boolean appVerification (JobApplication app) {		
		if (app.getCompver()) {
			JobOffer offer=	app.getOffer();
			app.setEmpver(true);
			offer.setActive(false);			
			em.persist(app);
			em.persist(offer);
			return true;			
		}else return false;
	}

}
