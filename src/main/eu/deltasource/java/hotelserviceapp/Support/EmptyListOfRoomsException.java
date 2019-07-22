package hotelserviceapp.Support;

import hotelserviceapp.Support.domain.CustomAbstractException;

public class EmptyListOfRoomsException extends CustomAbstractException {
	public EmptyListOfRoomsException() {
		super("List of rooms is empty !");
	}
}
