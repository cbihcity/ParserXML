package by.pvt.heldyieu.beans.callprices;


public class CallPrices {
	    protected byte id;
	    protected String name;
	    protected double cost;
		/**
		 * 
		 */
		public CallPrices() {
			super();
		}
		/**
		 * @param id
		 * @param name
		 * @param cost
		 */
		public CallPrices(byte id, String name, double cost) {
			super();
			this.id = id;
			this.name = name;
			this.cost = cost;
		}
		/**
		 * @return the id
		 */
		public byte getId() {
			return id;
		}
		/**
		 * @param id the id to set
		 */
		public void setId(byte id) {
			this.id = id;
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
		 * @return the cost
		 */
		public double getCost() {
			return cost;
		}
		/**
		 * @param cost the cost to set
		 */
		public void setCost(double cost) {
			this.cost = cost;
		}
		
		/* (non-Javadoc)
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
			if (!(obj instanceof CallPrices)) {
				return false;
			}
			CallPrices other = (CallPrices) obj;
			if (Double.doubleToLongBits(cost) != Double
					.doubleToLongBits(other.cost)) {
				return false;
			}
			if (id != other.id) {
				return false;
			}
			if (name == null) {
				if (other.name != null) {
					return false;
				}
			} else if (!name.equals(other.name)) {
				return false;
			}
			return true;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "CallPrices [id=" + id + ", name=" + name + ", cost=" + cost
					+ "]";
		}
	    
}