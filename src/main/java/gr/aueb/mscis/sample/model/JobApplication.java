package gr.aueb.mscis.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
@Entity
@Table(name = "APPLICATIONS")
public class JobApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	protected int id;
	
	@Column(name = "compver",insertable=true, updatable = true, nullable = false)
	protected boolean compver=false;			
	
	@Column(name = "empver",insertable=true, updatable = true, nullable = false)
	protected boolean empver=false;
	
	@JoinColumn(name="empid", nullable=false)
	private int empid;
	
	@ManyToOne
	@JoinColumn(name="offerref",nullable = true)
	private JobOffer offer;

	
	public JobOffer getOffer() {
		return offer;
	}

	public void setOffer(JobOffer offer) {
		this.offer = offer;
	}

	public JobApplication() {}
	
	public JobApplication(JobOffer offer,boolean compver,boolean empver,int employeeid) {
		this.offer=offer;
		this.compver=compver;
		this.empver=empver;
		this.empid=employeeid;
	}
	
	public int getId() {
		return id;
	} 
	
	public void setCompver(boolean compver) {
		this.compver=compver;
	}
	
	public boolean getCompver() {
		return compver;
	}
	
	public void setEmpver(boolean empver) {
		this.empver=empver;
	}
	
	public boolean getEmpver() {
		return empver;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}
}
