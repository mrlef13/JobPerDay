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
public Date Entrydate;

@Column(name = "Entryhour", updatable = false, nullable = false)
public int Entryhour;

@Column(name = "Endhour", updatable = false, nullable = false)
public int Endhour;

@Column(name = "Expirationdate", updatable = false, nullable = false)
public Date Exprirationdate;

@Column(name = "Payment", updatable = false, nullable = false)
public int Payment;

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

}