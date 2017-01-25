package by.pvt.heldyieu.beans.callprices;

import java.util.ArrayList;
import java.util.List;

public class InitCallPrices {

	public static List<CallPrices> init(String choice) {
		ArrayList<CallPrices> list = new ArrayList<CallPrices>();
		switch (choice){
		case "tariffForCalls":
			list.add(new CallPrices((byte) 1, "inside-network", 1.5));
			list.add(new CallPrices((byte) 2, "outside-network", 2.5));
			list.add(new CallPrices((byte) 3, "state-calls", 3.5));
			break;
		case "tariffForInternet":
			list.add(new CallPrices((byte) 1, "inside-network", 2.5));
			list.add(new CallPrices((byte) 2, "outside-network", 3.5));
			list.add(new CallPrices((byte) 3, "state-calls", 4.5));
			break;
		}
		return list;
	}
}
