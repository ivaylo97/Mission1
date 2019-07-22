package hotelserviceapp.Support;

import hotelserviceapp.Support.domain.CustomAbstractException;

public class NullHotelException extends CustomAbstractException {
	public NullHotelException() {
		super("Hotel variable has null value !");
	}
}
