package webresources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import gr.aueb.mscis.sample.model.*;
import gr.aueb.mscis.sample.service.JobInterestService;

@Path("interest")
public class Webinterest {

	
@GET
@Produces(MediaType.APPLICATION_XML)
public List<JobOffer> getActiveJobOffers(@QueryParam("job") String job) {
	
	List<JobOffer> joboffers = null;
	
	for (JOB j : JOB.values()) {
		if (job==j.toString()) {
			JobInterestService service  = new JobInterestService();
			joboffers=service.searchJobOffers(j);
			break;
		}
	}
	
	/*
	 * TODO: need a new list of webclass and assign every  
	 * 
	 * */
	return joboffers;
	}
}
