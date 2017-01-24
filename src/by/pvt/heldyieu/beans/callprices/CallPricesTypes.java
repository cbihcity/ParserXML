package by.pvt.heldyieu.beans.callprices;

import java.util.List;


public class CallPricesTypes {
	 protected List<CallPrices> prices;
	 
	/**
	 * 
	 */
	public CallPricesTypes() {
		super();
	}

	/**
	 * @param prices
	 */
	public CallPricesTypes(List<CallPrices> prices) {
		super();
		this.prices = prices;
	}

	/**
	 * @return the prices
	 */
	public List<CallPrices> getPrices() {
		return prices;
	}

	/**
	 * @param prices the prices to set
	 */
	public void setPrices(List<CallPrices> prices) {
		this.prices = prices;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		prices.forEach(item->sb.append(item.getName()+" - "+item.getCost()+", "));
		return "разновидность стоимости звонков : "+ sb;
	}

	
}
