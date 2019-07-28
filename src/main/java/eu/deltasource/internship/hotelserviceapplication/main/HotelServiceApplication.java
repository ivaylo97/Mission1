package eu.deltasource.internship.hotelserviceapplication.main;
import java.time.LocalDate;

public class HotelServiceApplication {

	public static void main(String[] args) {

	}

	/**
	 * Helper method used to parse a string to a local date.
	 *
	 * @param date String type variable which represents the date that is to be parsed.
	 * @return LocalDate.parse(date);
	 * Returns the date in local date format.
	 */

	static LocalDate configureDate(String date) {
		return LocalDate.parse(date);
	}

}
