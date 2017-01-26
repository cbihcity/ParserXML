package by.pvt.heldyieu.runners;

import by.pvt.heldyieu.beans.singletone.TariffForCalls;
import by.pvt.heldyieu.beans.singletone.TariffForInternet;
import by.pvt.heldyieu.exceptions.InvalidValueException;
import by.pvt.heldyieu.interfaces.Constants;
import by.pvt.heldyieu.management.tools.ManagementOperations;
import by.pvt.heldyieu.parsers.builders.AbstractTariffsBuilder;
import by.pvt.heldyieu.parsers.factory.TariffsParserBuilderFactory;

public class RunnersXMLParsers implements Constants {
	public static void main(String[] args) {
		TariffForCalls tariffForCalls; 
		TariffForInternet tariffForInternet;
		AbstractTariffsBuilder tariffBuilder;
		TariffsParserBuilderFactory builderFactory = new TariffsParserBuilderFactory();
		
		
		// makind TariffsDOMBuilder
		try {
			//get type of TariffParser
			tariffBuilder = builderFactory.createTariffsBuilder(TYPE_DOM_PARSER);
			//Parsing XML
			tariffBuilder.buildTariffs(XML_FILENAME);
			//get TariffForCalls instance after parsing
			tariffForCalls = tariffBuilder.getTariffForCalls();
			System.out.println(tariffForCalls.toString());
			//print list tariffs of TariffsForCalls
			tariffForCalls.getListOfTariff().forEach(item->System.out.println(item));
			//get TariffForInternet instance after parsing
			tariffForInternet = tariffBuilder.getTariffForInternet();
			System.out.println(tariffForInternet.toString());
			//print list tariffs of TariffForInternet
			tariffForInternet.getListOfTariff().forEach(item->System.out.println(item));
			System.out.println(DELIMITER);
			System.out.println("Отсортированный список тарифов по абонентской плате :");
			//print list of tariffs sorted by payroll
			ManagementOperations.ReportTariffsCompareByPayroll(tariffForCalls, tariffForInternet);
		} catch (InvalidValueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			tariffBuilder = builderFactory.createTariffsBuilder(TYPE_SAX_PARSER);
			tariffBuilder.buildTariffs(XML_FILENAME);
			tariffForCalls = tariffBuilder.getTariffForCalls();
			System.out.println(tariffForCalls.toString());
			tariffForCalls.getListOfTariff().forEach(item->System.out.println(item));
			
			tariffForInternet = tariffBuilder.getTariffForInternet();
			System.out.println(tariffForInternet.toString());
			tariffForInternet.getListOfTariff().forEach(item->System.out.println(item));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

	
}
