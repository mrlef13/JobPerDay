package gr.aueb.mscis.sample.service;

import javax.persistence.EntityManager;

import gr.aueb.mscis.sample.model.Employee;
//import gr.aueb.mscis.sample.model.User;
import gr.aueb.mscis.sample.persistence.JPAUtil;

public class EmployeeService {
	
EntityManager em;
	
public EmployeeService() {
	em = JPAUtil.getCurrentEntityManager();
	}

public Employee Registeremployee (String email, String pass, String passver, String firstname, String lastname, String phonenumber) {
		
	if (pass == passver) {//also check if email exists
		//User user = new User();
		Employee employee= new Employee();
		//user.setPassword(pass);
		//user.setEmail(email);
		//employee.RegistrationEmployee(user);		
		employee.setEmail(email);
		employee.setPassword(pass);
		employee.setFirstName(firstname);
		employee.setLastName(lastname);
		employee.setphonenumber(phonenumber);
	return employee;
	}
	else return null;
	
}
}