package hotelserviceapp.main;

import java.rmi.server.UID;

import hotelserviceapp.sources.*;


import java.time.LocalDate;


public class HotelServiceApplication {

	public static void main(String[] args) {



		for (int idx = 0; idx < 10; ++idx) {
			UID userId = new UID();
			System.out.println("User Id: " + userId);


		}
		System.out.println(" ");
		for (int idx = 0; idx < 1000000; ++idx) {
			UID userId = new UID();
			System.out.println("User Id: " + userId);


		}

		/**
		 * Helper method used to parse a string to a local date.
		 *
		 * @param date String type variable which represents the date that is to be parsed.
		 * @return LocalDate.parse(date);
		 * Returns the date in local date format.
		 */
	}

	static LocalDate configureDate(String date) {
		return LocalDate.parse(date);
	}

}
