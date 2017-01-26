/**
 * 
 */
package by.pvt.heldyieu.parsers.builders;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.pvt.heldyieu.interfaces.Constants;
import by.pvt.heldyieu.parsers.tools.TariffSAXHandler;

/**
 * 
 */
public class TariffsSAXBuilder extends AbstractTariffsBuilder implements Constants {
	static Logger logger = Logger.getLogger(TariffsSAXBuilder.class.getName());
	private TariffSAXHandler handler;
	private XMLReader reader;

	
	public TariffsSAXBuilder() {
		super();
		handler = new TariffSAXHandler();
		try {
			reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(handler);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void buildTariffs(String filename) {
		try {
			reader.parse(LOG_FILENAME);
		} 
		catch (SAXException e) {
			System.err.println("Проблема при парсере документа "+e);
			logger.error("Проблема при парсере документа ", e);
		} catch (IOException e) {
			System.err.println("Проблема с доступа ресурса "+filename);
			logger.error("Проблема с доступа ресурса "+filename, e);
		}
		
	}
	

}
