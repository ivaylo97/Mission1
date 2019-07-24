package eu.deltasource.internship.hotelserviceapplication.Support;

import eu.deltasource.internship.hotelserviceapplication.Support.domain.CustomAbstractException;


/**
 * Extends the CustomAbstractException class.
 * If such an exception is thrown , it indicates that the specified in the message string is empty.
 * It passes the message to it's base class through invoking the base class' constructor in it's own constructor.
 */
public class EmptyStringException extends CustomAbstractException {
	public EmptyStringException(String message) {
		super(message + " is empty !");
	}

}
