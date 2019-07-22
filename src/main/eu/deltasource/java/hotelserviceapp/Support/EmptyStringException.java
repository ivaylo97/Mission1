package hotelserviceapp.Support;

import hotelserviceapp.Support.domain.CustomAbstractException;

public class EmptyStringException extends CustomAbstractException {
	public EmptyStringException() {
		super("String is empty !");
	}

}
