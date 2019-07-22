package hotelserviceapp.Support;

import hotelserviceapp.Support.domain.AbstractException;

public class InvalidRoomNumberException extends AbstractException {
	public InvalidRoomNumberException() {
		super("Room number has negative / zero value!");
	}
}
