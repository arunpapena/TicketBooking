package com.techouts.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techouts.dao.PassengersDataDAO;
import com.techouts.services.PassengersDataService;

@Service
public class PassengersDataServiceImpl implements PassengersDataService{

	@Autowired
	PassengersDataDAO passengersDataDAO;
	public Boolean insertPassenger(int userId,String name, int age) {
		
		return passengersDataDAO.insertPassenger(userId,name, age);
	}
		
}
