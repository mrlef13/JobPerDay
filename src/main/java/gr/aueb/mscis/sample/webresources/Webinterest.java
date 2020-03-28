package gr.aueb.mscis.sample.webresources;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import gr.aueb.mscis.sample.model.*;
import gr.aueb.mscis.sample.service.JobInterestService;

@Path("interest")
public class Webinterest {

	
@GET
@Path("job/{job}")
@Produces(MediaType.APPLICATION_JSON)
public List<Webjoboffer> getActiveJobOffers(@PathParam("job") String job) {
	List<JobOffer> joboffers = null;
	JobInterestService service  = new JobInterestService();
	for (JOB j : JOB.values()) {		
		if (job.equals(j.toString())) {			
			joboffers=service.searchJobOffers(j);			
			break;
		}
	}
	List<Webjoboffer> webjoboffers = new ArrayList<Webjoboffer>();
	
	for (JobOffer o: joboffers) {		
		Webjoboffer wj= new Webjoboffer(o.getId(),o.getCompid(),o.getJob(),o.getEntrydate().toString(),o.getEntryHour(),o.getEndhour(),o.getExprirationdate().toString(),o.getPayment());
		webjoboffers.add(wj);
	}
		
	return webjoboffers;
}


@POST
@Path("employee")
@Consumes(MediaType.APPLICATION_XML)
public Response postEmployeeInterest(WebEmployeeInterest webemployeeinterest) {
	
	JobInterestService service  = new JobInterestService();
	
	
	JobApplication app =service.employeeInterest(webemployeeinterest.getEmployeeid(), webemployeeinterest.getJobofferid());
	app.setEmpver(true);app.setCompver(true);
	
	
	if (app.getId()>0 ) return Response.ok().build();		
	else return Response.noContent().build();
	
	}
}
