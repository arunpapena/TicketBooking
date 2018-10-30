package com.techouts.models;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class ForgotPasswordDetails {
	@NotEmpty
	@NotNull
	@Email
	private String email;
	@NotEmpty
	@NotNull
	private String contact;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
		
	@Override
	public String toString() {
		return "ForgotPasswordDetails [email=" + email + ", contact=" + contact + "]";
	}
	public ForgotPasswordDetails(String email, String contact) {
		super();
		this.email = email;
		this.contact = contact;
	}
	public ForgotPasswordDetails(){}
	public void empty(){
		email="";
		contact="";
	}
}
