package com.personal.projects.FlightStatus.Unit;

import org.junit.Test;

import com.personal.projects.FlightStatus.business.FlightInformationBusinessImpl;
import com.personal.projects.FlightStatus.model.Flight;
import com.personal.projects.FlightStatus.model.Flight.FlightStatus;
import com.personal.projects.FlightStatus.service.FlightInformationService;
import com.personal.projects.FlightStatus.service.FlightInformationServiceImpl;

import junit.framework.TestCase;

public class FlightInformationServiceTest extends TestCase {

	FlightInformationService flightInformationService = new FlightInformationServiceImpl();	
	FlightInformationBusinessImpl flightBusinessImpl = new FlightInformationBusinessImpl(flightInformationService);
	
	@Test
	public void testAddFlight() {
	
		Flight flight = new Flight();
		flight.setFlightNumber("EM0687");
		flight.setDestination("Seattle");
		flight.setDepartedFrom("Portland");
		flight.setStatus(FlightStatus.NOT_STARTED);
		
		flightBusinessImpl.addFlight(flight);
	}
	
	@Test
	public void testGetFlight() {
	
		Flight flight = new Flight();
		flight.setFlightNumber("EM0787");
		flight = flightBusinessImpl.getFlight(flight.getFlightNumber());
		assertEquals("EM0787", flight.getFlightNumber());
		assertEquals("Portland", flight.departedFrom());
		assertEquals("Seattle", flight.destination());
		assertEquals(FlightStatus.NOT_STARTED, flight.getStatus());
	}
	
	
	@Test
	public void testUpdateFlight() {
		Flight flight = new Flight();
		flight.setFlightNumber("EM0787");
		flight.setDestination("Seattle");
		flight.setDepartedFrom("Portland");
		flight.setStatus(FlightStatus.IN_FLIGHT);
		
		flightBusinessImpl.updateFlight(flight);
	}
	
	@Test
	public void testDeleteFlight() {
		String flightNumber = "EM0787";

		flightBusinessImpl.deleteFlight(flightNumber);
	}
	
}
