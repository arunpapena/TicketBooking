package com.techouts.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import com.techouts.models.SetPassword;


public interface SetPasswordDao {
	void settemplate(JdbcTemplate template);
	void insert(SetPassword setPassword);
}
