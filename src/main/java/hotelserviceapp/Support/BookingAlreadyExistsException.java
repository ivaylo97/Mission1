package hotelserviceapp.Support;

import hotelserviceapp.Support.BookingFailureException.BookingFailureException;

public class BookingAlreadyExistsException extends BookingFailureException {
	public BookingAlreadyExistsException() {
		super("The booking already exists !");
	}
}
