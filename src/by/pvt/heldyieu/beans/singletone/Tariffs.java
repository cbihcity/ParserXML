package by.pvt.heldyieu.beans.singletone;



public final class Tariffs {
	
	private TariffForInternet tariffForInternet;
	private TariffForCalls tariffForCalls;
	private static Tariffs tariffs;
	
	

	/**
	 * @return the tariffForInternet
	 */
	public TariffForInternet getTariffForInternet() {
		return tariffForInternet;
	}

	/**
	 * @return the tariffForCalls
	 */
	public TariffForCalls getTariffForCalls() {
		return tariffForCalls;
	}

	private Tariffs(){
		 tariffForInternet = TariffForInternet.getInstance();
		 tariffForCalls = TariffForCalls.getInstance();
	 }
	
	public static Tariffs getInstance(){
		if (tariffs == null) {
			tariffs = new Tariffs();
		} 
		return tariffs;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tariffs [tariffForInternet=" + tariffForInternet
				+ ", tariffForCalls=" + tariffForCalls + "]";
	}
	
}
