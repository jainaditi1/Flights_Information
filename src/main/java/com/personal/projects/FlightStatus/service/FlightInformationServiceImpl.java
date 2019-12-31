package com.personal.projects.FlightStatus.service;

import com.personal.projects.FlightStatus.datasource.FlightInformationDatasource;
import com.personal.projects.FlightStatus.model.Flight;
import com.personal.projects.FlightStatus.service.FlightInformationService;

public class FlightInformationServiceImpl implements FlightInformationService {

	FlightInformationDatasource datasource = new FlightInformationDatasource();
	
	@Override
	public void addFlight(Flight flight) {
		datasource.addFlight(flight);
	}

	@Override
	public void deleteFlight(String flightNumber) {
		datasource.deleteFlight(flightNumber);
		
	}

	@Override
	public Flight getFlight(String flightNumber) {
		Flight flight = datasource.getFlight(flightNumber);
		return flight;
	}

	@Override
	public void updateFlight(Flight flight) {
		datasource.updateFlight(flight);
	}

}
