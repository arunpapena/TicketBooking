package com.techouts.techoutstravel.model;

public class User {
	
	private String email;
	private String password;
	private String name;
	private String contact;
	private boolean flag;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	
	
	
	
	
	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", name=" + name + ", contact=" + contact + ", flag="
				+ flag + "]";
	}
	
	
	public User(String email, String password, String name, String contact, boolean flag) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.contact = contact;
		this.flag = flag;
	}
	public User() {
		super();
	}
	
	

}
