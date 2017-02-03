package by.pvt.heldyieu.xml.unmarshaller;

import java.io.File;

import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import org.apache.log4j.Logger;
import by.pvt.heldyieu.generated.MobileProviderType;
import by.pvt.heldyieu.generated.ObjectFactory;
import by.pvt.heldyieu.interfaces.Constants;

public class UnMarshallWithXml implements Constants {
	private static final Logger logger = Logger.getLogger(UnMarshallWithXml.class.getName());
	
	public static void unmarshallWithXML() {
		logger.info("Creating JAXContext instance"); 
	    JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
			logger.info("Use JAXBContext instance to create the Unmarshaller");
		    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		    logger.info("Use the Unmarshaller to unmarshal the XML document to get an instance of JAXBElement.");
			@SuppressWarnings("unchecked")
			JAXBElement<MobileProviderType> unmarshalledObject = (JAXBElement<MobileProviderType>) 
					unmarshaller.unmarshal(new File(XML_FILENAME));
			logger.info("Get the instance of the required JAXB Root Class from the JAXBElement.");
		    unmarshalledObject.getValue().getTariffs().getTariffForCalls()
			.getTariff()
			.forEach(item -> System.out.println(item.toString()));
		    
		    unmarshalledObject.getValue().getTariffs().getTariffForInternet()
			.getTariff()
			.forEach(item -> System.out.println(item.toString()));
		    System.out.println(DELIMITER);
		} catch (JAXBException e) {
			logger.error(e.getMessage());
		}
	}
}
