package hotelserviceapp.Support;

import hotelserviceapp.Support.domain.AbstractException;

import java.time.LocalDate;

public class InvalidValuesException extends AbstractException {
	public InvalidValuesException() {
		super("Date is before " + LocalDate.now().toString());
	}

	public InvalidValuesException(LocalDate from, LocalDate to) {
		super(from.toString() + "is after " + to.toString());
	}


}
