package hotelserviceapp.Support.BookingExceptions;

import hotelserviceapp.Support.BookingExceptions.domain.CustomBookingFailureException;

public class UnbookingFailureException extends CustomBookingFailureException {
	public UnbookingFailureException() {
		super("Unbooking room failed !");
	}
}
