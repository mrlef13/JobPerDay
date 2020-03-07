package webresources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import gr.aueb.mscis.sample.model.JOB;
import gr.aueb.mscis.sample.model.JobOffer;
import gr.aueb.mscis.sample.service.JobOfferService;

@Path("joboffer")
public class WebOffer {
	@Context
	UriInfo uriInfo;
	

@POST
@Consumes(MediaType.APPLICATION_JSON)
public Response createJobOffer(Webjoboffer webjoboffer) {
	JobOffer joboffer= new JobOffer();
	JobOfferService service  = new JobOfferService();
	
	System.out.println("Peos -->"+webjoboffer.getEmail()+" "+ webjoboffer.getJob()+" "+ webjoboffer.getEntryDate()+" "+ webjoboffer.getEntryHour()+" "+ webjoboffer.getEndHour()+" "+ webjoboffer.getExpirationDate()+" "+ webjoboffer.getPayment());
	
	
	for (JOB j : JOB.values()) {
		System.out.println(webjoboffer.getJob()+"="+j.toString());
        if (webjoboffer.getJob().equals(j.toString())) {
        	System.out.println("true");
            joboffer =service.createJoboffer(webjoboffer.getEmail(), j, webjoboffer.getEntryDate(), webjoboffer.getEntryHour(), webjoboffer.getEndHour(), webjoboffer.getExpirationDate(), webjoboffer.getPayment());           
            break;
        }
    }
		 
	if (joboffer.getId()>0)	return Response.ok().build();
	else return Response.noContent().build();
	}

}
