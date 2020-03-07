package webresources;


import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import gr.aueb.mscis.sample.model.Company;

@XmlRootElement
public class Webcompany {
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
	private String compname;
	//@XmlElement
	private String AFM;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCompname() {
		return compname;
	}
	public void setCompname(String compname) {
		this.compname = compname;
	}
	public String getAFM() {
		return AFM;
	}
	public void setAFM(String AFM) {
		this.AFM = AFM;
	}

	public Webcompany(){}
	public Webcompany(String email,String pass,String passver,String compname,String afm){
		this.email=email;
		this.pass=pass;
		this.passver=passver;
		this.compname=compname;
		this.AFM= AFM;
		

	}

}
