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
@DiscriminatorColumn(name = "product_type", discriminatorType = DiscriminatorType.STRING)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;

	@Column(name = "email", length = 50, nullable = false)
	protected String email;

	@Column(name = "password", length = 20, nullable = false)
	protected String password;

	public User() {
	}

	public User(int userid, String email, String password) {
		this.user_id = userid;
		this.email = email;
		this.password = password;
	}

	public void setId(int id) {
		this.user_id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return this.user_id;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPassword() {
		return this.password;
	}

	/*
	 * public boolean passwordVerification (String passwordver) { if (this.password
	 * == passwordver) return true; else return false; }
	 */
	/*
	 * public boolean emailVer () { return this.email.contains("@"); }
	 */
}
