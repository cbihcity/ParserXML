package by.pvt.heldyieu.beans.builders;

import by.pvt.heldyieu.beans.callprices.CallPricesTypes;
import by.pvt.heldyieu.beans.parameters.Parameters;
import by.pvt.heldyieu.beans.tariff.Tariff;

public class TariffForInernetBuilder extends AbstractTariffBuilder {

	private Tariff tariff = new Tariff();
	public Tariff getInstance(){
		return tariff;
	}
	
	@Override
	public TariffForInernetBuilder buildName(String name) {
		tariff.setName(name);
		return this;
	}

	@Override
	public TariffForInernetBuilder buildOperatorName(String operatorName) {
		tariff.setOperatorName(operatorName);
		return this;
	}

	@Override
	public TariffForInernetBuilder buildPayroll(double payroll) {
		tariff.setPayroll(payroll);
		return this;
	}

	@Override
	public TariffForInernetBuilder buildSmsPrice(double smsPrice) {
		tariff.setSmsPrice(smsPrice);
		return this;
	}

	@Override
	public TariffForInernetBuilder buildParameters(Parameters parameters) {
		tariff.setParameters(parameters);
		return this;
	}
	
	public TariffForInernetBuilder buildFreeGygabytes(double freeGygabytes) {
		tariff.setFreeGygabytes(freeGygabytes);
		return this;
	}

	@Override
	public TariffForInernetBuilder buildListOfPrices(CallPricesTypes callPrices) {
		tariff.setCallPrices(callPrices);
		return this;
		
	}
	
}
