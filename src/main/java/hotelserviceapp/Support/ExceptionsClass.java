package hotelserviceapp.Support;

import java.security.InvalidParameterException;
import java.time.LocalDate;

public class ExceptionsClass  extends RuntimeException{
	public RuntimeException nullValueException(){
		return new NullPointerException(" Date variable has null value !");
	}

	public RuntimeException invalidValuesException (LocalDate fromDate ,LocalDate toDate){
		return new InvalidParameterException(fromDate+" is after "+toDate+"!");
	}

	public RuntimeException invalidValuesException(LocalDate Date){
		return  new InvalidParameterException(Date+" is before "+LocalDate.now()+".");
	}
}
