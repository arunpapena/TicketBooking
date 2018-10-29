package com.techouts.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.techouts.techoutstravel.model.User;

public interface RegisterDao {
	JdbcTemplate gettemplate();
	void settemplate(JdbcTemplate template);
	void insert(User user);
	List<User> getAllEmployees();
	List<String> getAllEmails();
	List<String> getAllContacts();
}
