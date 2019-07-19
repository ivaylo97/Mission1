package hotelserviceapp.Support;

import hotelserviceapp.Support.domain.AbstractException;

public class InvalidValueIDException extends AbstractException {
	public InvalidValueIDException() {
		super("ID has invalid value !");
	}

}
