package hotelserviceapp.Support.BookingExceptions;

import hotelserviceapp.Support.BookingExceptions.domain.CustomBookingFailureException;

public class BookingAlreadyExistsException extends CustomBookingFailureException {
	public BookingAlreadyExistsException() {
		super("The booking already exists !");
	}
}
