package com.techouts.dao.impl.test;

import static org.junit.Assert.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import com.techouts.dao.ForgotPassword;
import com.techouts.dao.impl.ForgotPasswordImplimentation;
import com.techouts.models.ForgotPasswordDetails;


public class ForgotPasswordImplimentationTest {
@Mock JdbcTemplate template;
@InjectMocks
ForgotPassword forgotPassword;
@Before
public void doSetUp(){
	template=Mockito.mock(JdbcTemplate.class);
	forgotPassword=new ForgotPasswordImplimentation();
}

@Test
public void getAllEmployeeTest(){
	final List<ForgotPasswordDetails> list=new ArrayList<ForgotPasswordDetails>();
	list.add(new ForgotPasswordDetails("xyz@gmail.com","1234567890"));
	String query="select * from forgotpassword";
	ResultSetExtractor<List<ForgotPasswordDetails>> resultSetExtractor=new ResultSetExtractor<List<ForgotPasswordDetails>>() {
		public List<ForgotPasswordDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {
			return list;
		}
	};
	Mockito.when(template.query(query,resultSetExtractor)).thenReturn(list);
	assertNotNull(template.query(query,resultSetExtractor));
	assertEquals(list, template.query(query,resultSetExtractor));
	Mockito.when(template.query(query,resultSetExtractor)).thenReturn(null);
	assertNull(template.query(query,resultSetExtractor));
	assertEquals(null, template.query(query,resultSetExtractor));
} 


}
