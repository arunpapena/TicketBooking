package com.techouts.dao;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import com.techouts.models.Users;

public interface RegisterDao {
	JdbcTemplate gettemplate();
	void settemplate(JdbcTemplate template);
	void insert(Users user);
	List<Users> getAllEmployees();
	List<String> getAllEmails();
	List<String> getAllContacts();
}
