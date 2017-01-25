package by.pvt.heldyieu.xml.validatorSAX;
import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import by.pvt.heldyieu.interfaces.Constants;

public class ValidatorSAX implements Constants {
	public static void main(String[] args) {
		String filename = XML_FILENAME;
		String schemaname = XSD_FILNAME;
		String logname = LOG_FILENAME;
		Schema schema = null;
		String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
		SchemaFactory factory = SchemaFactory.newInstance(language);
		try {
			// ��������� �������� � �������������� XSD
			schema = factory.newSchema(new File(schemaname));
			SAXParserFactory spf = SAXParserFactory.newInstance();
			spf.setSchema(schema);
			// �������� �������-�������
			SAXParser parser = spf.newSAXParser();
			// ��������� ����������� ������ � ������
			parser.parse(filename, new StudentErrorHandler(logname));
			System.out.println(filename + " is valid");
		} catch (ParserConfigurationException e) {
			System.err.println(filename + " config error: " + e.getMessage());
		} catch (SAXException e) {
			System.err.println(filename + " SAX error: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("I/O error: " + e.getMessage());
		}
	}
}

