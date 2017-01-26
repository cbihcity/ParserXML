package by.pvt.heldyieu.parsers.builders;

import by.pvt.heldyieu.beans.singletone.TariffForCalls;
import by.pvt.heldyieu.beans.singletone.TariffForInternet;

public abstract class AbstractTariffsBuilder {
	
	protected TariffForCalls tariffForCalls;
	protected TariffForInternet tariffForInternet;
	
	public AbstractTariffsBuilder(){
		tariffForCalls = TariffForCalls.getInstance();
		tariffForInternet = TariffForInternet.getInstance();
	}

	public TariffForCalls getTariffForCalls() {
		return tariffForCalls;
	}

	public TariffForInternet getTariffForInternet() {
		return tariffForInternet;
	}
	
	abstract public void buildTariffs(String filename);
	
}