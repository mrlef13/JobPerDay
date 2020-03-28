package gr.aueb.mscis.sample.webresources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import gr.aueb.mscis.sample.model.Employee;
import gr.aueb.mscis.sample.model.JobApplication;
import gr.aueb.mscis.sample.service.EditProfileService;
import gr.aueb.mscis.sample.service.RegistrationService;
import gr.aueb.mscis.sample.service.SearchFunctions;

@Path("edit/{empid}")
public class WebEditProfile {

	@GET
	@Path("addjob/{job}")	
	public Response addToJobList (@PathParam("empid") int empid,@PathParam("job") String job) {				
		EditProfileService service  = new EditProfileService();
		boolean flag=service.addToJobList(empid,job);		
		if(flag) {
			return Response.ok().build();	
		}else return Response.status(401).build();
		
	}
	
	@GET
	@Path("removejob/{job}")	
	public Response removeFromJobList (@PathParam("empid") int empid,@PathParam("job") String job) {				
		EditProfileService service  = new EditProfileService();
		boolean flag=service.removeFromJobList(empid,job);		
		if(flag) {
			return Response.ok().build();	
		}else return Response.status(401).build();
		
	}
	
	@GET
	@Path("available")	
	public Response putAvailableTrue (@PathParam("empid") int empid) {				
		EditProfileService service  = new EditProfileService();
		boolean flag=service.putAvailiability(empid,true);		
		if(flag) {
			return Response.ok().build();	
		}else return Response.status(401).build();		
	}
	
	@GET
	@Path("unavailable")	
	public Response putAvailableFalse (@PathParam("empid") int empid) {				
		EditProfileService service  = new EditProfileService();
		boolean flag=service.putAvailiability(empid,false);		
		if(flag) {
			return Response.ok().build();	
		}else return Response.status(401).build();		
	}
	
	
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateEmployee(@PathParam("empid") int empid,Webemployee webemployee) {		
		EditProfileService service  = new EditProfileService(); 				
		Employee employee =service.editProfile(empid,webemployee.getEmail(), webemployee.getPass(), webemployee.getPassver(), webemployee.getFirst(), webemployee.getLast(), webemployee.getPhone());		
		return Response.ok().build();
		}
}
