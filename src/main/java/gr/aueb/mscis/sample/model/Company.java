package gr.aueb.mscis.sample.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//import javax.persistence.Table;

@Entity
@DiscriminatorValue("Company")
public class Company extends User{
	//private int comp_id;
	
@Column(name = "compname", length = 50, nullable = false)
private String compname;
@Column(name = "AFM", length = 10, nullable = false)
private String AFM;
	
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
