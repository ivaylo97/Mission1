package eu.deltasource.internship.hotelserviceapplication.Support;

import eu.deltasource.internship.hotelserviceapplication.Support.domain.CustomAbstractException;

/**
 * Extends the CustomAbstractException class.
 * If such an exception is thrown it indicates that the specified in the message object already exists ,or
 * is present in the (also specified in the message ) set.
 * It passes the message to it's base class through invoking the base class' constructor in it's own constructor.
 */
public class ObjectIsAlreadyPresentException extends CustomAbstractException {
	public ObjectIsAlreadyPresentException(String message){
		super(message);
	}
}
