package webresources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import gr.aueb.mscis.sample.model.Company;
import gr.aueb.mscis.sample.model.JOB;
import gr.aueb.mscis.sample.model.JobOffer;
import gr.aueb.mscis.sample.service.JobOfferService;

@Path("joboffer")
public class WebOffer {
	@Context
	UriInfo uriInfo;
	

@POST
@Consumes(MediaType.APPLICATION_XML)
public Response createJobOffer(Webjoboffer webjoboffer) {
	
	JobOfferService service  = new JobOfferService(); 	

	//for (JOB j : JOB.values()) {
     //   if (Job==j.toString()) {
      //      JobOfferService service2  = new JobOfferService();
      //      jobOffers=service.JobOffers(j);
        //    break;
	JobOffer joboffer =service.createJoboffer(webjoboffer.getemail(), webjoboffer.getJob(), webjoboffer.getEntrydate(), webjoboffer.getEntryhour(), webjoboffer.getEndhour(), webjoboffer.getExpirationdate(), webjoboffer.getPayment());
	
	return Response.ok().build();

	}

}
