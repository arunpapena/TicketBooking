package com.techouts.dao;

import com.techouts.models.SourceDestination;

public interface SourceDestinationDAO {

	public Boolean insertRoute(int userId,SourceDestination sourceDestination);
}
