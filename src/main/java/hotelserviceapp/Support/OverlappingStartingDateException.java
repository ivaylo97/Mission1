package hotelserviceapp.Support;

import hotelserviceapp.Support.BookingFailureException.BookingFailureException;

public class OverlappingStartingDateException extends BookingFailureException {
	public OverlappingStartingDateException() {
		super("Starting date overlaps with another date !");
	}
}
