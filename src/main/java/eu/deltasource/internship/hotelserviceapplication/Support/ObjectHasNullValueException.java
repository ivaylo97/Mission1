package eu.deltasource.internship.hotelserviceapplication.Support;

import eu.deltasource.internship.hotelserviceapplication.Support.domain.CustomAbstractException;

/**
 * Extends the CustomAbstractException class.
 * If such an exception is thrown it indicates that the specified in the message object has null value.
 * It passes that message to its base class through it's constructor invoking the base class' constructor.
 */
public class ObjectHasNullValueException extends CustomAbstractException {
	public ObjectHasNullValueException(String message) {
		super(message);
	}
}
