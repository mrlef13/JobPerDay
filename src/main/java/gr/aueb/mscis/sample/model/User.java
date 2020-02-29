package gr.aueb.mscis.sample.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "USERTYPE",discriminatorType = DiscriminatorType.STRING)


public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	protected int id;
	
	@Column(name = "email", length = 50, nullable = false,unique = true)
	protected String email;

	@Column(name = "password", length = 20, nullable = false)
	protected String password;

	public User() {}

	public User( String email, String password) {		
		//this.id=id;
		this.email = email;
		this.password = password;
	}	

	/*public void setId(int id) {
		this.id=id;
	}*/
	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return this.id;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPassword() {
		return this.password;
	}
}
