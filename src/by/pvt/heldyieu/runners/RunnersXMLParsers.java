package by.pvt.heldyieu.runners;

import by.pvt.heldyieu.beans.singletone.TariffForCalls;
import by.pvt.heldyieu.beans.singletone.TariffForInternet;
import by.pvt.heldyieu.interfaces.Constants;
import by.pvt.heldyieu.management.tools.ManagementOperations;
import by.pvt.heldyieu.parsers.builders.TariffsDOMBuilder;

public class RunnersXMLParsers implements Constants {
	public static void main(String[] args) {
		TariffsDOMBuilder domBuilder = new TariffsDOMBuilder();
		domBuilder.buildTariffs(XML_FILENAME);
		TariffForCalls tariffForCalls = domBuilder.getTariffForCalls();
		System.out.println(tariffForCalls.toString());
		tariffForCalls.getListOfTariff().forEach(item->System.out.println(item));
		
		TariffForInternet tariffForInternet = domBuilder.getTariffForInternet();
		System.out.println(tariffForInternet.toString());
		tariffForInternet.getListOfTariff().forEach(item->System.out.println(item));
		ManagementOperations.ReportTariffsCompareByPayroll(tariffForCalls, tariffForInternet);
	}

	
}
