package hotelserviceapp.sources;

import hotelserviceapp.Support.*;

import java.util.ArrayList;
import java.util.List;


public class Hotel {

	private String hotelName;
	public List<Room> listOfRooms;

	public Hotel() {
		hotelName = "";
		listOfRooms = new ArrayList<>();
	}

	public int getNumberOfRooms() {
		return listOfRooms.size();
	}

	/**
	 * @param idx     An int type variable, which is used to point out the index,of array list of rooms , at which the room will
	 *                be added.
	 * @param newRoom A Room type object which represents the room that will be added to the list of rooms.
	 */
	public void addNewRoom(int idx, Room newRoom) {
		listOfRooms.add(idx, newRoom);
		newRoom.setRoomNumber(idx + 1);
	}

	/**
	 * An overloaded version of the addNewRoom(int idx , Room NewRoom) method.
	 *
	 * @param newRoom Represents the room to be added.
	 */
	public void addNewRoom(Room newRoom) {
		listOfRooms.add(newRoom);
		newRoom.setRoomNumber(listOfRooms.size() + 1);
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
	public void setHotelName(String newHotelName) {
		if (newHotelName.isEmpty()) {
			throw new EmptyStringException();
		}
		hotelName = newHotelName;
	}

	/**
	 * Searches the list of rooms for free ones , if there are any it returns them in an arraylist format.
	 * If none are free returns null.
	 *
	 * @return Returns a list of room that have the required number of rooms.
	 */
	public List<Room> searchForRooms(int numberOfRequiredBeds) {
		List<Room> temporaryList = new ArrayList<>();
		for (Room listOfRoom : listOfRooms) {
			if (listOfRoom.getRoomCapacity() == numberOfRequiredBeds) {
				temporaryList.add(listOfRoom);
			}
		}
		return temporaryList;
	}
}

