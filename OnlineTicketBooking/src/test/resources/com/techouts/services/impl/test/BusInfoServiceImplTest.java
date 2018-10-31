package com.techouts.services.impl.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import com.techouts.dao.BusInfoDAO;
import com.techouts.models.BusInfo;
import com.techouts.services.BusInfoService;
import com.techouts.services.impl.BusInfoServiceImpl;

public class BusInfoServiceImplTest {
	
	@Mock
	BusInfoDAO busInfoDAO;
	@Mock
	BusInfo busInfo;
	@InjectMocks
	BusInfoService busInfoService;
	@Before
    public void doSetup() {
		busInfo=new BusInfo();
		busInfoDAO=Mockito.mock(BusInfoDAO.class);
		busInfoService=new BusInfoServiceImpl();
    }
	@Test
	public void getAllBusInfoTest()
	{
		List<BusInfo> list=new ArrayList<BusInfo>();
		busInfo.setBusNo(12345);
		busInfo.setBusName("AtluriTravels");
		busInfo.setSourceStn("Vijayawada");
		busInfo.setArrivalTime("08:00:00");
		busInfo.setDestinationStn("Secunderabad");
		busInfo.setDepartureTime("12:00:00");
		busInfo.setPrice(1200);
		list.add(busInfo);
		Mockito.when(busInfoDAO.getAllBusInfo("vijayawada", "Secunderabad")).thenReturn(list);
		Mockito.when(busInfoDAO.getAllBusInfo("vijayawada", "Delhi")).thenReturn(null);
		assertEquals(list, busInfoDAO.getAllBusInfo("vijayawada", "Secunderabad"));
		assertNotNull(busInfoDAO.getAllBusInfo("vijayawada", "Secunderabad"));
		assertNull(busInfoDAO.getAllBusInfo("vijayawada", "Delhi"));
		
	}
	
	@Test
	public void getSelectedBusInfoTest()
	{
		List<BusInfo> list=new ArrayList<BusInfo>();
		busInfo.setBusNo(12355);
		busInfo.setBusName("AtluriTravels");
		busInfo.setSourceStn("Mumbai");
		busInfo.setArrivalTime("08:00:00");
		busInfo.setDestinationStn("Delhi");
		busInfo.setDepartureTime("17:00:00");
		busInfo.setPrice(1500);
		list.add(busInfo);
		Mockito.when(busInfoDAO.getSelectedBusInfo(12355)).thenReturn(list);
		Mockito.when(busInfoDAO.getSelectedBusInfo(12356)).thenReturn(null);
		assertEquals(list, busInfoDAO.getSelectedBusInfo(12355));
		assertNotNull(busInfoDAO.getSelectedBusInfo(12355));
		assertNull(busInfoDAO.getSelectedBusInfo(12356));
	}
}
