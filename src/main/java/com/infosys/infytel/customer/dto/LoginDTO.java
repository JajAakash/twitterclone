package com.infosys.infytel.customer.dto;

public class LoginDTO {

	String email;
	String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	//	public LoginDTO() {
//		super();
//	}
//	@Override
//	public String toString() {
//		return "LoginDTO [phoneNo=" + phoneNo + ", password=" + password + "]";
//	}

	
}
