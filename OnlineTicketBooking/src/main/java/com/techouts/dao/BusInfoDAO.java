package com.techouts.dao;

import java.util.List;

import com.techouts.models.BusInfo;

public interface BusInfoDAO {

	public List<BusInfo> getAllBusInfo(String sourceStn,String destinationStn);
	public List<BusInfo> getSelectedBusInfo(int busInfo);
}
