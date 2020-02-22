package gr.aueb.mscis.sample.persistence;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


import gr.aueb.mscis.sample.model.*;
//import gr.aueb.mscis.sample.model.Movie;


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

        query = em.createNativeQuery("delete from USERS");
        //query = em.createNativeQuery("delete from EMPLOYEE");
        //query = em.createNativeQuery("delete from COMPANY");
        query.executeUpdate();
        
        tx.commit();       
    }
    

    public void prepareData() {

        eraseData();                      
        User testUser = new User(0,"user@prepare.com", "pass1");
        //Employee testEmployee = new Employee("employee@prepare.com", "denmpaineis", "Nikos", "Fousekis", "0904987333");
        //Company testCompany = new Company("company@prepare.com", "denmpaineis", "myComp", "0123456789");
        EntityManager em = JPAUtil.getCurrentEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        try {em.persist(testUser);
        }catch(EntityExistsException e){}
        
        em.persist(testUser);
        //em.persist(testEmployee);
        //em.persist(testCompany);
        tx.commit();
        //em.persist(testCompany);
        //tx.commit();
    }
}
