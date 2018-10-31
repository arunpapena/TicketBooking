package com.techouts.techoutstravel.mail;

import org.springframework.jdbc.core.JdbcTemplate;
import com.techouts.dao.DefaultPasswordInsert;

public class DefaultPasswordInsertImpl implements DefaultPasswordInsert{

	static JdbcTemplate template;
	public void settemplate(JdbcTemplate template) {
		DefaultPasswordInsertImpl.template = template;
	}

	public void insert(String email, StringBuilder defaultpswd) {
		template.update("insert into defaultpassword(emai, defaultpswd) values (?,?)", email, defaultpswd);
	}
}
