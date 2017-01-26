package by.pvt.heldyieu.parsers.enums;

public enum TariffsEnum {

	TARIFF("tariff"),
	NAME("name"),
	OPERATOR_NAME("operator-name"),
	PAYROLL("payroll"),
	SMS_PRICE("sms-price"),
	FREE_GB("free-gygabytes"),
	FREE_MINUTES("free-minutes"),
	CALL_PRICES("call-prices"),
	ID("id"),
	CALL_NAME("name"),
	COST("cost"),
	PARAMETERS("parameters"),
	FAVOURITE_NUMBER("favourite-number"),
	SUBSCRIBE_COST("subscribe-cost"),
	TARIFICATION("tariffication");
	
	private String value;

	private TariffsEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
