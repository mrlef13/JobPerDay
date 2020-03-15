package gr.aueb.mscis.sample.webresources;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class WebEmployeeInterest {
	//@XmlElement
	private int employeeid;

	//@XmlElement
	private int jobofferid;
	
	public WebEmployeeInterest(){}
	
	public WebEmployeeInterest(int employeeid,int jobofferid){
		this.employeeid=employeeid;
		this.jobofferid=jobofferid;
	}
	
	public int getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	public int getJobofferid() {
		return jobofferid;
	}

	public void setJobofferid(int jobofferid) {
		this.jobofferid = jobofferid;
	}

}
