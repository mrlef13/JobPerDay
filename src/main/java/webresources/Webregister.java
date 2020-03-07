package webresources;
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
@Consumes(MediaType.APPLICATION_JSON)
public Response createEmployee(Webemployee webemployee) {
	
	RegistrationService service  = new RegistrationService(); 	
	//Employee employee =service.registerEmployee(email, pass, passver, firstname, lastname, phonenumber);
	
	System.out.println("Get this:---> "+webemployee.getEmail()+" "+webemployee.getPass()+" "+ webemployee.getPassver()+" "+ webemployee.getFirst()+" "+ webemployee.getLast()+" "+ webemployee.getPhone());
	Employee employee =service.registerEmployee(webemployee.getEmail(), webemployee.getPass(), webemployee.getPassver(), webemployee.getFirst(), webemployee.getLast(), webemployee.getPhone());
	/*
	webemployee.setEmail(employee.getEmail());
	webemployee.setFirst(employee.getFirstName());
	webemployee.setLast(employee.getLastName());
	webemployee.setPhone(employee.getphonenumber());
	*/
	//UriBuilder ub = uriInfo.getAbsolutePathBuilder();
	//URI newURI = ub.path(Integer.toString(employee.getId())).build();
	/*
	if (employee.getId()>0)	return Response.ok().build();
	else return Response.noContent().build();
	*/
	//System.out.println("Get response: --> "+ Response.created(newURI).build());
	return Response.ok().build();
	//return Response.created(newURI).build();
	}

@POST
@Consumes(MediaType.APPLICATION_XML)
public Response createCompany(Webcompany webcompany) {
	
	RegistrationService service  = new RegistrationService(); 	
	
	System.out.println("Get this:---> "+webcompany.getEmail()+" "+webcompany.getPass()+" "+ webcompany.getPassver()+" "+ webcompany.getCompname()+" "+ webcompany.getAFM());
	Company company =service.registerCompany(webcompany.getEmail(), webcompany.getPass(), webcompany.getPassver(), webcompany.getCompname(), webcompany.getAFM());
	
	return Response.ok().build();
	
	}
}

