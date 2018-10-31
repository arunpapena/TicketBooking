package com.techouts.services.impl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import com.techouts.dao.SourceDestinationDAO;
import com.techouts.models.SourceDestination;
import com.techouts.services.SourceDestinationService;
import com.techouts.services.impl.SourceDestinationServiceImpl;

public class SourceDestinationServiceImplTest {

	@Mock
	SourceDestinationDAO sourceDestinationDAO;
	@InjectMocks
	SourceDestinationService sourceDestinationService;
	@Before
    public void doSetup() {
		sourceDestinationDAO=Mockito.mock(SourceDestinationDAO.class);
		sourceDestinationService=new SourceDestinationServiceImpl();
    }
	
	@Test
	public void  insertRouteTest(){
	  
		SourceDestination sourceDestination=new SourceDestination();
		sourceDestination.setFromAddress("Vijayawada");
		sourceDestination.setToAddress("Secunderabad");
		sourceDestination.setDate("10/30/2018");
		Mockito.when(sourceDestinationDAO.insertRoute(12345,sourceDestination)).thenReturn(true);
		SourceDestination sourceDestination1=new SourceDestination();
		sourceDestination1.setFromAddress("Delhi");
		sourceDestination1.setToAddress("Vijayawada");
		sourceDestination1.setDate("10/30/2018");
		Mockito.when(sourceDestinationDAO.insertRoute(12345,sourceDestination1)).thenReturn(false);
		assertEquals(true, sourceDestinationDAO.insertRoute(12345,sourceDestination));
		assertEquals(false, sourceDestinationDAO.insertRoute(12345,sourceDestination1));
		assertNotNull(sourceDestinationDAO.insertRoute(12345,sourceDestination));
	}
}
