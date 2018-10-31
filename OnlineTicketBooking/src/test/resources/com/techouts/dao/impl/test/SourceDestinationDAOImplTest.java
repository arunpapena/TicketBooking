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

import com.techouts.dao.SourceDestinationDAO;
import com.techouts.dao.impl.SourceDestinationDAOImpl;

public class SourceDestinationDAOImplTest {

	@Mock
	JdbcTemplate jdbcTemplate;
	@InjectMocks
	SourceDestinationDAO sourceDestinationDAO;
	@Before
	 public void doSetup() {
		jdbcTemplate=Mockito.mock(JdbcTemplate.class);
		sourceDestinationDAO=new SourceDestinationDAOImpl();
    }
	
	@Test
	public void insertRouteTest(){
		String query = "insert into sourcedestination values(?,?,?,?)";
		PreparedStatementCallback<Boolean> preparedStatement=new PreparedStatementCallback<Boolean>() {
			
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				ps.setInt(1, 12345);
	    		ps.setString(2, "vijayawada");
	    		ps.setString(3, "Secunderabad");
	    		ps.setString(4, "10/30/2018");
	    	return ps.execute(); 
			}
		};
		PreparedStatementCallback<Boolean> preparedStatement1=new PreparedStatementCallback<Boolean>() {
			
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				ps.setInt(1, 12345);
	    		ps.setString(2, "vijayawada");
	    		ps.setString(3, "Delhi");
	    		ps.setString(4, "10/30/2018");
	    		return ps.execute(); 
			}
		};
		Mockito.when(jdbcTemplate.execute(query,preparedStatement)).thenReturn(true);
		Mockito.when(jdbcTemplate.execute(query,preparedStatement1)).thenReturn(false);
		assertTrue(jdbcTemplate.execute(query,preparedStatement));
		assertFalse(jdbcTemplate.execute(query,preparedStatement1));
		assertNotNull(jdbcTemplate.execute(query,preparedStatement));
	}
}
