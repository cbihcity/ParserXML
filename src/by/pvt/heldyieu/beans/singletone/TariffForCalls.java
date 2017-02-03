package by.pvt.heldyieu.beans.singletone;

import java.util.ArrayList;
import java.util.List;

import by.pvt.heldyieu.beans.callprices.CallPrices;
import by.pvt.heldyieu.beans.callprices.CallPricesTypes;
import by.pvt.heldyieu.beans.callprices.InitCallPrices;
import by.pvt.heldyieu.beans.parameters.InitParameters;
import by.pvt.heldyieu.beans.parameters.Parameters;
import by.pvt.heldyieu.beans.tariff.Tariff;
import by.pvt.heldyieu.builders.TariffForCallsBuilder;
import by.pvt.heldyieu.interfaces.Constants;

public class TariffForCalls implements Constants {
	
	private volatile static TariffForCalls INSTANCE;
	private List<Tariff> listOfTariff;
	
	/**
	 * @return the listOfTariff
	 */
	public List<Tariff> getListOfTariff() {
		return new ArrayList<Tariff>(listOfTariff);
	}
	
	public void setListOfTariff(List<Tariff> listOfTariff) {
		this.listOfTariff = listOfTariff;
	}

	private TariffForCalls(){
		listOfTariff = createTariff();
	}
	
	private List<Tariff> createTariff() {
		ArrayList<Tariff> temp = new ArrayList<Tariff>();
		List<CallPrices> callsPrice = InitCallPrices.init(TARIFF_FOR_CALLS);
		Parameters parameter = InitParameters.init(TARIFF_FOR_CALLS);
		TariffForCallsBuilder builder = new TariffForCallsBuilder();
		builder.freeMinutes(200).name("Стандарт").operatorName("МТС")
				.payroll(5.5).smsPrice(0.15)
				.listOfPrices(new CallPricesTypes(callsPrice))
				.parameters(parameter);
		temp.add(builder.getTariff());
		return temp;
	}

	public static TariffForCalls getInstance() {
		if (INSTANCE == null) {
			synchronized (TariffForCalls.class) {
				if (INSTANCE == null) {
					INSTANCE = new TariffForCalls();
				}
			}
		}
		return INSTANCE;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\nТарифы для звонков";
	}
	
}
