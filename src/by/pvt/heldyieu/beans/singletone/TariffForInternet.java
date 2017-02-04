package by.pvt.heldyieu.beans.singletone;

import java.util.ArrayList;
import java.util.List;

import by.pvt.heldyieu.beans.callprices.CallPrices;
import by.pvt.heldyieu.beans.callprices.CallPricesTypes;
import by.pvt.heldyieu.beans.callprices.InitCallPrices;
import by.pvt.heldyieu.beans.parameters.InitParameters;
import by.pvt.heldyieu.beans.parameters.Parameters;
import by.pvt.heldyieu.beans.tariff.Tariff;
import by.pvt.heldyieu.builders.TariffForInernetBuilder;
import by.pvt.heldyieu.interfaces.Constants;

public class TariffForInternet implements Constants {

	private volatile static TariffForInternet INSTANCE;
	private List<Tariff> listOfTariff = null;

	
	/**
	 * @return the listOfTariff
	 */
	public List<Tariff> getListOfTariff() {
		return new ArrayList<Tariff>(listOfTariff);
	}
	
	public void setListOfTariff(List<Tariff> listOfTariff) {
		this.listOfTariff = listOfTariff;
	}

	private TariffForInternet(){
		listOfTariff = createTariff();
	}
	
	private ArrayList<Tariff> createTariff() {
		ArrayList<Tariff> temp = new ArrayList<Tariff>();
		List<CallPrices> callsPrice = InitCallPrices.init(TARIFF_FOR_INTERNET);
		Parameters parameter = InitParameters.init(TARIFF_FOR_INTERNET);
		TariffForInernetBuilder builder = new TariffForInernetBuilder();
		builder.freeGygabytes(2.0).name("Смарт 1").operatorName("Велком")
				.payroll(3.5).smsPrice(0.15)
				.listOfPrices(new CallPricesTypes(callsPrice))
				.parameters(parameter);
		Tariff tariff = builder.getTariff();
		temp.add(tariff);
		return temp;
	}

	public static TariffForInternet getInstance() {
		if (INSTANCE == null) {
			synchronized (TariffForInternet.class) {
				if (INSTANCE == null) {
					INSTANCE = new TariffForInternet();
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
		return TARIFF_FOR_INTERNET_TOSTRING;
	}
	

}
