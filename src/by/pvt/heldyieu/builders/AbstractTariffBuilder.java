package by.pvt.heldyieu.builders;

import by.pvt.heldyieu.beans.callprices.CallPricesTypes;
import by.pvt.heldyieu.beans.parameters.Parameters;
import by.pvt.heldyieu.beans.tariff.Tariff;

public abstract class AbstractTariffBuilder {
	protected String name = null;
    protected String operatorName = null;
    protected double payroll = 0;
    protected CallPricesTypes callPrices = null;
    protected double smsPrice = 0;
    protected double freeGygabytes = 0;
    protected int freeMinutes = 0;
    protected Parameters parameters = null;	
    protected Tariff tariff = null;
	
	public AbstractTariffBuilder name(String name) {
		this.name = name;
		return this;
	}

	public AbstractTariffBuilder operatorName(String operatorName) {
		this.operatorName = operatorName;
		return this;
	}

	public AbstractTariffBuilder payroll(double payroll) {
		this.payroll = payroll;
		return this;
	}

	public AbstractTariffBuilder listOfPrices(CallPricesTypes callPrices) {
		this.callPrices = callPrices;
		return this;
	}

	public AbstractTariffBuilder smsPrice(double smsPrice) {
		this.smsPrice = smsPrice;
		return this;
	}

	public AbstractTariffBuilder parameters(Parameters parameters) {
		this.parameters = parameters;
		return this;
	}

	protected abstract boolean tariffIsValid();
	protected abstract void cleanTariffInstance();
}
