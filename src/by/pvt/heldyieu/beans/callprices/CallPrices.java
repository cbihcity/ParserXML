package by.pvt.heldyieu.beans.callprices;

import by.pvt.heldyieu.exceptions.InvalidValueException;

public class CallPrices {
	protected byte id;
	protected String name;
	protected double cost;

	public CallPrices() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 * @param cost
	 * @throws InvalidValueException
	 */
	public CallPrices(byte id, String name, double cost)
			throws InvalidValueException {
		super();
		if (id < 0 || name == null || cost < 0) {
			throw new InvalidValueException(
					"Объект класса " + this.getClass().getName() + " не создан.");
		} else {
			this.id = id;
			this.name = name;
			this.cost = cost;
		}
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * @param cost
	 *            the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	/**
	 * @return the id
	 */
	public byte getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(byte id) {
		this.id = id;
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
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CallPrices other = (CallPrices) obj;
		if (Double.doubleToLongBits(cost) != Double
				.doubleToLongBits(other.cost))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name + ":" + cost;
	}

}
