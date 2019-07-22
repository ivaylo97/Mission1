package hotelserviceapp.Support;

import hotelserviceapp.Support.domain.CustomAbstractException;

public class InvalidRoomNumberException extends CustomAbstractException {
	public InvalidRoomNumberException() {
		super("Room number has negative / zero value!");
	}
}
