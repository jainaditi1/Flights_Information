package com.personal.projects.FlightStatus.model;

/**
 * Hello world!
 *
 */
public class Flight 
{
    private String flightNumber;
    private String departedFrom;
    private String destination;
    private FlightStatus status = FlightStatus.NOT_STARTED;
    
    
    public enum FlightStatus {
    	CANCELED, LANDED, IN_FLIGHT, NOT_STARTED
    }
    
    
    public String getFlightNumber() {
		return flightNumber;
	}


	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}


	public String departedFrom() {
		return departedFrom;
	}


	public void setDepartedFrom(String departedFrom) {
		this.departedFrom = departedFrom;
	}


	public String destination() {
		return destination;
	}


	public void setDestination(String toDestination) {
		this.destination = toDestination;
	}


	public FlightStatus getStatus() {
		return status;
	}


	public void setStatus(FlightStatus status) {
		this.status = status;
	}


}
