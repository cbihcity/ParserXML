package by.pvt.heldyieu.builders;

import org.apache.log4j.Logger;
import by.pvt.heldyieu.beans.tariff.Tariff;
import by.pvt.heldyieu.exceptions.InvalidValueException;

public class TariffForCallsBuilder extends AbstractTariffBuilder{
private static final Logger logger = Logger.getLogger(TariffForCallsBuilder.class.getName());
	
	public Tariff getTariff(){
		tariffCreate();
		return tariff;
	}
	
	public TariffForCallsBuilder freeMinutes(int freeMinutes) {
		this.freeMinutes = freeMinutes;
		return this;
	}

	@Override
	protected boolean tariffIsValid() {
		if (name == null || operatorName == null 
				|| payroll == 0
				|| callPrices == null 
				|| smsPrice == 0 
				|| freeMinutes == 0
				|| parameters == null) {
			return false;
		}
		return true;
	}

	@Override
	protected void cleanTariffInstance() {
		{
			name = null;
			operatorName = null;
			payroll = 0;
			callPrices = null;
			smsPrice = 0;
			freeMinutes = 0;
			parameters = null;
			freeGygabytes = 0;
	    }
	}
	
	protected void tariffCreate() {
		if (tariffIsValid()) {
			try {
				tariff = new Tariff(name, operatorName, payroll, callPrices,
						smsPrice, freeGygabytes, freeMinutes, parameters);
			} catch (InvalidValueException e) {
				logger.error(e.getMessage());
			}
			cleanTariffInstance();
		} 
	}
}
