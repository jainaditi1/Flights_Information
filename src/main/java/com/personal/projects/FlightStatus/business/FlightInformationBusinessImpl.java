package com.personal.projects.FlightStatus.business;

import com.personal.projects.FlightStatus.model.Flight;
import com.personal.projects.FlightStatus.service.FlightInformationService;

/**
 * Hello world!
 *
 */
public class FlightInformationBusinessImpl 
{
	FlightInformationService flightInformationService;
	
    public FlightInformationBusinessImpl(FlightInformationService flightInformationService) {
		this.flightInformationService = flightInformationService;
	}

	public void addFlight( Flight flight )
    {
		flightInformationService.addFlight(flight);
    }
    
    public Flight getFlight( String flightNumber )
    {
    	return flightInformationService.getFlight(flightNumber);
    }
    
    public void updateFlight( Flight flight )
    {
        flightInformationService.updateFlight(flight);
    }
    
    public void deleteFlight( String flightNumber )
    {
    	flightInformationService.deleteFlight(flightNumber);
    }
}
