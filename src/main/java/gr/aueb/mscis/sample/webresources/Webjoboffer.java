package gr.aueb.mscis.sample.webresources;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import gr.aueb.mscis.sample.model.JOB;

@XmlRootElement
public class Webjoboffer {
	
 		
private String email;
private String job;
private String entryDate;
private int entryHour;
private int endHour;
private String expirationDate;
private int payment;
	        
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getJob() {
	return job;
}
public void setJob(String job) {
	this.job = job;
}
public String getEntryDate() {
	return entryDate;
}
public void setEntryDate(String entryDate) {
	this.entryDate = entryDate;
}
public int getEntryHour() {
	return entryHour;
}
public void setEntryHour(int entryHour) {
	this.entryHour = entryHour;
}
public int getEndHour() {
	return endHour;
}
public void setEndHour(int endHour) {
	this.endHour = endHour;
}
public String getExpirationDate() {
	return expirationDate;
}
public void setExpirationDate(String expirationDate) {
	this.expirationDate = expirationDate;
}
public int getPayment() {
	return payment;
}
public void setPayment(int payment) {
	this.payment = payment;
}
		public Webjoboffer(){}
		public Webjoboffer(String email,String Job,String Entrydate, int Entryhour, int Endhour, String Exprirationdate, int Payment) {			
			this.email=email;
			this.job=Job;
			this.entryDate=Entrydate;
			this.entryHour=Entryhour;
			this.endHour=Endhour;
			this.expirationDate=Exprirationdate;
			this.payment=Payment;			
		}
}
