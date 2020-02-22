package gr.aueb.mscis.sample.model;
import java.util.HashSet;

import javax.persistence.Column;
//import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Table;

@Entity
@DiscriminatorValue("Company")
public class Employee extends User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employee_id;
	
	@Column(name = "phonenumber", length = 10, nullable = false)
	private String phonenumber;
	
	@Column(name = "FirstName", length = 50, nullable = false)
	private String FirstName;
	
	@Column(name = "LastName", length = 50, nullable = false)
	private String LastName;
	
	public HashSet<JOB> JOBList= new HashSet<JOB>(); //Table?//
	
	@Column(name="Available", length= 1, nullable=false)
	public Boolean availability=true;
	
	
	public Employee() {}
	public Employee(String email, String pass, String firstname, String lastname, String phonenumber) {
		this.email=email;
		this.password =pass;
		this.FirstName =firstname;
		this.LastName= lastname;
		this.phonenumber=phonenumber;
	}
	
	public String getphonenumber () {return this.phonenumber; }
	public void setphonenumber (String x) {this.phonenumber=x;}
	
	public String getFirstName () {return this.FirstName; }
	public void setFirstName (String x) {this.FirstName=x;}
	
	public String getLastName () {return this.LastName; }
	public void setLastName (String x) {this.LastName=x;}
	
	
	
	/*
	public Boolean RegistrationEmployee(User u) {
		this.email=u.getEmail();
		this.password=u.getPassword();
		    return true;
	}
	*/
	
}
