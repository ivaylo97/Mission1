package eu.deltasource.internship.hotelserviceapplication.Support;

import eu.deltasource.internship.hotelserviceapplication.Support.domain.CustomAbstractException;

public class EmptyStringException extends CustomAbstractException {
	public EmptyStringException(String message) {
		super(message + " is empty !");
	}

}
