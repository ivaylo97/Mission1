package hotelserviceapp.Support;

import hotelserviceapp.Support.domain.AbstractException;

public class EmptyStringException extends AbstractException {
	EmptyStringException() {
		super("String is empty !");
	}

}
