package hotelserviceapp.Support;

import hotelserviceapp.Support.domain.CustomAbstractException;

public class InvalidValueIDException extends CustomAbstractException {
	public InvalidValueIDException() {
		super("ID has invalid value !");
	}

}
