package com.techouts.dao;

import com.techouts.ticketbooking.models.SourceDestination;

public interface SourceDestinationDAO {

	public Boolean insertRoute(int userId,SourceDestination sourceDestination);
}
