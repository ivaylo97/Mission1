package hotelserviceapp.Support.DateExceptions;

import hotelserviceapp.Support.BookingExceptions.domain.CustomBookingFailureException;

public class OverlappingStartingDateException extends CustomBookingFailureException {
	public OverlappingStartingDateException() {
		super("Starting date overlaps with another date !");
	}
}
