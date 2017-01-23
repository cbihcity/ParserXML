package by.pvt.heldyieu.beans.tariffs;

import java.util.Comparator;

import by.pvt.heldyieu.beans.callprices.CallPricesTypes;
import by.pvt.heldyieu.beans.parameters.Parameters;




public class Tariff implements Comparator<Tariff> {

	protected String name;
    protected String operatorName;
    protected double payroll;
    protected CallPricesTypes callPrices;
    protected double smsPrice;
    protected Parameters parameters;
    
	public Tariff() {
		super();
	}


	/**
	 * @param name
	 * @param operatorName
	 * @param payroll
	 * @param callPrices
	 * @param smsPrice
	 * @param parameters
	 */
	public Tariff(String name, String operatorName, double payroll,
			CallPricesTypes callPrices, double smsPrice, Parameters parameters) {
		super();
		this.name = name;
		this.operatorName = operatorName;
		this.payroll = payroll;
		this.callPrices = callPrices;
		this.smsPrice = smsPrice;
		this.parameters = parameters;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the operatorName
	 */
	public String getOperatorName() {
		return operatorName;
	}


	/**
	 * @param operatorName the operatorName to set
	 */
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}


	/**
	 * @return the payroll
	 */
	public double getPayroll() {
		return payroll;
	}


	/**
	 * @param payroll the payroll to set
	 */
	public void setPayroll(double payroll) {
		this.payroll = payroll;
	}


	/**
	 * @return the callPrices
	 */
	public CallPricesTypes getCallPrices() {
		return callPrices;
	}


	/**
	 * @param callPrices the callPrices to set
	 */
	public void setCallPrices(CallPricesTypes callPrices) {
		this.callPrices = callPrices;
	}


	/**
	 * @return the smsPrice
	 */
	public double getSmsPrice() {
		return smsPrice;
	}


	/**
	 * @param smsPrice the smsPrice to set
	 */
	public void setSmsPrice(double smsPrice) {
		this.smsPrice = smsPrice;
	}


	/**
	 * @return the parameters
	 */
	public Parameters getParameters() {
		return parameters;
	}


	/**
	 * @param parameters the parameters to set
	 */
	public void setParameters(Parameters parameters) {
		this.parameters = parameters;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((callPrices == null) ? 0 : callPrices.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((operatorName == null) ? 0 : operatorName.hashCode());
		result = prime * result
				+ ((parameters == null) ? 0 : parameters.hashCode());
		long temp;
		temp = Double.doubleToLongBits(payroll);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(smsPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Tariff)) {
			return false;
		}
		Tariff other = (Tariff) obj;
		if (callPrices == null) {
			if (other.callPrices != null) {
				return false;
			}
		} else if (!callPrices.equals(other.callPrices)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (operatorName == null) {
			if (other.operatorName != null) {
				return false;
			}
		} else if (!operatorName.equals(other.operatorName)) {
			return false;
		}
		if (parameters == null) {
			if (other.parameters != null) {
				return false;
			}
		} else if (!parameters.equals(other.parameters)) {
			return false;
		}
		if (Double.doubleToLongBits(payroll) != Double
				.doubleToLongBits(other.payroll)) {
			return false;
		}
		if (Double.doubleToLongBits(smsPrice) != Double
				.doubleToLongBits(other.smsPrice)) {
			return false;
		}
		return true;
	}


	@Override
	public int compare(Tariff tariff1, Tariff tariff2) {
		return Double.compare(tariff1.getPayroll(), tariff2.getPayroll());
	}
}
