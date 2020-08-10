package com.example.loginsignup.shreya.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
/*
 1.	Id
2.	Username
3.	Password
4.	UserType(if Admin or normal User)
5.	E-mail
6.	Mobile number
7.	Confirmed
*/
@Entity
@Table( schema = "loginsignup")
public class LoginSignup {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int Id;
	
	@Column(name="usernm")
	String usernm;
	
	@Column(name="password")
	String password;
	
	@Column(name="usertype")
	String usertype;
	
	@Column(name="email")
	String email;
	
	@Column(name="mobile")
	int mobile;
	
	@Column(name="confirmed")
	String confirmed;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getUsernm() {
		return usernm;
	}

	public void setUsernm(String usernm) {
		this.usernm = usernm;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(String confirmed) {
		this.confirmed = confirmed;
	}
	
	
	
	
	
}
