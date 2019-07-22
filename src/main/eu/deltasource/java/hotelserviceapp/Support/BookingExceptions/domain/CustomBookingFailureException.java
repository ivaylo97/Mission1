package hotelserviceapp.Support.BookingExceptions.domain;

import hotelserviceapp.Support.domain.CustomAbstractException;

public class CustomBookingFailureException extends CustomAbstractException {
	public CustomBookingFailureException(String message) {
		super(message);
	}
}
