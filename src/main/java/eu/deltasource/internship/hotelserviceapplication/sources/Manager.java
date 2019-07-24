package eu.deltasource.internship.hotelserviceapplication.sources;

import eu.deltasource.internship.hotelserviceapplication.Support.*;
import eu.deltasource.internship.hotelserviceapplication.Support.BookingExceptions.UnbookingFailureException;

import java.time.LocalDate;
import java.util.*;

/**
 *
 */
public class Manager {

	private String managerName;
	private Hotel managedHotel;

	/**
	 * A private default constructor , used to prevent the creation of Manager objects
	 * without the mandatory data.
	 */
	private Manager() {
	}

	/**
	 * A constructor taking a string as a formal parameter and using it to set the manager's name.
	 * @param managerName
	 */
	public Manager(String managerName){
		this.managerName = managerName;
	}

	/**
	 * @return Returns the manager's name.
	 */
	String getManagerName() {
		return managerName;
	}

	void setManagerName(String newManagerName) {
		if (newManagerName.equals("")) {
			throw new EmptyStringException(newManagerName);
		}
		managerName = newManagerName;
	}

	/**
	 * This method takes a Hotel object as a formal parameter which is later used to set the values of the managedHotel
	 * and the hotelName variables.
	 *
	 * @param newHotel Represents the hotel that is going to be managed.
	 */
	public void setHotel(Hotel newHotel) {
		if (newHotel == null) {
			throw new NullObjectException("newHotel has null value !");
		}
		managedHotel = newHotel;
	}

	/**
	 * This method takes everything required to make a booking as parameters,then searches for all rooms that
	 * have the required number of bed , and lastly checks every room in the list of rooms whether it is available
	 * in the specified dates ,starting from the first one.
	 *
	 * @param guestEGN         String - Contains the guest's EGN.
	 * @param fromDate         LocalDate  - represents the booking's start date.
	 * @param toDate           LocalDate - represents the booking's end date.
	 * @param requiredCapacity int - represents the number of required beds from the guest.
	 * @return Returns boolean answer on whether the booking was successful.
	 */
	public int bookRoom(String guestEGN, LocalDate fromDate, LocalDate toDate, int requiredCapacity) {
		List<Room> listOfRooms = managedHotel.searchForRooms(requiredCapacity);
		int roomNumber;

		if (!listOfRooms.isEmpty()) {

			for (Room room : listOfRooms) {
				roomNumber = room.createBooking(guestEGN, fromDate, toDate);
				if (roomNumber >= 0) {
					System.out.println("Booking successful!");
					room.maintainRoom(fromDate);
					return roomNumber;
				}
			}
		}
		throw new EmptyListException("listOfRooms is empty !");
	}

	/**
	 * A method responsible for the unbooking of a specific - user pointed out room.
	 * @param guestEGN Contains the guest eng in a string format.
	 * @param fromDate Represent sought booking's starting date.
	 * @param toDate   Represents the sought booking's end date.
	 */
	public void unBookRoom(String guestEGN, LocalDate fromDate, LocalDate toDate) {
		List<Room> listOfRooms = managedHotel.getListOfRooms();
		int numberOfRooms = managedHotel.getNumberOfRooms();
		Room room;

		for (int roomsCounter = 0; roomsCounter < numberOfRooms; roomsCounter++) {
			room = listOfRooms.get(roomsCounter);
			room.removeBooking(guestEGN, fromDate, toDate);
			room.maintainRoom(toDate);
		}
	}
	public Hotel getManagedHotel() {
		return managedHotel;
	}
}
