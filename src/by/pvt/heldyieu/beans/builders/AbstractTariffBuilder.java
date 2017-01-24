package by.pvt.heldyieu.beans.builders;

import by.pvt.heldyieu.beans.callprices.CallPricesTypes;
import by.pvt.heldyieu.beans.parameters.Parameters;
import by.pvt.heldyieu.beans.tariffs.Tariff;

abstract class AbstractTariffBuilder {
	private Tariff tariff = new Tariff();
	
	public Tariff getTariff(){
		return tariff;
	}
	
	public abstract void buildName(String name);
	public abstract void buildOperatorName(String operatorName);
	public abstract void buildPayroll(double payroll);
	public abstract void buildListOfPrices(CallPricesTypes callPrices);
	public abstract void buildSmsPrice(double smsPrice);
	public abstract void buildParameters(Parameters parameters);

	
}
