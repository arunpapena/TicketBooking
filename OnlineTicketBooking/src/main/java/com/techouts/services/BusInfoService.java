package com.techouts.ticketbooking.services;

import java.util.List;

import com.techouts.ticketbooking.models.BusInfo;

public interface BusInfoService {

	public List<BusInfo> getAllBusInfo(String sourceStn,String destinationStn);
	public List<BusInfo> getSelectedBusInfo(int busNo);
}
