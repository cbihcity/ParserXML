/**
 * 
 */
package by.pvt.heldyieu.parsers.builders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import org.apache.log4j.Logger;


/**
 *
 */
//public class TariffsStAXBuilder extends AbstractTariffsBuilder{
//	static Logger logger = Logger.getLogger(TariffsStAXBuilder.class.getName());
//	@Override
//	public List<HumanEatings> buildListHumanEatings(String fileName){
//		logger.debug("Start StAX parsing");
//		StAXHumanEatingsParser humanEatingParser = new StAXHumanEatingsParser();
//		InputStream inputStream;
//		try {
//			inputStream = new FileInputStream(fileName);
//			humanEatings = humanEatingParser.parse(inputStream);
//		} catch (FileNotFoundException e) {
//			System.err.println("File "+fileName+" not found");
//			logger.error("File "+fileName+" not found", e);
//		}
//		logger.debug("End StAX parsing");
//		return humanEatings;
//	}
//}