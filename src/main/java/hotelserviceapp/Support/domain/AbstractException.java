package hotelserviceapp.Support.domain;

import java.security.InvalidParameterException;
import java.time.LocalDate;

public abstract class AbstractException extends RuntimeException {
	public AbstractException(String message) {
		throw new RuntimeException(message);
	}
}
