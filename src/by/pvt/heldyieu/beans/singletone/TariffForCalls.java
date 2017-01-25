package by.pvt.heldyieu.beans.singletone;

import java.util.ArrayList;
import java.util.List;

import by.pvt.heldyieu.beans.builders.TariffForCallsBuilder;
import by.pvt.heldyieu.beans.callprices.CallPrices;
import by.pvt.heldyieu.beans.callprices.CallPricesTypes;
import by.pvt.heldyieu.beans.callprices.InitCallPrices;
import by.pvt.heldyieu.beans.parameters.InitParameters;
import by.pvt.heldyieu.beans.parameters.Parameters;
import by.pvt.heldyieu.beans.tariff.Tariff;
import by.pvt.heldyieu.interfaces.Constants;

public class TariffForCalls implements Constants {
	
	private static TariffForCalls tariffForCalls;
	private ArrayList<Tariff> listOfTariff;

	
	/**
	 * @return the listOfTariff
	 */
	public ArrayList<Tariff> getListOfTariff() {
		return listOfTariff;
	}
	
	public void setListOfTariff(ArrayList<Tariff> listOfTariff) {
		this.listOfTariff = listOfTariff;
	}



	private TariffForCalls(){
		listOfTariff = createTariff();
	}
	
	private ArrayList<Tariff> createTariff() {
		ArrayList<Tariff> temp = new ArrayList<Tariff>();
		List<CallPrices> callsPrice = InitCallPrices.init(TARIFF_FOR_CALLS);
		Parameters parameter = InitParameters.init(TARIFF_FOR_CALLS);
		TariffForCallsBuilder builder = new TariffForCallsBuilder();
		builder.buildName("��������");builder.buildOperatorName("���");builder.buildPayroll(5.5);
		builder.buildSmsPrice(0.15);builder.buildFreeMinutes(200);
		builder.buildListOfPrices(new CallPricesTypes(callsPrice));
		builder.buildParameters(parameter);
		temp.add(builder.getInstance());
		return temp;
	}

	public static TariffForCalls getInstance() {
		if (tariffForCalls == null) {
			tariffForCalls = new TariffForCalls();
		}
		return tariffForCalls;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\n������ ��� �������";
	}
	
}
