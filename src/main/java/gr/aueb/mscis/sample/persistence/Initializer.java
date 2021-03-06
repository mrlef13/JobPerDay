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

    public void  eraseData() {
        EntityManager em = JPAUtil.getCurrentEntityManager();
       
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query query = null;

        query = em.createNativeQuery("delete from APPLICATIONS");
        query.executeUpdate();
        query = em.createNativeQuery("delete from JOBOFFERS");        
        query.executeUpdate();        
        query = em.createNativeQuery("delete from USERS");
        query.executeUpdate();
        tx.commit();
    }

    public void prepareData() {

        eraseData();                              
        Employee testEmployee = new Employee("employee@prepare.com", "denmpaineis", "Nikos", "Fousekis", "0904987333");
        Employee testEmployee2 = new Employee("employee2@prepare.com", "denmpaineis", "A", "K", "42069666");
        testEmployee.JOBList.add(JOB.Chef.toString());
        testEmployee.JOBList.add(JOB.Sous_Chef.toString());
        
        testEmployee2.JOBList.add(JOB.Chef.toString());
        testEmployee2.JOBList.add(JOB.Barista.toString());
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
			d2 = new SimpleDateFormat("dd/MM/yyyy").parse("08/03/2120");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}				
        JobOffer joboffer1 =new JobOffer(JOB.Chef,d1,12,16,d2,5);
        JobOffer joboffer2 =new JobOffer(JOB.Chef,d1,16,19,d2,6);
        
        testCompany.jobofferset.add(joboffer1);
        testCompany.jobofferset.add(joboffer2);
        
        JobApplication app =new JobApplication(joboffer1,false,false,testEmployee.getId());
        JobApplication app2 =new JobApplication(joboffer2,true,false,testEmployee.getId());
        joboffer1.apps.add(app);
        joboffer2.apps.add(app2);
        testEmployee.applicationset.add(app);
        testEmployee.applicationset.add(app2);
        EntityManager em = JPAUtil.getCurrentEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
                        
        em.persist(testEmployee);
        em.persist(testEmployee2);
        em.persist(testCompany);
        joboffer1.setCompid(testCompany.getId());
        joboffer2.setCompid(testCompany.getId());
        app.setEmpid(testEmployee.getId());
        app.setOffer(joboffer1);
        app2.setEmpid(testEmployee.getId());
        app2.setOffer(joboffer2);
        em.persist(joboffer1);
        em.persist(joboffer2);
        em.persist(app);
        em.persist(app2);
        
        tx.commit();
        
    }
}