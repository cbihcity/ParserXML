package by.pvt.heldyieu.exceptions;

public class InvalidValueException extends Exception {
private static final long serialVersionUID = 4081837278749194746L;
	
	public InvalidValueException() {
		super();
	}

	public InvalidValueException(final String message) {
		super(message);
	}
	
	public InvalidValueException(final String message, String value) {
		super(message+"Некорректный параметр : " + value);
	}
}
