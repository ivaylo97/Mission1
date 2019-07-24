package eu.deltasource.internship.hotelserviceapplication.Support.DateExceptions;

import eu.deltasource.internship.hotelserviceapplication.Support.domain.CustomAbstractException;

/**
 * OverlappingDateException class extends the CustomAbstractExceptions class.
 * If such an Exception is trolled , it indicates that one or more of the dates overlaps with other dates.
 */
public class OverlappingDateException extends CustomAbstractException {
	public OverlappingDateException(String message) {
		super(message);
	}
}
