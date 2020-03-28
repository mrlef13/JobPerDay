package gr.aueb.mscis.sample.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
//import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
//import javax.persistence.Table;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("employee")
public class Employee extends User {
		
	@Column(name = "phonenumber", length = 10, nullable = true)
	private String phonenumber;
	
	@Column(name = "FirstName", length = 50, nullable = true)
	private String FirstName;
	
	@Column(name = "LastName", length = 50, nullable = true)
	private String LastName;
	
	@Column(name="Joblist", nullable=true)
	public HashSet<String> JOBList= new HashSet<String>();
	
	@Column(name="Available", length= 1, nullable=true)
	public Boolean availability=true;
	
	@OneToMany(mappedBy="empid")
	public Set<JobApplication> applicationset = new HashSet<JobApplication>(); 
	
	public Employee() {}
	public Employee(String email, String pass, String firstname, String lastname, String phonenumber) {
		this.email=email;
		this.password =pass;
		this.FirstName =firstname;
		this.LastName= lastname;
		this.phonenumber=phonenumber;
	}
	
	public String getphonenumber () {return this.phonenumber; }
	public void setphonenumber (String phonenumber) {this.phonenumber=phonenumber;}
	
	public String getFirstName () {return this.FirstName; }
	public void setFirstName (String FirstName) {this.FirstName=FirstName;}
	
	public String getLastName () {return this.LastName; }
	public void setLastName (String LastName) {this.LastName=LastName;}
		
	
}
