package com.techouts.dao.impl;


import org.springframework.jdbc.core.JdbcTemplate;
import com.techouts.dao.UserCredentials;
import com.techouts.models.User;
import com.techouts.techoutstravel.rowmapper.SqlFlagMapper;
import com.techouts.techoutstravel.rowmapper.SqlPasswordMapper;
import com.techouts.techoutstravel.rowmapper.SqlUserMapper;
import com.techouts.techoutstravel.rowmapper.UserDetailsMapper;

public class UserCredentialsImpl implements UserCredentials{
	static JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;		
	}
	
	public boolean isUserRegistered(String email) {
		String sql="select * from travel where email = ?";		
		User user = (User)template.queryForObject(sql, new Object[]{email}, new SqlUserMapper());
		return user!=null?  true: false;
			
	}

	public String getPassword(String email) {
		String sql="select password from travel where email = ?";
		System.out.println(email);
		User user = (User)template.queryForObject(sql, new Object[]{email}, new SqlPasswordMapper());
		return user.getPassword();
	}

	public boolean isNewUser(String email) {
		String sql="select flag from travel where email = ?";		
		User user = (User)template.queryForObject(sql, new Object[]{email}, new SqlFlagMapper());
		return user.isFlag();
	}

	public void updateFlag(String password, String email) {
		String sql = "UPDATE travel set flag = ?, password = ?  where email = ?";
		int i = template.update(sql, false, password, email);
		System.out.println(i);
	}

	public User getUserDetails(String email) {
		String sql = "select * from travel where email = ?";
		User user = (User)template.queryForObject(sql, new Object[]{email}, new UserDetailsMapper());
		return user;
	}

	public void updateUserDetails(String name, String contact, String email) {
		String sql = "UPDATE travel set name = ?, contact = ?  where email = ?";
		System.out.println(name+", "+contact+", "+email);
		int i = template.update(sql, name, contact, email);
		System.out.println(i);
		
	}

	

}
