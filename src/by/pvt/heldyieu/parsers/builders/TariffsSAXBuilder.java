/**
 * 
 */
package by.pvt.heldyieu.parsers.builders;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * 
 */
public class TariffsSAXBuilder extends AbstractTariffsBuilder {
	static Logger logger = Logger.getLogger(TariffsSAXBuilder.class.getName());
	
//	@Override
//	public List<HumanEatings> buildListHumanEatings(String fileName)
//			throws ParserConfigurationException {
//		logger.debug("Start SAX parsing");
//		try {
//			XMLReader xmlReader = XMLReaderFactory.createXMLReader();
//			SAXHumanEatingsParser humanEatingsHandler = new SAXHumanEatingsParser();
//			xmlReader.setContentHandler(humanEatingsHandler);
//			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
//			SAXParser saxParser = saxParserFactory.newSAXParser();
//			File f = new File(fileName);
//			saxParser.parse(f, humanEatingsHandler);
//			if (humanEatingsHandler != null) {
//				humanEatings = humanEatingsHandler.getHumanEatings();
//			}
//		} catch (SAXException e) {
//			System.err.println("Problem of parser");
//			logger.error("Problem of parser", e);
//		} catch (IOException e) {
//			System.err.print("Problem of reading file"+fileName);
//			logger.error("Problem of reading file"+fileName, e);
//		}
//		logger.debug("End SAX parsing");
//		return humanEatings;
//	}
}
