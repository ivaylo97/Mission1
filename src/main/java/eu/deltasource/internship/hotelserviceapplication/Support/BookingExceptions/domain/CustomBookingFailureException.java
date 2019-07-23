package eu.deltasource.internship.hotelserviceapplication.Support.BookingExceptions.domain;

import eu.deltasource.internship.hotelserviceapplication.Support.domain.CustomAbstractException;

public class CustomBookingFailureException extends CustomAbstractException {
	public CustomBookingFailureException(String message) {
		super(message);
	}
}
