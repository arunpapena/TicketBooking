package com.techouts.services;

import com.techouts.ticketbooking.models.SourceDestination;

public interface SourceDestinationService {

	public Boolean insertRoute(int userId,SourceDestination sourceDestination);
}
