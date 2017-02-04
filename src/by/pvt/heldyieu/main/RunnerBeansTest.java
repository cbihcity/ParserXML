package by.pvt.heldyieu.main;

import org.apache.log4j.Logger;

import by.pvt.heldyieu.beans.singletone.Tariffs;

public class RunnerBeansTest {
	private static final Logger logger = Logger.getLogger(RunnerBeansTest.class.getName());

	public static void main(String[] args) {
		logger.info("Get new entyties of Tariffs and initizalize them with testing values");
		Tariffs tariffs = Tariffs.getInstance();
		logger.info("Print the list of callsTariffs");
		tariffs.getTariffForCalls().getListOfTariff().forEach(item->System.out.println(item));
		logger.info("Print the list of internetTariffs");
		tariffs.getTariffForInternet().getListOfTariff().forEach(item->System.out.println(item));
	}
}
