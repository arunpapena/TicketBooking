package com.techouts.techoutstravel.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.techouts.techoutstravel.model.User;

public class SqlPasswordMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setPassword(rs.getString(1));
		return user;
	}

}
