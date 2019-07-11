import java.util.ArrayList ;


public class Hotel {

	private String hotelName;
	public ArrayList<Rooms> listOfRooms;
	static int numberOfRooms = 0;


	Hotel() {
		hotelName = ""; // Or "Unnamed" ??
		listOfRooms = new ArrayList<Rooms>();
		InitNumberOfRooms();
	}


	public int getNumberOfRooms() {
		return numberOfRooms;
	}


	void InitNumberOfRooms() {
		if (numberOfRooms == 0)
			numberOfRooms = 1;
	}


	public void addNewRoom(int idx, Rooms NewRoom) {
		listOfRooms.add(idx, NewRoom);
		numberOfRooms++;
	}


	/**
	 * Returns the Hotel's name
	 *
	 * @return
	 */
	public String getHotelName() {
		return hotelName;
	}


	/**
	 * This variable is used as a new value for the Hotel Name member.
	 *
	 * @param newHotelName
	 */
	public void setHotelName(String newHotelName) {
		hotelName = newHotelName;
	}


	/**
	 * Searches the list of rooms for free ones , if there are any it returns them in an arraylist format.
	 * If none are free returns null.
	 *
	 * @return
	 */
	public ArrayList<Rooms> searchForFreeRooms() {
		ArrayList<Rooms> temporaryList = new ArrayList<Rooms>();
		for (int roomCounter = 0; roomCounter < Rooms.numberOfCreatedRooms; roomCounter++) {
			if (listOfRooms.get(roomCounter).isTaken()) {
				temporaryList.add(listOfRooms.get(roomCounter));
			}
		}
		return temporaryList;
	}
}

