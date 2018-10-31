package com.techouts.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.techouts.dao.SourceDestinationDAO;
import com.techouts.models.SourceDestination;

@Repository
public class SourceDestinationDAOImpl implements SourceDestinationDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public Boolean insertRoute(final int userId, final SourceDestination sourceDestination) {
		String query = "insert into sourcedestination values(?,?,?,?)";
		 return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){  
			    public Boolean doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException {
							
			    		ps.setInt(1, userId);
			    		ps.setString(2, sourceDestination.getFromAddress());
			    		ps.setString(3, sourceDestination.getToAddress());
			    		ps.setString(4, sourceDestination.getDate());
			    	return ps.execute();  
			              
			    }  
			    });  
	}
}
