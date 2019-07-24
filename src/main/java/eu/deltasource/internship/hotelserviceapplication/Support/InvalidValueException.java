package eu.deltasource.internship.hotelserviceapplication.Support;

import eu.deltasource.internship.hotelserviceapplication.Support.domain.CustomAbstractException;

/**
 *  Extends the CustomAbstractException class.
 *  If such an exception is thrown , it indicates that the specified in the message variable has an invalid for it's
 *  purpose value.
 *  It passes that message to the base class through invoking the base class' constructor in it's own constructor.
 */
public class InvalidValueException extends CustomAbstractException {
	public InvalidValueException(String message) {
		super(message);
	}
}
