package com.techouts.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techouts.ticketbooking.dao.SourceDestinationDAO;
import com.techouts.ticketbooking.models.SourceDestination;
import com.techouts.ticketbooking.services.SourceDestinationService;

@Service
public class SourceDestinationServiceImpl implements SourceDestinationService{

	@Autowired
	SourceDestinationDAO sourceDestinationDAO;
	public Boolean insertRoute(int userId,SourceDestination sourceDestination) {
		
		return sourceDestinationDAO.insertRoute(userId,sourceDestination);
	}

}
