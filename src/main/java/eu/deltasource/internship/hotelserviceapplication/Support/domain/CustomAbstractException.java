package eu.deltasource.internship.hotelserviceapplication.Support.domain;

//TODO :: Make Exceptions less case specific
public abstract class CustomAbstractException extends RuntimeException {
	public CustomAbstractException(String message) {
		throw new RuntimeException(message);
	}
}
