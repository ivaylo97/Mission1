package eu.deltasource.internship.hotelserviceapplication.Support.domain;

/**
 * This class extends the RuntimeException class , and acts as a base class to all of the
 * projects' custom exceptions.
 */
public abstract class CustomAbstractException extends RuntimeException {
	public CustomAbstractException(String message) {
		throw new RuntimeException(message);
	}
}
