package com.techouts.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.techouts.models.UpdateUser;
import com.techouts.models.User;

public class UserDetailsMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setName(rs.getString(4));
		user.setContact(rs.getString(5));
		user.setEmail(rs.getString(1));
		return user;
	}

}
