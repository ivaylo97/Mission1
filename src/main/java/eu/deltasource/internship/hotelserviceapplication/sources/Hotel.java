package eu.deltasource.internship.hotelserviceapplication.sources;

import eu.deltasource.internship.hotelserviceapplication.Support.EmptyStringException;
import eu.deltasource.internship.hotelserviceapplication.Support.InvalidValueException;
import eu.deltasource.internship.hotelserviceapplication.Support.ObjectHasNullValueException;
import eu.deltasource.internship.hotelserviceapplication.hotelCommodities.domain.AbstractCommodity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The Hotel class has three private members :
 * hotelName - a private String variable , used to store the hotel's name.
 * listOfRooms - a private List of rooms typed variable , represents the list of rooms present in the hotel.
 * inventory - a Set of AbstractCommodities , represents the whole set of commodities which the hotel has.
 */
public class Hotel {

	private String hotelName;
	private List<Room> listOfRooms;
	private Set<AbstractCommodity> inventory;

	/**
	 * A private default constructor used to prevent the creation of Hotel objects without providing the
	 * mandatory data for the hotel.
	 */
	private Hotel() {
	}

	/**
	 * A constructor of the Hotel class, takes one formal parameter.
	 *
	 * @param hotelName - A string type variable , represents the name that is to be assigned to the
	 *                  hotelName member of the class.
	 */
	Hotel(String hotelName) {
		setHotelName(hotelName);
		listOfRooms = new ArrayList<>();
		inventory = new HashSet<>();
	}

	/**
	 * @return - Returns the number of rooms currently present in the hotel.
	 */
	int getNumberOfRooms() {
		return listOfRooms.size();
	}

	/**
	 * An overloaded version of the addNewRoom(int idx , Room NewRoom) method.
	 *
	 * @param newRoom Represents the room to be added.
	 */
	void addNewRoom(Room newRoom) {
		if (newRoom == null) {
			throw new ObjectHasNullValueException("newRoom has null value.");
		}
		newRoom.setRoomNumber(listOfRooms.size() + 1);
		listOfRooms.add(newRoom);
		inventory.addAll(newRoom.getCommodities());
	}

	/**
	 * A method allowing the hotel to add commodities to its rooms by specifying room number and
	 * the commodity to be added.
	 * The very reason for the creation of this method is to allow dynamic update mechanic for
	 * the inventory set.
	 *
	 * @param commodity  - Represents the commodity to be added .
	 * @param roomNumber - Represents the room number of the room that will have
	 *                   the commodity added to.
	 */
	public void AddCommodityToRoom(AbstractCommodity commodity, int roomNumber) {
		if (commodity == null || roomNumber <= 0) {
			throw new InvalidValueException("commodity/roomNumber has an invalid value");
		}
		Room tempRoom = listOfRooms.get(--roomNumber);
		if (!inventory.contains(commodity) && (!tempRoom.getCommodities().contains(commodity))) {
			tempRoom.addCommodity(commodity);
			inventory.add(commodity);
		}
	}

	/**
	 * @return Returns the Hotel's name
	 */
	String getHotelName() {
		return hotelName;
	}

	/**
	 * @param newHotelName String type variable ,used to set a new value to the hotel's name.
	 */
	void setHotelName(String newHotelName) {
		if (newHotelName == null || newHotelName.isEmpty()) {
			throw new EmptyStringException(newHotelName);
		}
		hotelName = newHotelName;
	}

	Set<AbstractCommodity> getInventory() {
		return inventory;
	}

	/**
	 * @return Returns the hotel's list of rooms.
	 */
	List<Room> getListOfRooms() {
		return listOfRooms;
	}

	/**
	 * Searches the list of rooms for free ones , if there are any it returns them in an array-list format.
	 *
	 * @return Returns a list of rooms that have the required number of rooms.
	 */
	List<Room> searchForRooms(int numberOfRequiredBeds) {
		List<Room> temporaryList = new ArrayList<>();
		for (Room listOfRoom : listOfRooms) {
			if (listOfRoom.getRoomCapacity() == numberOfRequiredBeds) {
				temporaryList.add(listOfRoom);
			}
		}
		return temporaryList;
	}
}

