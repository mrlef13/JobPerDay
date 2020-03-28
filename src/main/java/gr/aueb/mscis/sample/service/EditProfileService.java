package gr.aueb.mscis.sample.service;

import java.util.List;

import javax.persistence.EntityManager;

import gr.aueb.mscis.sample.model.Employee;
import gr.aueb.mscis.sample.model.JobOffer;
import gr.aueb.mscis.sample.persistence.JPAUtil;

public class EditProfileService {
EntityManager em=JPAUtil.getCurrentEntityManager();
	
	public EditProfileService() {
		em = JPAUtil.getCurrentEntityManager();
	} 
		
	public boolean addToJobList(int empid,String job) {
		SearchFunctions sf =new SearchFunctions();
		try{		
			Employee employee=sf.searchEmployee(empid);
			if (!employee.JOBList.contains(job)) {
				employee.JOBList.add(job);
				em.persist(employee);			
			}
		}catch(NullPointerException e) {
			return false;
		}
		return true;
	}
		
	public boolean removeFromJobList(int empid,String job) {
		SearchFunctions sf =new SearchFunctions();
		try{		
			Employee employee=sf.searchEmployee(empid);
			if (employee.JOBList.contains(job)) {
				employee.JOBList.remove(job);
				em.persist(employee);			
			}
		}catch(NullPointerException e) {
			return false;
		}
		return true;		
	}
	
	public boolean putAvailiability(int empid,Boolean availiable) {
		SearchFunctions sf =new SearchFunctions();
		try {			
			Employee employee=sf.searchEmployee(empid);
			employee.availability=availiable;			
			em.persist(employee);				
			return true;
		}catch(NullPointerException e) {
			return false;
		}
	}
	
	public Employee editProfile(int empid,String email, String pass,String passver, String firstname, String lastname, String phonenumber) {
		SearchFunctions sf =new SearchFunctions();
		boolean flag=false;		
		Employee check_employee=sf.searchEmployee(email);
		if(check_employee==null) {
			flag=true;
		}
		try {			
			Employee employee=sf.searchEmployee(empid);			
			if(flag) employee.setEmail(email);			
			if (pass==passver) employee.setPassword(pass);
			employee.setFirstName(firstname);
			employee.setLastName(lastname);			
			employee.setphonenumber(phonenumber);
			em.persist(employee);				
			return employee;
		}catch(NullPointerException e) {
			return null;
		}
	}

}
