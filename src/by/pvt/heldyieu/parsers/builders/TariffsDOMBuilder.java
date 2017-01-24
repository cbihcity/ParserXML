
package by.pvt.heldyieu.parsers.builders;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;


/**
 * 
 */
public class TariffsDOMBuilder extends AbstractTariffsBuilder {
	static Logger logger = Logger.getLogger(TariffsDOMBuilder.class.getName());
	/**
	 * 
	 */
	public TariffsDOMBuilder() {
		super();
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
