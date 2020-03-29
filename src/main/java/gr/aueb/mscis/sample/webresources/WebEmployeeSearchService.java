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

import gr.aueb.mscis.sample.model.Employee;
import gr.aueb.mscis.sample.model.JobApplication;
import gr.aueb.mscis.sample.service.EmployeeSearchService;
import gr.aueb.mscis.sample.service.SearchFunctions;

@Path("employee/search/{offerid}")
public class WebEmployeeSearchService {
	
	@GET	
	@Produces(MediaType.APPLICATION_JSON)
	public List<Webemployee> employeeSearch(@PathParam("offerid") int offerid) {
		
		EmployeeSearchService service  = new EmployeeSearchService();
		List<Employee> employees = service.employeeSearch(offerid);		
		
		//Employee employee =service.editProfile(empid,webemployee.getEmail(), webemployee.getPass(), webemployee.getPassver(), webemployee.getFirst(), webemployee.getLast(), webemployee.getPhone());
		
		List<Webemployee> webemployees =new ArrayList<Webemployee>();
		for (Employee e: employees) {			
			Webemployee we= new Webemployee(e.getEmail(),e.getPassword(),e.getPassword(),e.getFirstName(),e.getLastName(),e.getphonenumber());
			webemployees.add(we);
		}
		return webemployees;
		}
	

	@GET
	@Path("interest/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public 		List<WebApplication> companyInterest (@PathParam("offerid") int offerid,@PathParam("email") String email) {
		
		EmployeeSearchService service  = new EmployeeSearchService();
		JobApplication app =service.companyInterest(offerid,email);		
		
		WebApplication webapp=new WebApplication(app.getId(), app.getCompver(),app.getEmpver(),app.getEmpid(),app.getOffer().getId());
		List<WebApplication> webapps =new ArrayList<WebApplication>();
		webapps.add(webapp);
		return webapps;
	}

}
