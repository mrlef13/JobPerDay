package webresources;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.xml.bind.annotation.*;

import gr.aueb.mscis.sample.model.Employee;

@XmlRootElement
public class Webemployee {

//@XmlElement
private String email;

@XmlTransient
private int id;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
private String pass;
private String passver;
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
public String getPassver() {
	return passver;
}
public void setPassver(String passver) {
	this.passver = passver;
}
//@XmlElement
private String first;
//@XmlElement
private String last;
//@XmlElement
private String phone;

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getFirst() {
	return first;
}
public void setFirst(String first) {
	this.first = first;
}
public String getLast() {
	return last;
}
public void setLast(String last) {
	this.last = last;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
	

public Webemployee(){}
public Webemployee(String email,String pass,String passver,String first,String last,String phone){
	this.email=email;
	this.pass=pass;
	this.passver=passver;
	this.first=first;
	this.last=last;
	this.phone=phone;
}

public Employee getEmployee(EntityManager em) {
	
	Employee employee;
	EntityTransaction tx = em.getTransaction();
	tx.begin();
	if(this.id != 0) {
		
		employee = em.find(Employee.class, this.id);
	}
	else {
		
		employee = new Employee();
	}
	
	tx.commit();
	
//	System.out.println(this.id);
//	System.out.println(m);
	
	employee.setEmail(this.email);
	employee.setFirstName(this.first);
	employee.setLastName(this.last);
	employee.setphonenumber(this.phone);
	
	return employee;
}

}
