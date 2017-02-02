package by.pvt.heldyieu.beans.builders;

import by.pvt.heldyieu.beans.callprices.CallPricesTypes;
import by.pvt.heldyieu.beans.parameters.Parameters;
import by.pvt.heldyieu.beans.tariff.Tariff;

public abstract class AbstractTariffBuilder {
	private Tariff tariff = new Tariff();
	
	public Tariff getTariff(){
		return tariff;
	}
	
	public abstract AbstractTariffBuilder buildName(String name);
	public abstract AbstractTariffBuilder buildOperatorName(String operatorName);
	public abstract AbstractTariffBuilder buildPayroll(double payroll);
	public abstract AbstractTariffBuilder buildListOfPrices(CallPricesTypes callPrices);
	public abstract AbstractTariffBuilder buildSmsPrice(double smsPrice);
	public abstract AbstractTariffBuilder buildParameters(Parameters parameters);
	
}
