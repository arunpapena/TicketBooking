package com.techouts.techoutstravel.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class User {
	
	@NotEmpty
	@NotNull
	private String name;
	@NotEmpty
	@NotNull
	@Email
	private String email;
	@NotEmpty
	@NotNull
	private String contact;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public User() {}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", contact=" + contact + "]";
	}
	public User(String name, String email, String contact) {
		super();
		this.name = name;
		this.email = email;
		this.contact = contact;
	}
	public void empty(){
		name="";
		email="";
		contact="";
	}
}
