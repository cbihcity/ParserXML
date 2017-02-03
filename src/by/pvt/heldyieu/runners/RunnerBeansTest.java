package by.pvt.heldyieu.runners;

import by.pvt.heldyieu.beans.singletone.Tariffs;

public class RunnerBeansTest {
	public static void main(String[] args) {
		Tariffs tariffs = Tariffs.getInstance();
		tariffs.getTariffForCalls().getListOfTariff().forEach(item->System.out.println(item));
		tariffs.getTariffForInternet().getListOfTariff().forEach(item->System.out.println(item));
	}
}
