package eu.deltasource.internship.hotelserviceapplication.Support.BookingExceptions;

import eu.deltasource.internship.hotelserviceapplication.Support.BookingExceptions.domain.*;

public class UnbookingFailureException extends CustomBookingFailureException {
	public UnbookingFailureException() {
		super("Booking removal failed !");
	}
}
