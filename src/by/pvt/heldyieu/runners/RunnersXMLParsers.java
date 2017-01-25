package by.pvt.heldyieu.runners;

import by.pvt.heldyieu.parsers.builders.TariffsDOMBuilder;

public class RunnersXMLParsers {
	public static void main(String[] args) {
		TariffsDOMBuilder domBuilder = new TariffsDOMBuilder();
		domBuilder.buildTariffs("src\\by\\pvt\\heldyieu\\xml\\tariffs.xml");
		System.out.println(domBuilder.getListOfCallsTariff());
		System.out.println(domBuilder.getListOfInternetTariff());
	}
}
