package hotelserviceapp.Support.DateExceptions;

import hotelserviceapp.Support.BookingExceptions.domain.CustomBookingFailureException;

public class OverlappingEndDateException extends CustomBookingFailureException {
	public OverlappingEndDateException() {
		super("End date overlaps with another ,already existing , date !");
	}
}
