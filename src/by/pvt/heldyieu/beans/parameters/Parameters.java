package by.pvt.heldyieu.beans.parameters;

import by.pvt.heldyieu.interfaces.Constants;

public class Parameters implements Constants {
	protected double favouriteNumber;
	protected String tariffication;
	protected double subscribeCost;

	/**
		 * 
		 */
	public Parameters() {
		super();
	}

	/**
	 * @param favouriteNumber
	 * @param tariffication
	 * @param subscribeCost
	 */
	public Parameters(double favouriteNumber, String tariffication,
			double subscribeCost) {
		super();
		this.favouriteNumber = favouriteNumber;
		this.tariffication = tariffication;
		this.subscribeCost = subscribeCost;
	}

	/**
	 * @return the favouriteNumber
	 */
	public double getFavouriteNumber() {
		return favouriteNumber;
	}

	/**
	 * @param favouriteNumber
	 *            the favouriteNumber to set
	 */
	public void setFavouriteNumber(double favouriteNumber) {
		this.favouriteNumber = favouriteNumber;
	}

	/**
	 * @return the tariffication
	 */
	public String getTariffication() {
		return tariffication;
	}

	/**
	 * @param tariffication
	 *            the tariffication to set
	 */
	public void setTariffication(String tariffication) {
		this.tariffication = tariffication;
	}

	/**
	 * @return the subscribeCost
	 */
	public double getSubscribeCost() {
		return subscribeCost;
	}

	/**
	 * @param subscribeCost
	 *            the subscribeCost to set
	 */
	public void setSubscribeCost(double subscribeCost) {
		this.subscribeCost = subscribeCost;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(favouriteNumber);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(subscribeCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((tariffication == null) ? 0 : tariffication.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		if (!(obj instanceof Parameters)) {
			return false;
		}
		Parameters other = (Parameters) obj;
		if (Double.doubleToLongBits(favouriteNumber) != Double
				.doubleToLongBits(other.favouriteNumber)) {
			return false;
		}
		if (Double.doubleToLongBits(subscribeCost) != Double
				.doubleToLongBits(other.subscribeCost)) {
			return false;
		}
		if (tariffication == null) {
			if (other.tariffication != null) {
				return false;
			}
		} else if (!tariffication.equals(other.tariffication)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "количество любимых номеров : " + favouriteNumber
				+ "\nрежим тарификации : " + tariffication
				+ "\nстоимость подписки : " + subscribeCost + "\n" +DELIMITER;
	}
}
