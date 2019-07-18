package hotelserviceapp.Support;

import hotelserviceapp.Support.domain.AbstractExceptionClass;

public class NullValueIdException extends AbstractExceptionClass {
	public NullValueIdException(){
		super("ID has null value !");
	}
}
