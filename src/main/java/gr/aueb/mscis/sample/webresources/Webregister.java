package gr.aueb.mscis.sample.webresources;
import java.net.URI;

import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.client.*;
import gr.aueb.mscis.sample.model.Employee;
import gr.aueb.mscis.sample.persistence.JPAUtil;
import gr.aueb.mscis.sample.service.RegistrationService;
import gr.aueb.mscis.sample.model.Company;

@Path("registration")
public class Webregister {
	
	@Context
	UriInfo uriInfo;
	

@POST
@Path("employee")
@Consumes(MediaType.APPLICATION_XML)
public Response createEmployee(Webemployee webemployee) {
	
	RegistrationService service  = new RegistrationService(); 				
	Employee employee =service.registerEmployee(webemployee.getEmail(), webemployee.getPass(), webemployee.getPassver(), webemployee.getFirst(), webemployee.getLast(), webemployee.getPhone());	
	return Response.ok().build();

	}

@POST
@Path("company")
@Consumes(MediaType.APPLICATION_XML)
public Response createCompany(Webcompany webcompany) {
	RegistrationService service  = new RegistrationService(); 			
	Company company =service.registerCompany(webcompany.getEmail(), webcompany.getPass(), webcompany.getPassver(), webcompany.getCompname(), webcompany.getAFM());	
	return Response.ok().build();	
	}
}

