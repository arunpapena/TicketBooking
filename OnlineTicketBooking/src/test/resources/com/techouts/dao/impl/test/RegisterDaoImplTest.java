package com.techouts.dao.impl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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
import com.techouts.dao.RegisterDao;
import com.techouts.dao.impl.RegisterDaoImpl;
import com.techouts.models.Users;


public class RegisterDaoImplTest {
	@Mock JdbcTemplate template;
	@InjectMocks RegisterDao registerDao;
	@Before
	public void doSetUp(){
		template=Mockito.mock(JdbcTemplate.class);
		registerDao=new  RegisterDaoImpl();
	}
	@Test
	public void getAllEmployeeTest(){
		
		final List<Users> list=new ArrayList<Users>();
		list.add(new Users("pqrs","xyz@gmail.com","1234567890"));
		String query="select * from techoutstravel";
		ResultSetExtractor<List<Users>> resultSetExtractor=new ResultSetExtractor<List<Users>>() {
			public List<Users> extractData(ResultSet rs) throws SQLException, DataAccessException {
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
