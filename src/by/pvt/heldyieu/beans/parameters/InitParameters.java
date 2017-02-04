package by.pvt.heldyieu.beans.parameters;

import org.apache.log4j.Logger;

import by.pvt.heldyieu.exceptions.InvalidValueException;
import by.pvt.heldyieu.interfaces.Constants;

public class InitParameters implements Constants {
	private static final Logger logger = Logger.getLogger(InitParameters.class.getName());

	public static Parameters init(String choice) {
		Parameters param =null;
		switch (choice) {
		case TARIFF_FOR_CALLS:
			try {
				param = new Parameters(3, "60sec", 3.0);
			} catch (InvalidValueException e) {
				logger.error(e.getMessage());
			}
			break;

		case TARIFF_FOR_INERNET_CHOICE:
			try {
				param = new Parameters(2, "12sec", 2.0);
			} catch (InvalidValueException e) {
				logger.error(e.getMessage());
			}
			break;
		}
		return param;
	}

}
