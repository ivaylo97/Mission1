package eu.deltasource.internship.hotelserviceapplication.Support.BookingExceptions;

import eu.deltasource.internship.hotelserviceapplication.Support.BookingExceptions.domain.*;

public class BookingAlreadyExistsException extends CustomBookingFailureException {
	public BookingAlreadyExistsException() {
		super("The booking already exists !");
	}
}
