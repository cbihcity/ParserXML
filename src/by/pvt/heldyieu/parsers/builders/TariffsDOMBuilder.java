
package by.pvt.heldyieu.parsers.builders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import org.w3c.dom.NodeList;

import by.pvt.heldyieu.beans.singletone.TariffForCalls;
import by.pvt.heldyieu.beans.singletone.TariffForInternet;
import by.pvt.heldyieu.beans.singletone.Tariffs;
import by.pvt.heldyieu.beans.tariff.Tariff;


/**
 * 
 */
public class TariffsDOMBuilder {
	static Logger logger = Logger.getLogger(TariffsDOMBuilder.class.getName());
	private ArrayList<Tariff> listOfCallsTariff;
	private ArrayList<Tariff> listOfInternetTariff;
	private DocumentBuilder docBuilder;
	
	
	public TariffsDOMBuilder() {
		listOfCallsTariff = new ArrayList<Tariff>();
		listOfInternetTariff = new ArrayList<Tariff>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			docBuilder = factory.newDocumentBuilder();
		} 
		catch(ParserConfigurationException e){
			System.err.println("Ошибка конфигурации парсера :" + e);
		}
	}

	public ArrayList<Tariff> getListOfCallsTariff() {
		return listOfCallsTariff;
	}

	public ArrayList<Tariff> getListOfInternetTariff() {
		return listOfInternetTariff;
	}


	public void buildTariffs(String filename){
		Document doc = null; 
		try {
			doc = docBuilder.parse(filename);
			Element root = doc.getDocumentElement();
			System.out.println("Root element : "+root.getNodeName());
			System.out.println("===============");
			Node tariffForInternet = root.getNextSibling();
			System.out.println("Current element : "+tariffForInternet.getNodeName());
			
			
			
			
			
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

//	@Override
//	public List<HumanEatings> buildListHumanEatings(String fileName) {
//		logger.debug("Start DOM parsing");
//		try {
//			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
//			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
//			Document document = documentBuilder.parse(fileName);
//			Element root = document.getDocumentElement();
//			humanEatings = DOMHumanEatingsParser.listBuilder(root);
//		} catch (SAXException e) {
//			System.err.println("Problem of parser"+e);
//			logger.error("Problem of parser", e);
//		} catch (ParserConfigurationException e) {
//			System.err.println("Problem of parser configuration"+e);
//			logger.error("Problem of parser configuration", e);
//		} catch (IOException e) {
//			System.err.println("Problem of reading file"+fileName);
//			logger.error("Problem of reading file"+fileName, e);
//		}
//		logger.debug("End DOM parsing");
//		return humanEatings;
//	}
}
