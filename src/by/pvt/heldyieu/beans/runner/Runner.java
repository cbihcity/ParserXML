package by.pvt.heldyieu.beans.runner;

import by.pvt.heldyieu.beans.singletone.Tariffs;

public class Runner {
	public static void main(String[] args) {
		Tariffs tariffs = Tariffs.getInstance();
		tariffs.getTariffForCalls().getListOfTariff().forEach(item->System.out.println(item));
		tariffs.getTariffForInternet().getListOfTariff().forEach(item->System.out.println(item));
	}
	
	
}
