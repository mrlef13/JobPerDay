package gr.aueb.mscis.sample.webresources;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.mscis.sample.model.Company;
import gr.aueb.mscis.sample.model.Employee;
import gr.aueb.mscis.sample.model.JobApplication;
import gr.aueb.mscis.sample.model.JobOffer;
import gr.aueb.mscis.sample.persistence.Initializer;
import gr.aueb.mscis.sample.persistence.JPAUtil;


	
	public class WebInterestTest extends JerseyTest {
		private Initializer dataHelper;
		protected EntityManager em=JPAUtil.getCurrentEntityManager();			
	    	    
	    @Override
		public Application configure() {						
			return new ResourceConfig( Webinterest.class);			
		}
	    
		@Override		
		public void setUp() throws Exception {
			super.setUp();
			dataHelper = new Initializer();
			dataHelper.prepareData();
		}

		public  WebInterestTest() {
			super();
		}
		
		@Test
		public void testGetJobOffer() {
			Invocation.Builder builder=target("/interest/Chef").request().accept(MediaType.APPLICATION_JSON);					
			List<JobOffer> joboffers= builder.get(new GenericType<List<JobOffer>>() {});
			Assert.assertEquals(2,joboffers.size());
		}
		
		@Test
		public void testpostEmployeeInterest() {		
			Employee e = searchEmployee("employee@prepare.com");
			JobOffer offer= searchOffer("company@prepare.com","Chef");
			WebEmployeeInterest webemployeeinterest=new WebEmployeeInterest(e.getId(), offer.getId());
			Response response = target("/interest/employee").request().post(Entity.entity(webemployeeinterest, MediaType.APPLICATION_XML));			
			System.out.println("testpostEmployeeInterest --> status:"+response.getStatus());
			Assert.assertEquals(Status.OK.getStatusCode(),response.getStatus());
		}
		
		public Employee searchEmployee(String email){
			Query query = em.createQuery("select u from User u where USERTYPE like :type and email like :mail");
			//System.out.println(email);
			query.setParameter("mail", email);
			query.setParameter("type", "employee");
			
			List<Employee> users = query.getResultList();
			
			return users.get(0);
		}
		
		public JobOffer searchOffer(String email,String job){
			Company c = searchCompany(email);			
			Query query = em.createQuery("select o from JobOffer o where Active=true and compid like :cid and Job like :jobdescr");
			//System.out.println(email);
			query.setParameter("cid", c.getId());
			query.setParameter("jobdescr", job);
			
			List<JobOffer> offers = query.getResultList();
			
			return offers.get(0);
		}
		
		public Company searchCompany(String email){
			Query query = em.createQuery("select u from User u where USERTYPE like :type and email like :mail");			
			query.setParameter("mail", email);
			query.setParameter("type", "company");
			List<Company> users = query.getResultList();			
			return users.get(0);
		}
	}