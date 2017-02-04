package by.pvt.heldyieu.parsers.builders;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import by.pvt.heldyieu.beans.singletone.TariffForCalls;
import by.pvt.heldyieu.beans.singletone.TariffForInternet;
import by.pvt.heldyieu.interfaces.Constants;
import by.pvt.heldyieu.parsers.tools.TariffSAXHandler;

public class TariffsSAXBuilder extends AbstractTariffsBuilder implements Constants {
	
	static Logger logger = Logger.getLogger(TariffsSAXBuilder.class.getName());
	
	public TariffsSAXBuilder() {
		super();
	}

	@Override
	public void buildTariffs(String filename) {
		try {
			XMLReader xmlReader = XMLReaderFactory.createXMLReader();
			logger.info("Create TariffSAXHandler entity");
			TariffSAXHandler handler = new TariffSAXHandler();
			xmlReader.setContentHandler(handler);
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
			SAXParser saxParser = saxParserFactory.newSAXParser();
			File f = new File(filename);
			logger.info("Start to parse...");
			saxParser.parse(f, handler);
			if (handler!= null) {
				logger.info("Get list of Calls tariffs");
				TariffForCalls.getInstance().setListOfTariff(handler.getTempCallsTariffs());
				logger.info("Get list of Internet tariffs");
				TariffForInternet.getInstance().setListOfTariff(handler.getTempInternetTariffs());
			}
		} 
		catch (SAXException e) {
			System.err.println(SAX_ERROR + e);
			logger.error(SAX_ERROR, e);
		} catch (ParserConfigurationException e) {
			logger.error(SAX_ERROR, e);
		} catch (IOException e) {
			logger.error(SAX_ERROR, e);
		}
		
	}
	

}
