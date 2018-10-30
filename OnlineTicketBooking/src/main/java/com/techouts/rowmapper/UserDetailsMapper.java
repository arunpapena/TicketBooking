package com.techouts.techoutstravel.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.techouts.techoutstravel.model.UpdateUser;
import com.techouts.techoutstravel.model.User;

public class UserDetailsMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setName(rs.getString(4));
		user.setContact(rs.getString(5));
		user.setEmail(rs.getString(1));
		return user;
	}

}
