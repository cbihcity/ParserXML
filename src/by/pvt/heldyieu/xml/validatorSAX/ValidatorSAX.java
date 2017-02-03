package by.pvt.heldyieu.xml.validatorSAX;

import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import by.pvt.heldyieu.interfaces.Constants;

public class ValidatorSAX implements Constants {
	private static final Logger logger = Logger.getLogger(ValidatorSAX.class.getName());
	
	public static void validateXMLFile() {
		String filename = XML_FILENAME;
		String schemaname = XSD_FILNAME;
		String logname = LOG_FILENAME;
		Schema schema = null;
		String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
		SchemaFactory factory = SchemaFactory.newInstance(language);
		logger.info("Проверка xml файла на валидность");
		try {
			logger.info("установка проверки с использованием XSD");
			schema = factory.newSchema(new File(schemaname));
			SAXParserFactory spf = SAXParserFactory.newInstance();
			spf.setNamespaceAware(true);
			spf.setSchema(schema);
			logger.info("создание объекта-парсера"); 
			SAXParser parser = spf.newSAXParser();
			logger.info("установка обработчика ошибок и запуск валидатора");
			parser.parse(filename, new TariffErrorHandler(logname));
			System.out.println(filename + " is valid");
			System.out.println(DELIMITER);
		} catch (ParserConfigurationException e) {
			System.err.println(filename + " config error: " + e.getMessage());
		} catch (SAXException e) {
			System.err.println(filename + " SAX error: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("I/O error: " + e.getMessage());
		}
	}
}

