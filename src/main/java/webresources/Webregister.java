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
public Response createEmployee(@PathParam("email") String email,@PathParam("email")  String pass,@PathParam("pass")  String passver,@PathParam("verpass")  String firstname,@PathParam("first")  String lastname,@PathParam("phone")  String phonenumber) {
	
	RegistrationService service  = new RegistrationService(); 
	
	try {
	Employee employee =service.registerEmployee(email, pass, passver, firstname, lastname, phonenumber);
	Webemployee webemployee = new Webemployee();
	webemployee.setEmail(employee.getEmail());
	webemployee.setFirst(employee.getFirstName());
	webemployee.setLast(employee.getLastName());
	webemployee.setPhone(employee.getphonenumber());
	
	return Response.ok().build();
	} catch(NullPointerException e)
	{
		return Response.noContent().build();
	}
	
	}
}
