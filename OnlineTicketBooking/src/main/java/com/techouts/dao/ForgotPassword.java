package com.techouts.dao;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import com.techouts.models.ForgotPasswordDetails;

public interface ForgotPassword {
	JdbcTemplate gettemplate();
	void settemplate(JdbcTemplate template);
	void insert(ForgotPasswordDetails forgotPasswordDetails);
	List<ForgotPasswordDetails> getAllEmployees();
	List<String> getAllEmails();
	List<String> getAllContacts();
}
