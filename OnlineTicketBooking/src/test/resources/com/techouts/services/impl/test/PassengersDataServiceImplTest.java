package com.techouts.services.impl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.techouts.dao.PassengersDataDAO;
import com.techouts.services.PassengersDataService;
import com.techouts.services.impl.PassengersDataServiceImpl;

public class PassengersDataServiceImplTest {

	@Mock
	PassengersDataDAO passengersDataDAO;
	@InjectMocks
	private PassengersDataService passengersDataService;
	@Before
    public void doSetup() {
		passengersDataDAO=Mockito.mock(PassengersDataDAO.class);
		passengersDataService=new PassengersDataServiceImpl();
    }
	
	@Test
	public void  insertPassengerTest(){
		Mockito.when(passengersDataDAO.insertPassenger(12345, "suri", 21)).thenReturn(true);
		Mockito.when(passengersDataDAO.insertPassenger(12346, "nari", 22)).thenReturn(false);
		assertNotNull(passengersDataDAO.insertPassenger(12345, "suri", 21));
		assertEquals(true,passengersDataDAO.insertPassenger(12345, "suri", 21));
		assertEquals(false, passengersDataDAO.insertPassenger(12346, "nari", 22));
	}
}
