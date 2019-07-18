package hotelserviceapp.sources;

import hotelserviceapp.Support.domain.AbstractExceptionClass;

import java.time.LocalDate;
import java.util.*;

public class Manager {

	private String hotelName;
	private String managerName;
	private Hotel managedHotel;


	/**
	 * @return
	 * Returns the manager's name.
	 */

	String getManagerName() {
		return managerName;
	}

	void setManagerName(String newManagerName) {
		managerName = newManagerName;
	}

	/**
	 * This method takes a Hotel object as a formal parameter which is later used to set the values of the managedHotel
	 * and the hotelName variables.
	 *
	 * @param newHotel
	 * Represents the hotel that is going to be managed.
	 */
	public void setHotel(Hotel newHotel) {
		if (newHotel != null) {
			managedHotel = newHotel;
			hotelName = newHotel.getHotelName();
		} else {
			//throw AbstractExceptionClass.nullHotelException();
		}
	}

	/**
	 * This method takes everything required to make a booking as parameters,then searches for all rooms that
	 * have the required number of bed , and lastly checks every room in the list of rooms whether it is available
	 * in the specified dates ,starting from the first one.
	 *
	 * @param guestEGN             String - Contains the guest's EGN.
	 * @param fromDate             LocalDate  - represents the booking's start date.
	 * @param toDate               LocalDate - represents the booking's end date.
	 * @param numberOfRequiredBeds int - represents the number of required beds from the guest.
	 * @param numberOfDays         int - represents how long the booking will last in number of days.
	 * @return Returns boolean answer on whether the booking was successful.
	 */
	public int bookRoom(String guestEGN, LocalDate fromDate, LocalDate toDate, int numberOfRequiredBeds, int numberOfDays) {
		List<Rooms> listOfRooms = managedHotel.searchForRooms(numberOfRequiredBeds);
		int roomNumber = -1;

		if (!listOfRooms.isEmpty()) {

			for (Rooms listOfRoom : listOfRooms) {
				roomNumber = listOfRoom.createBooking(guestEGN, fromDate, toDate, listOfRoom, numberOfDays);
				if (roomNumber >= 0) {
					System.out.println("Booking successful!");
					listOfRoom.maintainRoom(fromDate);
					return roomNumber;
				}
			}
		} else {
			System.out.println("None of the rooms had the number of required beds.");
		}

		return -1;
	}

	/**
	 * A boolean returning method , responsible for the unbooking of a specific - user pointed out room.
	 * @param guestEGN Contains the guest eng in a string format.
	 * @param fromDate Represent sought booking's starting date.
	 * @param toDate   Represents the sought booking's end date.
	 * @return Returns TRUE on success and FALSE if the rooms hasn't been found.
	 */
	public boolean unBookRoom(String guestEGN, LocalDate fromDate, LocalDate toDate) {
		for (int roomsCounter = 0; roomsCounter < managedHotel.listOfRooms.size(); roomsCounter++) {
			if (managedHotel.listOfRooms.get(roomsCounter).removeBooking(guestEGN, fromDate, toDate)) {
				managedHotel.listOfRooms.get(roomsCounter).maintainRoom(toDate);
				return true;
			}
		}
		return false;
	}

	public Hotel getManagedHotel() {
		return managedHotel;
	}
}
