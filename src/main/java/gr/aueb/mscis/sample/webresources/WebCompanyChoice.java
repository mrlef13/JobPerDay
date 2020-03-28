package gr.aueb.mscis.sample.webresources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import gr.aueb.mscis.sample.model.JobApplication;
import gr.aueb.mscis.sample.service.CompanyChoiceService;
import gr.aueb.mscis.sample.service.SearchFunctions;

@Path("companychoice")
public class WebCompanyChoice {
	
	@GET
	@Path("employeeapps/{empid}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<WebApplication> getApplications(@PathParam("empid") int empid) {
		
		CompanyChoiceService service  = new CompanyChoiceService();
		List<JobApplication> apps = service.getApplications(empid);			
		List<WebApplication> webapps = new ArrayList<WebApplication>();
				
		for (JobApplication a: apps) {			
			WebApplication wa= new WebApplication(a.getId(),a.getCompver(),a.getEmpver(),a.getEmpid(),a.getOffer().getId());
			webapps.add(wa);
		}
		return webapps;
		}
	
	
	@PUT
	@Path("verify")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response appVerification (WebApplication webapp) {
		SearchFunctions sf =new SearchFunctions();		
		JobApplication app =sf.findJobApplication(webapp.getId());		
		CompanyChoiceService service  = new CompanyChoiceService();
		boolean flag=service.appVerification(app);
		
		if(flag) {
			return Response.ok().build();	
		}else return Response.status(401).build();
		
	}

}
