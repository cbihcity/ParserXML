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
			tariffBuilder = builderFactory.createTariffsBuilder(TYPE_DOM_PARSER);
			tariffBuilder.buildTariffs(XML_FILENAME);
			tariffForCalls = tariffBuilder.getTariffForCalls();
			System.out.println(tariffForCalls.toString());
			tariffForCalls.getListOfTariff().forEach(item->System.out.println(item));
			tariffForInternet = tariffBuilder.getTariffForInternet();
			System.out.println(tariffForInternet.toString());
			tariffForInternet.getListOfTariff().forEach(item->System.out.println(item));
			System.out.println(DELIMITER);
			System.out.println("Отсортированный список тарифов по абонентской плате :");
			ManagementOperations.ReportTariffsCompareByPayroll(tariffForCalls, tariffForInternet);
		} catch (InvalidValueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
}
