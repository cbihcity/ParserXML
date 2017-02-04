package by.pvt.heldyieu.parsers.builders;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import org.w3c.dom.NodeList;
import by.pvt.heldyieu.interfaces.Constants;
import by.pvt.heldyieu.parsers.tools.OperationsDOMParsers;

public class TariffsDOMBuilder extends AbstractTariffsBuilder implements Constants {
	static Logger logger = Logger.getLogger(TariffsDOMBuilder.class.getName());
	private DocumentBuilder docBuilder;
	
	
	public TariffsDOMBuilder() {
		super();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			docBuilder = factory.newDocumentBuilder();
		} 
		catch(ParserConfigurationException e){
			System.err.println(CONFIGURATION_ERROR + e);
		}
	}

	public void buildTariffs(String filename){
		try {
			System.out.println();
			logger.info("Start to parse...");
			Document doc = docBuilder.parse(filename);
			Element root = doc.getDocumentElement();
			System.out.println("Root element : "+root.getNodeName());
			System.out.println(DELIMITER);
			NodeList internetList = doc.getElementsByTagName(TARIFF_FOR_INTERNET);
			logger.info("Get list of Internet tariffs");
			tariffForInternet.setListOfTariff(OperationsDOMParsers.buildTariffsParser(internetList, TARIFF_FOR_INTERNET));
			NodeList callsList = doc.getElementsByTagName(TARIFF_FOR_CALLS);
			logger.info("Get list of Calls tariffs");
			tariffForCalls.setListOfTariff(OperationsDOMParsers.buildTariffsParser(callsList, TARIFF_FOR_CALLS));
		}
			catch (SAXException e) {
				logger.error(SAX_ERROR, e);
			} catch (IOException e) {
				logger.error(IO_ERROR + filename, e);
			}
	}
}
