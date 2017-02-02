package by.pvt.heldyieu.beans.singletone;

import java.util.ArrayList;
import java.util.List;
import by.pvt.heldyieu.beans.builders.TariffForInernetBuilder;
import by.pvt.heldyieu.beans.callprices.CallPrices;
import by.pvt.heldyieu.beans.callprices.CallPricesTypes;
import by.pvt.heldyieu.beans.callprices.InitCallPrices;
import by.pvt.heldyieu.beans.parameters.InitParameters;
import by.pvt.heldyieu.beans.parameters.Parameters;
import by.pvt.heldyieu.beans.tariff.Tariff;
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
		builder.buildName("Смарт 1").buildOperatorName("Велком")
				.buildPayroll(3.5).buildSmsPrice(0.15).buildFreeGygabytes(2.0)
				.buildListOfPrices(new CallPricesTypes(callsPrice))
				.buildParameters(parameter);
		temp.add(builder.getInstance());
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
		return "\nТарифы для интернета";
	}
	

}
