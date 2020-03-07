package webresources;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import gr.aueb.mscis.sample.model.JOB;

@XmlRootElement
public class Webjoboffer {
	
 @XmlTransient
 private int id;

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
   private String email;
		public String getemail() {
		return email;
			}
	    public void setemail(String email) {
		this.email = email;
			}
	      
	private String Entrydate;
		
		public String getEntrydate() {
			return Entrydate;
		}
		public void setEntrydate(String Entrydate) {
			this.Entrydate = Entrydate;
		}
     private int Entryhour;
		
		public int getEntryhour() {
			return Entryhour;
		}
		public void setEntryhour(int Entryhour) {
			this.Entryhour = Entryhour;
		}	
	 private int Endhour;
				
        public int getEndhour() {
	       return Endhour;
				}
        public void setEndhour(int Endhour) {
			this.Endhour = Endhour;
       }
	private String Expirationdate;
			
			public String getExpirationdate() {
				return Expirationdate;
	        }
			public void setExpirationdate(String Expirationdate) {
				this.Expirationdate = Expirationdate;
		    }
			private int Payment;
			
	        public int getPayment() {
		       return Payment;
		   }	
	        @XmlTransient
       private boolean Active;
			
	        public boolean getActive() {
		       return Active;
		    }	
           protected JOB Job;
			
	     public JOB getJob() {
		       return Job;
	        }
	        

		public Webjoboffer(){}
		public Webjoboffer(String email,JOB Job,String Entrydate, int Entryhour, int Endhour, String Exprirationdate, int Payment) {			
			this.email=email;
			this.Job=Job;
			this.Entrydate=Entrydate;
			this.Entryhour=Entryhour;
			this.Endhour=Endhour;
			this.Expirationdate=Exprirationdate;
			this.Payment=Payment;
			

		}
}
