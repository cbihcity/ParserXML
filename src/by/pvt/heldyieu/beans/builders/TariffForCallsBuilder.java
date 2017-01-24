package by.pvt.heldyieu.beans.builders;

import by.pvt.heldyieu.beans.callprices.CallPricesTypes;
import by.pvt.heldyieu.beans.parameters.Parameters;
import by.pvt.heldyieu.beans.tariffs.Tariff;

public class TariffForCallsBuilder extends AbstractTariffBuilder{

	private Tariff tariff = new Tariff();
	public Tariff getInstance(){
		return tariff;
	}
	
	@Override
	public void buildName(String name) {
		tariff.setName(name);
	}

	@Override
	public void buildOperatorName(String operatorName) {
		tariff.setOperatorName(operatorName);
	}

	@Override
	public void buildPayroll(double payroll) {
		tariff.setPayroll(payroll);
	}


	@Override
	public void buildSmsPrice(double smsPrice) {
		tariff.setSmsPrice(smsPrice);
	}

	@Override
	public void buildParameters(Parameters parameters) {
		tariff.setParameters(parameters);
	}
	
	public void buildFreeMinutes(int freeMinutes) {
		tariff.setFreeMinutes(freeMinutes);
	}

	@Override
	public void buildListOfPrices(CallPricesTypes callPrices) {
		tariff.setCallPrices(callPrices);
		
	}

	
	
}
