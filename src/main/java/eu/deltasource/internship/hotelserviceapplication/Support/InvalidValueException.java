package eu.deltasource.internship.hotelserviceapplication.Support;

import eu.deltasource.internship.hotelserviceapplication.Support.domain.CustomAbstractException;

public class InvalidValueException extends CustomAbstractException {
	public InvalidValueException(String message) {
		super(message);
	}
}
