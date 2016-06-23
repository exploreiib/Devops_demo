package acit.junit.helper;

import java.io.File;

import javax.xml.soap.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

public class DevOps_Demo_Helper {
	
	 public static SOAPMessage createSOAPRequest() throws Exception {
	        MessageFactory messageFactory = MessageFactory.newInstance();
	        SOAPMessage soapMessage = messageFactory.createMessage();
	        SOAPPart soapPart = soapMessage.getSOAPPart();

	        String serverURI = "urn:examples:helloservice";

	        // SOAP Envelope
	        SOAPEnvelope envelope = soapPart.getEnvelope();
	        envelope.addNamespaceDeclaration("urn", serverURI);

	        // SOAP Body
	        SOAPBody soapBody = envelope.getBody();
	        SOAPElement soapBodyElem = soapBody.addChildElement("sayHello", "urn");
	        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("firstName");
	        soapBodyElem1.addTextNode("Guest");

	        MimeHeaders headers = soapMessage.getMimeHeaders();
	        headers.addHeader("SOAPAction", "sayHello");

	        soapMessage.saveChanges();

	        /* Print the request message */
	        System.out.print("Request SOAP Message = ");
	        soapMessage.writeTo(System.out);
	        
	        System.out.println();

	        return soapMessage;
	    }

	    /**
	     * Method used to print the SOAP Response
	     */
	    public static void printSOAPResponse(SOAPMessage soapResponse) throws Exception {
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        Source sourceContent = soapResponse.getSOAPPart().getContent();
	       // System.out.print("\nResponse SOAP Message = ");
	       // StreamResult result = new StreamResult(System.out);
	        StreamResult result = new StreamResult(new File("C:\\Maiby\\IIB\\ActualResult\\ActualOutput.xml"));
	        transformer.transform(sourceContent, result);
	    }


}
