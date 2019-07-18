package hotelserviceapp.Support;

import hotelserviceapp.Support.domain.AbstractExceptionClass;

public class InvalidValueIDException extends AbstractExceptionClass {
	 public InvalidValueIDException(){
		super("ID has invalid value !");
	}

}
