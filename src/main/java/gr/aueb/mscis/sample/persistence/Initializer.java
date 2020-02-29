package gr.aueb.mscis.sample.persistence;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


import gr.aueb.mscis.sample.model.*;
//import gr.aueb.mscis.sample.model.Movie;

import java.util.Date;
public class Initializer  {


    /**
     * Remove all data from database.
     * The functionality must be executed within the bounds of a transaction
     */
    public void  eraseData() {
        EntityManager em = JPAUtil.getCurrentEntityManager();
       
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query query = null;

        query = em.createNativeQuery("delete from JOBOFFERS");        
        query.executeUpdate();
        query = em.createNativeQuery("delete from APPLICATIONS");
        query.executeUpdate();
        query = em.createNativeQuery("delete from USERS");
        query.executeUpdate();    
        tx.commit();
    }

    public void prepareData() {

        eraseData();                      
        User testUser = new User("user@prepare.com", "pass1");
        Employee testEmployee = new Employee("employee@prepare.com", "denmpaineis", "Nikos", "Fousekis", "0904987333");
        Company testCompany = new Company("company@prepare.com", "denmpaineis", "myComp", "0123456789");
        Date d1=null;
		try {
			d1 = new SimpleDateFormat("dd/MM/yyyy").parse("29/02/2020");
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        Date d2=null;;
		try {
			d2 = new SimpleDateFormat("dd/MM/yyyy").parse("08/03/2020");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}				
        JobOffer joboffer1 =new JobOffer(JOB.Chef,d1,12,16,d2,5);
        JobOffer joboffer2 =new JobOffer(JOB.Chef,d1,16,19,d2,6);
        
        testCompany.jobofferset.add(joboffer1);
        testCompany.jobofferset.add(joboffer2);
        EntityManager em = JPAUtil.getCurrentEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        try {em.persist(testUser);
        }catch(EntityExistsException e){}
        
        //em.persist(testUser);
        em.persist(testEmployee);
        em.persist(testCompany);
        joboffer1.setCompid(testCompany.getId());
        joboffer2.setCompid(testCompany.getId());
        em.persist(joboffer1);
        em.persist(joboffer2);
        tx.commit();
        
    }
}
