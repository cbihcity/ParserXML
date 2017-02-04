package by.pvt.heldyieu.beans.callprices;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.pvt.heldyieu.exceptions.InvalidValueException;
import by.pvt.heldyieu.interfaces.Constants;

public class InitCallPrices implements Constants {
	private static final Logger logger = Logger.getLogger(InitCallPrices.class.getName());

	public static List<CallPrices> init(String choice) {
		
		ArrayList<CallPrices> list = new ArrayList<CallPrices>();
		switch (choice){
		case TARIFF_FOR_CALLS_CHOICE:
			try {
				list.add(new CallPrices((byte) 1, "inside-network", 1.5));
				list.add(new CallPrices((byte) 2, "outside-network", 2.5));
				list.add(new CallPrices((byte) 3, "state-calls", 3.5));
			} catch (InvalidValueException e) {
				logger.error(e.getMessage());
			}
			break;
		case TARIFF_FOR_INERNET_CHOICE:
			try {
				list.add(new CallPrices((byte) 1, "inside-network", 2.5));
				list.add(new CallPrices((byte) 2, "outside-network", 3.5));
				list.add(new CallPrices((byte) 3, "state-calls", 4.5));
			} catch (InvalidValueException e) {
				logger.error(e.getMessage());
			}
			break;
		}
		return list;
	}
}
