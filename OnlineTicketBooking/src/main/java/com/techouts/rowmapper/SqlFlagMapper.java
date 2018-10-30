package com.techouts.techoutstravel.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.techouts.techoutstravel.model.User;

public class SqlFlagMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setFlag(rs.getBoolean(1));
		return user;
	}
}
