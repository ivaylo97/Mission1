package hotelserviceapp.Support.domain;
import java.security.InvalidParameterException;
import java.time.LocalDate;
public abstract class AbstractExceptionClass extends RuntimeException {
	public AbstractExceptionClass(String message){
		throw new RuntimeException(message);
	}
}
