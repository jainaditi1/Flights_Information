package com.personal.projects.FlightStatus.Mocks;


import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.personal.projects.FlightStatus.business.FlightInformationBusinessImpl;
import com.personal.projects.FlightStatus.model.Flight;
import com.personal.projects.FlightStatus.service.FlightInformationService;

/**
 * Unit test for simple App.
 */
public class FlightInformationBusinessMockTest 
    
{
	
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FlightInformationBusinessMockTest()
    {
    	
    }


    @org.junit.Test
    public void addFlight()
    {
    	FlightInformationService flightInformationService = mock(FlightInformationService.class);
    	FlightInformationBusinessImpl flightServiceBusinessImpl = new FlightInformationBusinessImpl(flightInformationService);
    	Flight flight =  new Flight();
    	flightServiceBusinessImpl.addFlight(flight);
    	
    	//WHEN THE METHOD RETURNS ***VOID***
    	doNothing().when(flightInformationService).addFlight(flight);
    	verify(flightInformationService, times(1)).addFlight(flight);
    }
    
}
