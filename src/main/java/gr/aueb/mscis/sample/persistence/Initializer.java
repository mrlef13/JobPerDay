package gr.aueb.mscis.sample.persistence;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import gr.aueb.mscis.sample.model.Employee;
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
        query.executeUpdate();
        
        tx.commit();
        
    }
    

    public void prepareData() {

        eraseData();                      

        Employee testEmployee = new Employee("dvyewjcfu@kkk.com", "denmpaineis", "Nikos", "Fousekis", "0904987333");
       
        EntityManager em = JPAUtil.getCurrentEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        /*try {em.persist(testEmployee);
        }catch(EntityExistsException e){}
        */
        em.persist(testEmployee);
        tx.commit();
    
    }
}
