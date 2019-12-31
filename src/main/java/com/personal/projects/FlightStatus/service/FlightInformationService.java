package com.personal.projects.FlightStatus.service;

import com.personal.projects.FlightStatus.model.Flight;

/**
 * Hello world!
 *
 */
public interface FlightInformationService 
{
    public void addFlight(Flight flight);
    public void deleteFlight(String flightNumber);
    public Flight getFlight(String flightNumber);
    public void updateFlight(Flight flight);
}
