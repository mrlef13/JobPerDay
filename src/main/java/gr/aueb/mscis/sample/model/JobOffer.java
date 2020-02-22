package gr.aueb.mscis.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "JOBOFFERS")
public class JobOffer {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "id", updatable = false, nullable = false)
protected int id;

@Column(name = "Entrydate", updatable = false, nullable = false)
private Date Entrydate;

@Column(name = "Entryhour", updatable = false, nullable = false)
private int Entryhour;

@Column(name = "Endhour", updatable = false, nullable = false)
private int Endhour;

@Column(name = "Expirationdate", updatable = false, nullable = false)
private Date Exprirationdate;

@Column(name = "Payment", updatable = false, nullable = false)
private int Payment;

@Column(name = "Active", updatable = true, nullable = false)
protected boolean active=true;


public JobOffer() {}

public JobOffer(int id , Date Entrydate, int Entryhour, int Endhour, Date Exprirationdate, int Payment, boolean active) {		
	this.id=id;
	this.Entrydate=Entrydate;
	this.Entryhour=Entryhour;
	this.Endhour=Endhour;
	this.Exprirationdate=Exprirationdate;
	this.Payment=Payment;
}
	//int id , Date Entrydate, int Entryhour, int Endhour, Date Exprirationdate, int Payment, boolean active)
	public void setEntrydate(Date Entrydate) {
		this.Entrydate=Entrydate;
	}
	
	public void setEntrydate(int Entryhour) {
		this.Entryhour=Entryhour;
	}
	
	public void setEndhour(int Endhour) {
		this.Endhour=Endhour;
	}
	
	public void setExprirationdate(Date Exprirationdate) {
		this.Exprirationdate=Exprirationdate;
	}
	
	public void setPayment(int Payment) {
		this.Payment=Payment;
	}
	
	public void setActive(boolean active) {
		this.active=active;
	}
	
	public int getEntrydate() {
		return this.Entryhour;
	}
	
	public int getEndhour() {
		return this.Endhour;
	}
	
	public Date getExprirationdate() {
		return this.Exprirationdate;
	}
	
	public int getPayment() {
		return this.Payment;
	}
	
	public boolean getActive() {
		return this.active;
	}
	public boolean checkHour() {
		if (this.Endhour>this.Entryhour && this.Endhour>=1 && this.Endhour<=24 && this.Entryhour>=0 && this.Entryhour<=23 ) {
			return true;
		} else return false;
	}
	
}