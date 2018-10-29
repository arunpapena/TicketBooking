package com.techouts.ticketbooking.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techouts.ticketbooking.dao.BusInfoDAO;
import com.techouts.ticketbooking.models.BusInfo;
import com.techouts.ticketbooking.services.BusInfoService;

@Service
public class BusInfoServiceImpl implements BusInfoService{

	@Autowired
	BusInfoDAO busInfoDAO;
	public List<BusInfo> getAllBusInfo(String sourceStn,String destinationStn) {
		return busInfoDAO.getAllBusInfo(sourceStn, destinationStn);
	}
	public List<BusInfo> getSelectedBusInfo(int busInfo) {
		return busInfoDAO.getSelectedBusInfo(busInfo);
	}

}
