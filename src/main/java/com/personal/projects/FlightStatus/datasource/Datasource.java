package com.personal.projects.FlightStatus.datasource;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.personal.projects.FlightStatus.utility.Constants;

public class Datasource {
	Document document;
	DocumentBuilder builder;
	File file;
	private Logger logger = Logger.getLogger(FlightInformationDatasource.class.getName());
	Element rootElement;
	
	public Datasource(){
		setUp();
	} 
	
	private void setUp() {
		documentBuilderSetup();
		datasourceFileSetup();
	}
	
	private void documentBuilderSetup() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			builder = factory.newDocumentBuilder();
			document = builder.newDocument();
		} catch (ParserConfigurationException e) {
			logger.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void datasourceFileSetup() {
		file = new File(Constants.FLIGHT_INFORMATION_XML_PATH);
		if (!file.exists() || !file.canRead() ) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				logger.log(Level.SEVERE, e.getMessage());
				e.printStackTrace();
			}
		} else {
			try {
				document = builder.parse(file);
			} catch (SAXException | IOException e) {
				e.printStackTrace();

			}
			rootElement = document.getDocumentElement();
		}
	}
	
	protected void saveData() {
    	TransformerFactory transformerFactory = TransformerFactory.newInstance();
    	try {
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(document);
			StreamResult console = new StreamResult(System.out);
			StreamResult writeToFile = new StreamResult(file);
			try {
				transformer.transform(source, console);
				transformer.transform(source, writeToFile);
				System.out.println("Finished saving data...");
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
