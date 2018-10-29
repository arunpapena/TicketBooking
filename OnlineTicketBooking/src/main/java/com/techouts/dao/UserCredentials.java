package com.techouts.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.techouts.techoutstravel.model.User;

public interface UserCredentials {
	
	void setTemplate(JdbcTemplate template);
	boolean isUserRegistered(String email);
	String getPassword(String email);
	boolean isNewUser(String email);
	void updateFlag(String email, String password);
	User getUserDetails(String email);
	void updateUserDetails(String name, String contact, String email);

}
