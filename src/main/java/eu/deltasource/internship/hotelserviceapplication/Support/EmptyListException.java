package eu.deltasource.internship.hotelserviceapplication.Support;

import eu.deltasource.internship.hotelserviceapplication.Support.domain.CustomAbstractException;

public class EmptyListException extends CustomAbstractException {
	public EmptyListException(String message ) {
		super(message);
	}
}
