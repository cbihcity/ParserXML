package by.pvt.heldyieu.beans.callprices;

import java.util.List;


public class CallPricesTypes {
	 protected List<CallPrices> listOfPrices;

	/**
	 * 
	 */
	public CallPricesTypes() {
		super();
	}

	/**
	 * @param listOfPrices
	 */
	public CallPricesTypes(List<CallPrices> listOfPrices) {
		super();
		this.listOfPrices = listOfPrices;
	}

	/**
	 * @return the listOfPrices
	 */
	public List<CallPrices> getListOfPrices() {
		return listOfPrices;
	}

	/**
	 * @param listOfPrices the listOfPrices to set
	 */
	public void setListOfPrices(List<CallPrices> listOfPrices) {
		this.listOfPrices = listOfPrices;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((listOfPrices == null) ? 0 : listOfPrices.hashCode());
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
		if (!(obj instanceof CallPricesTypes)) {
			return false;
		}
		CallPricesTypes other = (CallPricesTypes) obj;
		if (listOfPrices == null) {
			if (other.listOfPrices != null) {
				return false;
			}
		} else if (!listOfPrices.equals(other.listOfPrices)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CallPricesTypes [listOfPrices=" + listOfPrices + "]";
	}
	 
	
	 
}
