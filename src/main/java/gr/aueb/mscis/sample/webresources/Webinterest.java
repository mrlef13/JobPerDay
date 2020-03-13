package gr.aueb.mscis.sample.webresources;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import gr.aueb.mscis.sample.model.*;
import gr.aueb.mscis.sample.service.JobInterestService;

@Path("interest/{job}")
public class Webinterest {

	
@GET
@Produces(MediaType.APPLICATION_JSON)
public List<JobOffer> getActiveJobOffers(@PathParam("job") String job) {
	
	List<JobOffer> joboffers = null;
	
	for (JOB j : JOB.values()) {
		if (job.equals(j.toString())) {
			JobInterestService service  = new JobInterestService();
			joboffers=service.searchJobOffers(j);
			System.out.println("This is my new test; you fucking bitch -->"+joboffers.size());
			break;
		}
	}	
	return joboffers;
	}


}
