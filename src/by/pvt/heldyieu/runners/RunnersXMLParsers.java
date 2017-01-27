package by.pvt.heldyieu.runners;

import org.apache.log4j.Logger;
import by.pvt.heldyieu.beans.singletone.TariffForCalls;
import by.pvt.heldyieu.beans.singletone.TariffForInternet;
import by.pvt.heldyieu.exceptions.InvalidValueException;
import by.pvt.heldyieu.interfaces.Constants;
import by.pvt.heldyieu.management.tools.ManagementOperations;
import by.pvt.heldyieu.parsers.builders.AbstractTariffsBuilder;
import by.pvt.heldyieu.parsers.factory.TariffsParserBuilderFactory;

public class RunnersXMLParsers implements Constants {
	static Logger logger = Logger.getLogger(RunnersXMLParsers.class.getName());

	public static void main(String[] args) {
		TariffForCalls tariffForCalls = null;
		TariffForInternet tariffForInternet = null;
		AbstractTariffsBuilder tariffBuilder;
		TariffsParserBuilderFactory builderFactory = new TariffsParserBuilderFactory();

		
		// making TariffsDOMBuilder

		// get type of TariffParser
		try {
			tariffBuilder = builderFactory.createTariffsBuilder(TYPE_DOM_PARSER);
			// Parsing XML
			System.out.println(START_PARSE_DOMBUILDER);
			tariffBuilder.buildTariffs(XML_FILENAME);
			// get TariffForCalls instance after parsing
			tariffForCalls = tariffBuilder.getTariffForCalls();
			System.out.println(tariffForCalls.toString());
			// print list tariffs of TariffsForCalls
			tariffForCalls.getListOfTariff().forEach(item -> System.out.println(item));
			// get TariffForInternet instance after parsing
			tariffForInternet = tariffBuilder.getTariffForInternet();
			System.out.println(tariffForInternet.toString());
			// print list tariffs of TariffForInternet
			tariffForInternet.getListOfTariff().forEach(item -> System.out.println(item));
			System.out.println(MESSAGE_SORT_LIST.toUpperCase());
			// print list of tariffs sorted by payroll
			ManagementOperations.ReportTariffsCompareByPayroll(tariffForCalls,tariffForInternet);
			System.out.println(END_DOM_PARSER);

		} catch (InvalidValueException e) {
			logger.error("Invalid value exception");
		}
		
		try {
			// making TariffsSAXBuilder
			tariffBuilder = builderFactory.createTariffsBuilder(TYPE_SAX_PARSER);
			System.out.println(START_PARSE_SAXBUILDER);
			tariffBuilder.buildTariffs(XML_FILENAME);
			tariffForCalls = tariffBuilder.getTariffForCalls();
			System.out.println(tariffForCalls.toString());
			tariffForCalls.getListOfTariff().forEach(item->System.out.println(item));
			tariffForInternet = tariffBuilder.getTariffForInternet();
			System.out.println(tariffForInternet.toString());
			tariffForInternet.getListOfTariff().forEach(item->System.out.println(item));
			System.out.println(MESSAGE_SORT_LIST.toUpperCase());
			// print list of tariffs sorted by payroll
			ManagementOperations.ReportTariffsCompareByPayroll(tariffForCalls,tariffForInternet);
			System.out.println(END_SAX_PARSER);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
