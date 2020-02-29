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
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//private int employee_id;
	
	@Column(name = "phonenumber", length = 10, nullable = true)
	private String phonenumber;
	
	@Column(name = "FirstName", length = 50, nullable = true)
	private String FirstName;
	
	@Column(name = "LastName", length = 50, nullable = true)
	private String LastName;
	
	public HashSet<JOB> JOBList= new HashSet<JOB>(); //Table?//
	
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
	public void setphonenumber (String x) {this.phonenumber=x;}
	
	public String getFirstName () {return this.FirstName; }
	public void setFirstName (String x) {this.FirstName=x;}
	
	public String getLastName () {return this.LastName; }
	public void setLastName (String x) {this.LastName=x;}
		
	
}
