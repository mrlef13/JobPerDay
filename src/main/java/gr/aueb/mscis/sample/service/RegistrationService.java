package gr.aueb.mscis.sample.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import gr.aueb.mscis.sample.model.*;
//import gr.aueb.mscis.sample.model.User;
import gr.aueb.mscis.sample.persistence.JPAUtil;

public class RegistrationService {
	
EntityManager em;
	
public RegistrationService() {
	em = JPAUtil.getCurrentEntityManager();
	}


public Employee registerEmployee (String email, String pass, String passver, String firstname, String lastname, String phonenumber) {		
	if (pass == passver) {		
		Employee employee= new Employee();
		employee.setEmail(email);
		employee.setPassword(pass);
		employee.setFirstName(firstname);
		employee.setLastName(lastname);
		employee.setphonenumber(phonenumber);
		em.persist(employee);		
		// new session, data will be retrieved from database	
		EntityTransaction tx = em.getTransaction();
        tx.begin();
        tx.commit();
	return employee;
	}
	else return null;
	}

public Company registerCompany (String email, String pass, String passver, String compname, String AFM) {		
	if (pass == passver) {		
		Company company= new Company();
		company.setEmail(email);
		company.setPassword(pass);
		company.setCompname(compname);
		company.setAFM(AFM);		
	return company;
	}
	else return null;
	}
}