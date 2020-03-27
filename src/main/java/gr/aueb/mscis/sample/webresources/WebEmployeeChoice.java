package gr.aueb.mscis.sample.webresources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import gr.aueb.mscis.sample.model.Company;
import gr.aueb.mscis.sample.model.JobApplication;
import gr.aueb.mscis.sample.model.JobOffer;
import gr.aueb.mscis.sample.service.EmployeeChoiceService;
import gr.aueb.mscis.sample.service.RegistrationService;
import gr.aueb.mscis.sample.service.SearchFunctions;

@Path("employeechoice")
public class WebEmployeeChoice {

	
	@GET
	@Path("companyoffers/{compid}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Webjoboffer> getValidOffers(@PathParam("compid") int compid) {

		EmployeeChoiceService service  = new EmployeeChoiceService();
		List<JobOffer> joboffers = service.getValidOffers(compid);			
		List<Webjoboffer> webjoboffers = new ArrayList<Webjoboffer>();
		
		for (JobOffer o: joboffers) {			
			Webjoboffer wj= new Webjoboffer(o.getId(),o.getCompid(),o.getJob(),o.getEntrydate().toString(),o.getEntryHour(),o.getEndhour(),o.getExprirationdate().toString(),o.getPayment());
			webjoboffers.add(wj);
		}
		return webjoboffers;
		}
	
	@POST
	@Path("applications")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<WebApplication> getApplications(Webjoboffer webjoboffer) {
		List<JobApplication> jobapps=null;
		List<WebApplication> webapps= new ArrayList<WebApplication>();
		EmployeeChoiceService service  = new EmployeeChoiceService();
		SearchFunctions sf =new SearchFunctions();
		
		if (webjoboffer.getId()>0) {
			JobOffer offer=sf.findJoboffer(webjoboffer.getId());
			jobapps=service.getApplications(offer);
			
		}
		for (JobApplication a :jobapps) {
			WebApplication webapp=new WebApplication(a.getId(), a.getCompver(),a.getEmpver(),a.getEmpid(),a.getOffer().getId());
			webapps.add(webapp);
		}
		return webapps;
		
	}
	
	@POST
	@Path("verify")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response appVerification (WebApplication webapp) {
		SearchFunctions sf =new SearchFunctions();
		
		JobApplication app =sf.findJobApplication(webapp.getId());
		
		EmployeeChoiceService service  = new EmployeeChoiceService();
		boolean flag=service.appVerification(app);
		
		if(flag) {
			return Response.ok().build();	
		}else return Response.status(401).build();
		
	}
	
}