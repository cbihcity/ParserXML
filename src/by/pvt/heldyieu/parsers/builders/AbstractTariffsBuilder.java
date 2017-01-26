package by.pvt.heldyieu.parsers.builders;

import java.util.ArrayList;
import by.pvt.heldyieu.beans.singletone.TariffForCalls;
import by.pvt.heldyieu.beans.singletone.TariffForInternet;
import by.pvt.heldyieu.beans.tariff.Tariff;

public abstract class AbstractTariffsBuilder {
	private final ArrayList<Tariff> emptyList = new ArrayList<Tariff>();
	protected TariffForCalls tariffForCalls;
	protected TariffForInternet tariffForInternet;
	
	public AbstractTariffsBuilder(){
		tariffForCalls = TariffForCalls.getInstance();
		tariffForCalls.setListOfTariff(emptyList);
		tariffForInternet = TariffForInternet.getInstance();
		tariffForInternet.setListOfTariff(emptyList);
	}

	public TariffForCalls getTariffForCalls() {
		return tariffForCalls;
	}

	public TariffForInternet getTariffForInternet() {
		return tariffForInternet;
	}
	
	abstract public void buildTariffs(String filename);
	
}