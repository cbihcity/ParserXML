package by.pvt.heldyieu.parsers.builders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import org.apache.log4j.Logger;
import by.pvt.heldyieu.beans.singletone.TariffForCalls;
import by.pvt.heldyieu.beans.singletone.TariffForInternet;
import by.pvt.heldyieu.interfaces.Constants;
import by.pvt.heldyieu.parsers.tools.OperationsStAXParsers;

public class TariffsStAXBuilder extends AbstractTariffsBuilder implements Constants {
	private static final Logger logger = Logger.getLogger(OperationsStAXParsers.class.getName());

	public TariffForCalls getTariffForCalls() {
		return tariffForCalls;
	}

	public TariffForInternet getTariffForInternet() {
		return tariffForInternet;
	}

	@Override
	public void buildTariffs(String filename) {
		logger.info("Create OperationsStAXParsers entity");
		OperationsStAXParsers tariffsParsers = new OperationsStAXParsers();
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(filename);
			logger.info("Start to parse...");
			tariffsParsers.buildTariffsParser(inputStream);
			
			logger.info("Get list of Internet tariffs");
			tariffForInternet.setListOfTariff(tariffsParsers
					.getCurrentTariffForInternet().getListOfTariff());
			
			logger.info("Get list of Calls tariffs");
			tariffForCalls.setListOfTariff(tariffsParsers
					.getCurrentTariffForCalls().getListOfTariff());
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		}
	}
}