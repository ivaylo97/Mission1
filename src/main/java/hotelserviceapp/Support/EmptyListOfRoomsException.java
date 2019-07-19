package hotelserviceapp.Support;

import hotelserviceapp.Support.domain.AbstractException;

public class EmptyListOfRoomsException extends AbstractException {
	public EmptyListOfRoomsException() {
		super("List of rooms is empty !");
	}
}
