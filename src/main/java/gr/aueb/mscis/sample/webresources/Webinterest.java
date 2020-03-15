package gr.aueb.mscis.sample.webresources;


import java.util.List;

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
@Path("{job}")
@Produces(MediaType.APPLICATION_JSON)
public List<JobOffer> getActiveJobOffers(@PathParam("job") String job) {
	
	List<JobOffer> joboffers = null;
	JobInterestService service  = new JobInterestService();
	for (JOB j : JOB.values()) {
		if (job.equals(j.toString())) {			
			joboffers=service.searchJobOffers(j);			
			break;
		}
	}	
	return joboffers;
}

@POST
@Path("employee")
@Consumes(MediaType.APPLICATION_XML)
//public Response postEmployeeInterest(@QueryParam("emplid") int emplid,@QueryParam("offerid") int offerid) {
public Response postEmployeeInterest(WebEmployeeInterest webemployeeinterest) {
	
	JobInterestService service  = new JobInterestService();
	
	//System.out.println("webemployeeinterest -->"+webemployeeinterest.getEmployeeid()+" "+webemployeeinterest.getJobofferid());
	JobApplication app =service.employeeInterest(webemployeeinterest.getEmployeeid(), webemployeeinterest.getJobofferid());
	app.setEmpver(true);app.setCompver(true);
	//System.out.println("app --> employeeid:"+app.getEmpid()+", appid:"+app.getId()+", compver:"+app.getCompver()+" empver:"+app.getEmpver()) ;
	
	if (app.getId()>0 ) return Response.ok().build();		
	else return Response.noContent().build();
	
	}
}
