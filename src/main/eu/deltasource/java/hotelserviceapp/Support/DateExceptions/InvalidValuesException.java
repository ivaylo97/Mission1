package hotelserviceapp.Support.DateExceptions;

import hotelserviceapp.Support.domain.CustomAbstractException;

import java.time.LocalDate;

public class InvalidValuesException extends CustomAbstractException {
	public InvalidValuesException() {
		super("Date is before " + LocalDate.now().toString());
	}

	public InvalidValuesException(LocalDate from, LocalDate to) {
		super(from.toString() + "is after " + to.toString());
	}


}
