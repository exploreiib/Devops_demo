package acit.junit.test;

import java.io.IOException;

import org.junit.Test;
import org.xml.sax.SAXException;
// import static org.junit.Assert.assertEquals;
 import org.custommonkey.xmlunit.XMLAssert;
import junit.framework.Assert;
import java.lang.*;
import java.io.*;
import java.lang.String;

public class DevOps_Demo_TestCases {

	String message = readFile("C:\\Maiby\\IIB\\ExpectedOutput\\ExpectedOutput.xml"); 
    String message1 = readFile("C:\\Maiby\\IIB\\ActualResult\\ActualOutput.xml"); 

 @SuppressWarnings("finally")
public String readFile(String fileName)  {
	  BufferedReader br= null;
	    StringBuilder sb = new StringBuilder();
	    try {
	    	br = new BufferedReader(new FileReader(fileName));
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        br.close();
	      
	    } 
	    catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    finally {	     
	        return sb.toString();
	    }
	}

  @Test
  public void testPrintMessage() {	  
    
	   try {
		  
		XMLAssert.assertXMLEqual(message,message1);
	} catch (SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

  }
  
}
