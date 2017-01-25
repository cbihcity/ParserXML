package by.pvt.heldyieu.management.tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import by.pvt.heldyieu.beans.singletone.TariffForCalls;
import by.pvt.heldyieu.beans.singletone.TariffForInternet;
import by.pvt.heldyieu.beans.tariff.Tariff;

public class ManagementOperations {

	public static void ReportTariffsCompareByPayroll(
		TariffForCalls tariffForCalls, TariffForInternet tariffForInternet) {
		List<Tariff> tempTariffs = new ArrayList<Tariff>();
		tempTariffs.addAll(tariffForCalls.getListOfTariff());
		tempTariffs.addAll(tariffForInternet.getListOfTariff());
		Collections.sort(tempTariffs, new Tariff());
		tempTariffs.forEach(item->System.out.println(item));
	}
	
}
