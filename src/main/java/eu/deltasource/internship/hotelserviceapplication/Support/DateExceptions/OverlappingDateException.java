package eu.deltasource.internship.hotelserviceapplication.Support.DateExceptions;

import eu.deltasource.internship.hotelserviceapplication.Support.BookingExceptions.domain.CustomBookingFailureException;

public class OverlappingDateException extends CustomBookingFailureException {
	public OverlappingDateException(String message) {
		super(message+" overlaps with another date !");
	}
}
