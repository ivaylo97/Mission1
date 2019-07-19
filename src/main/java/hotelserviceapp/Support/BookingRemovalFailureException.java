package hotelserviceapp.Support;

import hotelserviceapp.Support.BookingFailureException.BookingFailureException;

public class BookingRemovalFailureException extends BookingFailureException {
	public BookingRemovalFailureException() {
		super("Booking removal failed !");
	}
}
