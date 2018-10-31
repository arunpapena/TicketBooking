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

import com.techouts.dao.BusInfoDAO;
import com.techouts.dao.impl.BusInfoDAOImpl;
import com.techouts.models.BusInfo;

public class BusInfoDAOImplTest {
	
	@Mock
	JdbcTemplate jdbcTemplate;
	@InjectMocks
	BusInfoDAO busInfoDAO;
	@Before
	 public void doSetup() {
		jdbcTemplate=Mockito.mock(JdbcTemplate.class);
		busInfoDAO=new BusInfoDAOImpl();
   }
	@Test
	public void getAllBusInfoTest(){
		String sourceStn="vijayawada";
		String destinationStn="Secunderabad";
		String fetchQuery="select * from businfo where SOURCESTN='"+sourceStn+"' and DESTINATIONSTN='"+destinationStn+"'";
		final List<BusInfo> list = new ArrayList<BusInfo>();
			BusInfo busInfo = new BusInfo();
			busInfo.setBusNo(12345);
			busInfo.setBusName("AtluriTravels");
			busInfo.setSourceStn("Vijayawada");
			busInfo.setArrivalTime("08:00:00");
			busInfo.setDestinationStn("Secunderabad");
			busInfo.setDepartureTime("12:00:00");
			busInfo.setPrice(1200);
			list.add(busInfo);
		ResultSetExtractor<List<BusInfo>> resultSetExtractor=new ResultSetExtractor<List<BusInfo>>() {

			public List<BusInfo> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				return list;
			}
		};
		ResultSetExtractor<List<BusInfo>> resultSetExtractor1=new ResultSetExtractor<List<BusInfo>>() {

			public List<BusInfo> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				return null;
			}
		};
		Mockito.when(jdbcTemplate.query(fetchQuery,resultSetExtractor)).thenReturn(list);
		Mockito.when(jdbcTemplate.query(fetchQuery,resultSetExtractor1)).thenReturn(null);
		assertNotNull(jdbcTemplate.query(fetchQuery,resultSetExtractor));
		assertEquals(list, jdbcTemplate.query(fetchQuery,resultSetExtractor));
		assertNull(jdbcTemplate.query(fetchQuery,resultSetExtractor1));
	}
	@Test
	public void getSelectedBusInfo(){
		
		int busNo=12345;
		String fetchQuery="select * from businfo where BUSNO="+busNo;
		final List<BusInfo> list = new ArrayList<BusInfo>();
		BusInfo busInfo = new BusInfo();
		busInfo.setBusNo(12345);
		busInfo.setBusName("AtluriTravels");
		busInfo.setSourceStn("Vijayawada");
		busInfo.setArrivalTime("08:00:00");
		busInfo.setDestinationStn("Secunderabad");
		busInfo.setDepartureTime("12:00:00");
		busInfo.setPrice(1200);
		list.add(busInfo);
		
		ResultSetExtractor<List<BusInfo>> resultSetExtractor=new ResultSetExtractor<List<BusInfo>>() {

			public List<BusInfo> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				return list;
			}
		};
		
		ResultSetExtractor<List<BusInfo>> resultSetExtractor1=new ResultSetExtractor<List<BusInfo>>() {

			public List<BusInfo> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		Mockito.when(jdbcTemplate.query(fetchQuery,resultSetExtractor)).thenReturn(list);
		Mockito.when(jdbcTemplate.query(fetchQuery,resultSetExtractor1)).thenReturn(null);
		assertNotNull(jdbcTemplate.query(fetchQuery,resultSetExtractor));
		assertEquals(list, jdbcTemplate.query(fetchQuery,resultSetExtractor));
		assertNull(jdbcTemplate.query(fetchQuery,resultSetExtractor1));
	}
}
