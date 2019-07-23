package eu.deltasource.internship.hotelserviceapplication.Support.DateExceptions;

import eu.deltasource.internship.hotelserviceapplication.Support.domain.CustomAbstractException;

//todo javadoc and remove most of the exceptions, use generalized exceptions
public class InvalidValuesException extends CustomAbstractException {
	public InvalidValuesException(String message) {
		super(message);
	}
}
