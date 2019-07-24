package eu.deltasource.internship.hotelserviceapplication.Support;

import eu.deltasource.internship.hotelserviceapplication.Support.domain.CustomAbstractException;

/**
 * Extends the CustomAbstractException class.
 * If such an exception is thrown , it indicates that the specified in the message list is empty.
 * It passes the message to it's base class through invoking the base class' constructor in its own constructor.
 */
public class EmptyListException extends CustomAbstractException {
	public EmptyListException(String message ) {
		super(message);
	}
}
