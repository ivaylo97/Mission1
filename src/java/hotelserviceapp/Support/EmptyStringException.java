package hotelserviceapp.Support;

import hotelserviceapp.Support.domain.AbstractExceptionClass;

public class EmptyStringException extends AbstractExceptionClass {
	EmptyStringException() {
		super("String is empty !");
	}

}
