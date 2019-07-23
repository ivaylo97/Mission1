package eu.deltasource.internship.hotelserviceapplication.Support.BookingExceptions;

import eu.deltasource.internship.hotelserviceapplication.Support.BookingExceptions.domain.*;

public class BookingFailureException extends CustomBookingFailureException {
	public BookingFailureException() {
		super("Booking creation failed !");
	}
}
