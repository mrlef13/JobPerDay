package webresources;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Webemployee {

@XmlElement
private String email;
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
