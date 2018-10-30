package com.techouts.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public interface DefaultPasswordInsert {
	void settemplate(JdbcTemplate template);
	void insert(String email,StringBuilder defaultpswd);
}
