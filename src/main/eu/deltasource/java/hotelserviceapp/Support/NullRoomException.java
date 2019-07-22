package hotelserviceapp.Support;

import hotelserviceapp.Support.domain.CustomAbstractException;

public class NullRoomException extends CustomAbstractException {
	public NullRoomException() {
		super("Room has null value !");
	}
}
