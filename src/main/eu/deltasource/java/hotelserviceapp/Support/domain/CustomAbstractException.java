package hotelserviceapp.Support.domain;

import java.security.InvalidParameterException;
import java.time.LocalDate;

public abstract class CustomAbstractException extends RuntimeException {
	public CustomAbstractException(String message) {
		throw new RuntimeException(message);
	}
}
