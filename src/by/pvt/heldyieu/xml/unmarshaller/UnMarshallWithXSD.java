package by.pvt.heldyieu.xml.unmarshaller;
import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import by.pvt.heldyieu.generated.MobileProviderType;
import by.pvt.heldyieu.generated.ObjectFactory;
import by.pvt.heldyieu.interfaces.Constants;

public class UnMarshallWithXSD implements Constants {
	private static final Logger logger = Logger
			.getLogger(UnMarshallWithXSD.class.getName());

	public static void unmarshallWithXSD() {
		JAXBContext jc = null;
		try {
			jc = JAXBContext.newInstance(ObjectFactory.class);
			Unmarshaller um = jc.createUnmarshaller();
			String schemaName = XSD_FILNAME;
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			File schemaLocation = new File(schemaName);
			Schema schema = factory.newSchema(schemaLocation);
			um.setSchema(schema);
			@SuppressWarnings("unchecked")
			JAXBElement<MobileProviderType> unmarshalledObject = 
			(JAXBElement<MobileProviderType>) um.unmarshal(new File(XML_FILENAME));
			unmarshalledObject.getValue().getTariffs().getTariffForCalls()
					.getTariff()
					.forEach(item -> System.out.println(item.toString()));
			unmarshalledObject.getValue().getTariffs().getTariffForInternet()
					.getTariff()
					.forEach(item -> System.out.println(item.toString()));
			System.out.println(DELIMITER);
		} catch (JAXBException e) {
			logger.error(e.getMessage());
		} catch (SAXException e) {
			logger.error(e.getMessage());
		}
	}
}
