package webresources;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.client.*;
import gr.aueb.mscis.sample.model.Employee;
import gr.aueb.mscis.sample.service.RegistrationService;

@Path("registration")
public class Webregister {

@POST
@Consumes("application/xml")
public Response createEmployee(Webemployee webemployee) {
	
	RegistrationService service  = new RegistrationService(); 
		
	//Employee employee =service.registerEmployee(email, pass, passver, firstname, lastname, phonenumber);
	Employee employee =service.registerEmployee(webemployee.getEmail(), webemployee.getPass(), webemployee.getPassver(), webemployee.getFirst(), webemployee.getLast(), webemployee.getPhone());
	/*
	webemployee.setEmail(employee.getEmail());
	webemployee.setFirst(employee.getFirstName());
	webemployee.setLast(employee.getLastName());
	webemployee.setPhone(employee.getphonenumber());
	*/
	if (employee.getId()>0)	return Response.ok().build();
	else return Response.noContent().build();
	
	
	}
}
