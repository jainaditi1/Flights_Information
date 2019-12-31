package com.personal.projects.FlightStatus.datasource;

import java.io.IOException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.personal.projects.FlightStatus.model.Flight;
import com.personal.projects.FlightStatus.model.Flight.FlightStatus;

/**
 * Hello world!
 *
 */
public class FlightInformationDatasource extends Datasource {

	public FlightInformationDatasource() {
		super();
	}

	public void addFlight(Flight flight) {

		if (rootElement == null) {
			rootElement = document.createElementNS("https://www.aditi.com/flightsInformationServices", "Flights");
			document.appendChild(rootElement);
		}
		if (!doesFlightExists(flight.getFlightNumber())) {
			Element flightElement = document.createElement("Flight");
			flightElement.setAttribute("flightNumber", "" + flight.getFlightNumber());

			Element departedElement = document.createElement("departedFrom");
			departedElement.appendChild(document.createTextNode(flight.departedFrom()));

			Element destinationElement = document.createElement("destination");
			destinationElement.appendChild(document.createTextNode(flight.destination()));

			Element statusElement = document.createElement("status");
			statusElement.appendChild(document.createTextNode(flight.getStatus().toString()));

			flightElement.appendChild(departedElement);
			flightElement.appendChild(destinationElement);
			flightElement.appendChild(statusElement);

			rootElement.appendChild(flightElement);

			saveData();
		} else {
			System.out.println("Flight already exists!");
		}

	}

	private boolean doesFlightExists(String flightNumber) {
		NodeList nodes = document.getElementsByTagName("Flight");

		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;

				String flightNumberValue = element.getAttribute("flightNumber");
				if (flightNumberValue.equalsIgnoreCase(flightNumber)) {
					return true;
				}
			}
		}
		return false;
	}

	public Flight getFlight(String flightNumber) {
		Flight flight = new Flight();
		try {
			document = builder.parse(file);
			NodeList nodes = document.getElementsByTagName("Flight");

			for (int i = 0; i < nodes.getLength(); i++) {
				Node node = nodes.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;

					String flightNumberValue = element.getAttribute("flightNumber");
					if (flightNumberValue.equalsIgnoreCase(flightNumber)) {
						String departedFromValue = element.getElementsByTagName("departedFrom").item(0)
								.getTextContent();
						String destinationValue = element.getElementsByTagName("destination").item(0).getTextContent();
						String statusValue = element.getElementsByTagName("status").item(0).getTextContent();

						flight.setDepartedFrom(departedFromValue);
						flight.setDestination(destinationValue);
						flight.setStatus(FlightStatus.valueOf(statusValue));
						flight.setFlightNumber(flightNumberValue);

					}
				}
			}

		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}
		return flight;
	}

	public void updateFlight(Flight flight) {
		try {
			document = builder.parse(file);
			NodeList nodes = document.getElementsByTagName("Flight");

			for (int i = 0; i < nodes.getLength(); i++) {
				Node node = nodes.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;

					String flightNumberValue = element.getAttribute("flightNumber");
					if (flightNumberValue.equalsIgnoreCase(flight.getFlightNumber())) {
						element.getElementsByTagName("departedFrom").item(0).setTextContent(flight.departedFrom());
						element.getElementsByTagName("destination").item(0).setTextContent(flight.destination());
						element.getElementsByTagName("status").item(0).setTextContent(flight.getStatus().toString());

						saveData();
					}
				}
			}

		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}
	}

	public void deleteFlight(String flightNumber) {
		try {
			document = builder.parse(file);
			NodeList nodes = document.getElementsByTagName("Flight");

			for (int i = 0; i < nodes.getLength(); i++) {
				Node node = nodes.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;

					String flightNumberValue = element.getAttribute("flightNumber");
					if (flightNumberValue.equalsIgnoreCase(flightNumber)) {

						// retrieve the element 'link'
						element = (Element) document.getElementsByTagName("Flight").item(0);

						// remove the specific node
						element.getParentNode().removeChild(element);

						saveData();
					}
				}
			}

		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}
	}
}
