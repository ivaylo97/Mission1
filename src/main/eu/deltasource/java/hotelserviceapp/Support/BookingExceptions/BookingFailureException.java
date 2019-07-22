package hotelserviceapp.Support.BookingExceptions;

import hotelserviceapp.Support.BookingExceptions.domain.CustomBookingFailureException;

public class BookingFailureException extends CustomBookingFailureException {
	public BookingFailureException() {
		super("Booking removal failed !");
	}
}
