package com.techouts.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techouts.dao.SourceDestinationDAO;
import com.techouts.models.SourceDestination;
import com.techouts.services.SourceDestinationService;

@Service
public class SourceDestinationServiceImpl implements SourceDestinationService{

	@Autowired
	SourceDestinationDAO sourceDestinationDAO;
	public Boolean insertRoute(int userId,SourceDestination sourceDestination) {
		
		return sourceDestinationDAO.insertRoute(userId,sourceDestination);
	}

}
