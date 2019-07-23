package eu.deltasource.internship.hotelserviceapplication.Support;

import eu.deltasource.internship.hotelserviceapplication.Support.domain.CustomAbstractException;

public class NullObjectException extends CustomAbstractException {
	public NullObjectException(String message) {
		super(message);
	}
}
