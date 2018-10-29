package com.techouts.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.techouts.techoutstravel.dao.SetPasswordDao;
import com.techouts.techoutstravel.model.SetPassword;

@Repository
public class SetPasswordDaoImplimentation implements SetPasswordDao{
		static JdbcTemplate template; 
		public void settemplate(JdbcTemplate template) {
			SetPasswordDaoImplimentation.template = template;
		}
	public void insert(SetPassword setPassword) {		
template.update("insert into setpassword(email, contact, password, confirmpassword) values (?,?,?,?)",
setPassword.getEmail().toLowerCase(), setPassword.getContact().toLowerCase(), 
setPassword.getPassword().toLowerCase(), setPassword.getConfirmpassword().toLowerCase());
		}

}
