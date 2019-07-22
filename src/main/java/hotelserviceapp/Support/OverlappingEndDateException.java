package hotelserviceapp.Support;

import hotelserviceapp.Support.BookingFailureException.BookingFailureException;

public class OverlappingEndDateException extends BookingFailureException {
	public OverlappingEndDateException() {
		super("End date overlaps with another ,already existing , date !");
	}
}
