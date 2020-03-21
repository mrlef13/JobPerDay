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
	System.out.println("getActiveJobOffers -->"+job);
	List<JobOffer> joboffers = null;
	JobInterestService service  = new JobInterestService();
	for (JOB j : JOB.values()) {
		System.out.println("getActiveJobOffers: in if -->"+j);
		if (job.equals(j.toString())) {			
			joboffers=service.searchJobOffers(j);
			System.out.println("getActiveJobOffers: in for -->"+joboffers.size());
			break;
		}
	}
	 
		
	System.out.println("getActiveJobOffers: out of for -->"+joboffers.size());
	System.out.println("getActiveJobOffers: out of for -->"+joboffers.get(0).getId());
	System.out.println("getActiveJobOffers: out of for -->"+joboffers.get(1).getId());
	List<Webjoboffer> webjoboffers = new ArrayList<Webjoboffer>();
	
	for (JobOffer o: joboffers) {
		System.out.println("getActiveJobOffers:(o)-->"+o.getCompid()+","+o.getEndhour()+", "+o.getEntryHour()+", "+o.getId()+", "+o.getJob()+", "+o.getPayment()+", "+o.getActive()+", "+o.getEntrydate()+", "+o.getExprirationdate());
		Webjoboffer wj= new Webjoboffer(Integer.toString(o.getCompid()),o.getJob(),o.getEntrydate().toString(),o.getEntryHour(),o.getEndhour(),o.getExprirationdate().toString(),o.getPayment());
		webjoboffers.add(wj);
	}
	
	/*public Webjoboffer(String email,String Job,String Entrydate, int Entryhour, int Endhour, String Exprirationdate, int Payment) {			
		this.email=email;
		this.job=Job;
		this.entryDate=Entrydate;
		this.entryHour=Entryhour;
		this.endHour=Endhour;
		this.expirationDate=Exprirationdate;
		this.payment=Payment;			
	}
	*/
	System.out.println("getActiveJobOffers: out of for -->"+webjoboffers.size());
	return webjoboffers;
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
