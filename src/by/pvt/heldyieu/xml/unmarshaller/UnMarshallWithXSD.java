package by.pvt.heldyieu.xml.unmarshaller;
import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import by.pvt.heldyieu.generated.MobileProviderType;
import by.pvt.heldyieu.generated.ObjectFactory;

public class UnMarshallWithXSD {
	public static void main(String[ ] args) {
		JAXBContext jc = null;
		try {
		jc = JAXBContext.newInstance(ObjectFactory.class);
		Unmarshaller um = jc.createUnmarshaller();
		String schemaName = "src\\by\\pvt\\heldyieu\\xml\\tariffs.xsd";
		SchemaFactory factory =
		SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		File schemaLocation = new File(schemaName);
		// создание схемы и перадача ее демарашаллизатору
		Schema schema = factory.newSchema(schemaLocation);
		um.setSchema(schema);
		@SuppressWarnings("unchecked")
		JAXBElement<MobileProviderType> unmarshalledObject = (JAXBElement<MobileProviderType>) 
				um.unmarshal(new File("src\\by\\pvt\\heldyieu\\xml\\tariffs.xml"));
		unmarshalledObject.getValue().getTariffs().getTariffForCalls().getTariff().forEach(item->System.out.println(item.toString()));
		unmarshalledObject.getValue().getTariffs().getTariffForInternet().getTariff().forEach(item->System.out.println(item.toString()));
		} catch (JAXBException e) {
		e.printStackTrace();
		} catch (SAXException e) {
		e.printStackTrace();
		}
		}
}
