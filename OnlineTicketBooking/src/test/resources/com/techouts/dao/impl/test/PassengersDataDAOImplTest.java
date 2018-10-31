package com.techouts.dao.impl.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import com.techouts.dao.PassengersDataDAO;
import com.techouts.dao.impl.PassengersDataDAOImpl;

public class PassengersDataDAOImplTest {
	
	@Mock
	JdbcTemplate jdbcTemplate;
	@InjectMocks
	PassengersDataDAO passengersDataDAO;
	@Before
    public void doSetup() {
		jdbcTemplate=Mockito.mock(JdbcTemplate.class);
		passengersDataDAO=new PassengersDataDAOImpl();
    }
	@Test
	public void insertPassengerTest(){
		
		String query="insert into passenger values(?,?,?)";
		PreparedStatementCallback<Boolean> preparedStatement=new PreparedStatementCallback<Boolean>() {
			
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				ps.setInt(1, 12345);	
	    		ps.setString(2,"suri");
	    		ps.setInt(3, 21);
	    	return ps.execute();  
			}
		};
		PreparedStatementCallback<Boolean> preparedStatement1=new PreparedStatementCallback<Boolean>() {
			
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				ps.setInt(1, 12344);	
	    		ps.setString(2,"nari");
	    		ps.setInt(3, 21);
	    	return ps.execute();  
			}
		};
		Mockito.when(jdbcTemplate.execute(query,preparedStatement)).thenReturn(true);
		Mockito.when(jdbcTemplate.execute(query,preparedStatement1)).thenReturn(false);
		assertTrue( jdbcTemplate.execute(query,preparedStatement));
		assertFalse(jdbcTemplate.execute(query,preparedStatement1));
		assertNotNull(jdbcTemplate.execute(query,preparedStatement));
	}
}
