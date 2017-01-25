
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
import by.pvt.heldyieu.beans.singletone.TariffForCalls;
import by.pvt.heldyieu.beans.singletone.TariffForInternet;
import by.pvt.heldyieu.interfaces.Constants;
import by.pvt.heldyieu.parsers.tools.OperationsDOMParsers;


/**
 * 
 */
public class TariffsDOMBuilder implements Constants {
	static Logger logger = Logger.getLogger(TariffsDOMBuilder.class.getName());
	private TariffForCalls tariffForCalls;
	private TariffForInternet tariffForInternet;
	private DocumentBuilder docBuilder;
	
	
	public TariffsDOMBuilder() {
		tariffForCalls = TariffForCalls.getInstance();
		tariffForInternet = TariffForInternet.getInstance();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			docBuilder = factory.newDocumentBuilder();
		} 
		catch(ParserConfigurationException e){
			System.err.println("Ошибка конфигурации парсера :" + e);
		}
	}

	public TariffForCalls getTariffForCalls() {
		return tariffForCalls;
	}

	public TariffForInternet getTariffForInternet() {
		return tariffForInternet;
	}


	public void buildTariffs(String filename){
		Document doc = null; 
		try {
			doc = docBuilder.parse(filename);
			Element root = doc.getDocumentElement();
			System.out.println("Root element : "+root.getNodeName());
			System.out.println(DELIMITER);
			NodeList internetList = doc.getElementsByTagName(TARIFF_FOR_INTERNET);
			tariffForInternet.setListOfTariff(OperationsDOMParsers.buildTariffsParser(internetList, TARIFF_FOR_INTERNET));
			NodeList callsList = doc.getElementsByTagName(TARIFF_FOR_CALLS);
			tariffForCalls.setListOfTariff(OperationsDOMParsers.buildTariffsParser(callsList, TARIFF_FOR_CALLS));
			
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
