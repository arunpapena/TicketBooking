package com.techouts.ticketbooking.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.techouts.ticketbooking.dao.PassengersDataDAO;

@Repository
public class PassengersDataDAOImpl implements PassengersDataDAO{

	@Autowired
	JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public Boolean insertPassenger(final int userId,final String name, final int age) {
		String query = "insert into passenger values(?,?,?)";
		 return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){  
			    public Boolean doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException {
						ps.setInt(1, userId);	
			    		ps.setString(2, name);
			    		ps.setInt(3, age);
			    	
			    	return ps.execute();  
			              
			    }  
			    });  
	}

}
