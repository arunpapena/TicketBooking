package com.techouts.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.techouts.models.User;

public class SqlUserMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setEmail(rs.getString(1));
		user.setPassword(rs.getString(2));
		user.setFlag(rs.getBoolean(3));
		return user;
	}

}
