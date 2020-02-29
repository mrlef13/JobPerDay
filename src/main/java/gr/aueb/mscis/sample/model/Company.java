package gr.aueb.mscis.sample.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

//import javax.persistence.Table;

@Entity
@DiscriminatorValue("company")
public class Company extends User{
	
@Column(name = "compname", length = 50, nullable = true)
private String compname;
@Column(name = "AFM", length = 10, nullable = true)
private String AFM;

@OneToMany(mappedBy="compid")
public Set<JobOffer> jobofferset = new HashSet<JobOffer>(); 

	public Company() {}
	public Company(String email, String pass, String compname,String AFM) {
		this.email=email;
		this.password =pass;
		this.compname =compname;
		this.AFM= AFM;		
	}
	
	public void setCompname(String compname) {		
		this.compname =compname;
	}
	public String getCompname() {		
		return this.compname;
	}
	
	public void setAFM(String AFM) {
		this.AFM =AFM;
	}
	
	public String getAFM() {
		return this.AFM;		
	}
}
