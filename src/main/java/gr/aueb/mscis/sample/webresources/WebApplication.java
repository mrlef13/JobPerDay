package gr.aueb.mscis.sample.webresources;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import gr.aueb.mscis.sample.model.JOB;
import gr.aueb.mscis.sample.model.JobOffer;

@XmlRootElement
public class WebApplication {
	
private int id; 		
private boolean compver;
private boolean empver;
private int  empid;
private int offerid;


	public int getId() {
		return id;
	}
	public void setId(int id) {
	this.id = id;
	}

	
	public boolean isCompver() {
		return compver;
	}
	public void setCompver(boolean compver) {
		this.compver = compver;
	}
	public boolean isEmpver() {
		return empver;
	}
	public void setEmpver(boolean empver) {
		this.empver = empver;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public int getOfferid() {
		return offerid;
	}
	public void setOfferid(int offerid) {
		this.offerid = offerid;
	}
	public WebApplication(){}
	public WebApplication(int id,boolean compver,boolean empver,int empid, int offerid) {			
			this.id=id;
			this.compver=compver;
			this.empver=empver;
			this.empid=empid;
			this.offerid=offerid;
		}
		
}
