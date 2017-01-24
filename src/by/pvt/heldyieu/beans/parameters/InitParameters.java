package by.pvt.heldyieu.beans.parameters;

public class InitParameters {

	public static Parameters init(String choice) {
		Parameters param =null;
		switch (choice) {
		case "tariffForCalls":
			param = new Parameters(3, "60sec", 3.0);
			break;

		case "tariffForInternet":
			param = new Parameters(2, "12sec", 2.0);
			break;
		}
		return param;
	}

}
