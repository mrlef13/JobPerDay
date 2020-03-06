package webresources;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Webemployee {

@XmlElement
private String email;

@XmlElement
private String pass;
@XmlElement
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
@XmlElement
private String first;
@XmlElement
private String last;
@XmlElement
private String phone;

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getFirst() {
	return first;
}
public void setFirst(String first) {
	this.first = first;
}
public String getLast() {
	return last;
}
public void setLast(String last) {
	this.last = last;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
	

}
