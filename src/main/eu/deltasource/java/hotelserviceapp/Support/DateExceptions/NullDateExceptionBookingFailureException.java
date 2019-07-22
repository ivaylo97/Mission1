package hotelserviceapp.Support.DateExceptions;

import hotelserviceapp.Support.BookingExceptions.domain.CustomBookingFailureException;

public class NullDateExceptionBookingFailureException extends CustomBookingFailureException {
	public NullDateExceptionBookingFailureException() {
		super("Date has null value !");
	}
}
