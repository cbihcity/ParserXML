package by.pvt.heldyieu.beans.tariffs;

import java.util.ArrayList;

public class Tariffs {
	
	private ArrayList <Tariff> listOfTariffs;

	public Tariffs() {
		super();
	}

	public Tariffs(ArrayList<Tariff> listOfTariffs) {
		super();
		this.listOfTariffs = listOfTariffs;
	}

	public ArrayList<Tariff> getListOfTariffs() {
		return listOfTariffs;
	}

	public void setListOfTariffs(ArrayList<Tariff> listOfTariffs) {
		this.listOfTariffs = listOfTariffs;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tariffs [listOfTariffs=" + listOfTariffs + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((listOfTariffs == null) ? 0 : listOfTariffs.hashCode());
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
		if (!(obj instanceof Tariffs)) {
			return false;
		}
		Tariffs other = (Tariffs) obj;
		if (listOfTariffs == null) {
			if (other.listOfTariffs != null) {
				return false;
			}
		} else if (!listOfTariffs.equals(other.listOfTariffs)) {
			return false;
		}
		return true;
	}
	
}
