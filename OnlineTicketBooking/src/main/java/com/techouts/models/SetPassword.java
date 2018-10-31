package com.techouts.models;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class SetPassword {
	@NotEmpty
	@NotNull
	private String password;
	@NotEmpty
	@NotNull
	private String confirmpassword;
	@NotEmpty
	@NotNull
	@Email
	private String email;
	@NotEmpty
	@NotNull
	private String contact;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

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

	public SetPassword() {}

	public SetPassword(String password, String confirmpassword, String email, String contact) {
		super();
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.email = email;
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "SetPassword [password=" + password + ", confirmpassword=" + confirmpassword + ", email=" + email
				+ ", contact=" + contact + "]";
	}

	


	public void empty(){
		password="";
		confirmpassword="";
	}
}
