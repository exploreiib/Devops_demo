package acit.junit.helper;

import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPMessage;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import acit.junit.test.DevOps_Demo_TestCases;

public class TestRunner {
	public static void main(String[] args) {

		try {

			// Create SOAP Connection
			SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory
					.newInstance();
			SOAPConnection soapConnection = soapConnectionFactory
					.createConnection();

			// Send SOAP Message to SOAP Server
			String url = "http://localhost:7800/SayHello/";
			SOAPMessage soapResponse = soapConnection.call(DevOps_Demo_Helper.createSOAPRequest(), url);

			// Process the SOAP Response
			DevOps_Demo_Helper.printSOAPResponse(soapResponse);

			soapConnection.close();

		} catch (Exception e) {
			System.err
					.println("Error occurred while sending SOAP Request to Server");
			e.printStackTrace();
		}

		Result result = JUnitCore.runClasses(DevOps_Demo_TestCases.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println(result.wasSuccessful());
	}
}