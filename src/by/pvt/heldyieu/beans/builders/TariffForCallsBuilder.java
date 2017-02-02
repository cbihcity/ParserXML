package by.pvt.heldyieu.beans.builders;

import by.pvt.heldyieu.beans.callprices.CallPricesTypes;
import by.pvt.heldyieu.beans.parameters.Parameters;
import by.pvt.heldyieu.beans.tariff.Tariff;

public class TariffForCallsBuilder extends AbstractTariffBuilder{

	private Tariff tariff = new Tariff();
	public Tariff getInstance(){
		return tariff;
	}
	
	@Override
	public TariffForCallsBuilder buildName(String name) {
		tariff.setName(name);
		return this;
	}

	@Override
	public TariffForCallsBuilder buildOperatorName(String operatorName) {
		tariff.setOperatorName(operatorName);
		return this;
	}

	@Override
	public TariffForCallsBuilder buildPayroll(double payroll) {
		tariff.setPayroll(payroll);
		return this;
	}


	@Override
	public TariffForCallsBuilder buildSmsPrice(double smsPrice) {
		tariff.setSmsPrice(smsPrice);
		return this;
	}

	@Override
	public TariffForCallsBuilder buildParameters(Parameters parameters) {
		tariff.setParameters(parameters);
		return this;
	}
	
	public TariffForCallsBuilder buildFreeMinutes(int freeMinutes) {
		tariff.setFreeMinutes(freeMinutes);
		return this;
	}

	@Override
	public TariffForCallsBuilder buildListOfPrices(CallPricesTypes callPrices) {
		tariff.setCallPrices(callPrices);
		return this;
		
	}

	
	
}
