package eu.deltasource.internship.hotelserviceapplication.Support;

import eu.deltasource.internship.hotelserviceapplication.Support.domain.CustomAbstractException;

/**
 * Extends the CustomAbstractException class.
 * If such an exception is thrown , it indicates that an operation including bookings has failed due to the reason
 * specified in the message.
 * It passes that message to its base class through it's constructor invoking the base class' constructor.
 */
public class BookingFailureException extends CustomAbstractException {
	public BookingFailureException(String message) {
		super(message);
	}
}
