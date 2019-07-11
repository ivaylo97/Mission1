public class Manager {

    private String hotelName;
    private String managerName;
    Hotel managedHotel;

    /**
     * Returns the name of the hotel that is being managed by the manager.
     * @return
     */
    String getHotelName() {
          return hotelName;
    }

    /**
     *  Returns the manager's name.
     * @return
     */

    String getManagerName() {
        return managerName;
    }

    void setManagerName(String newManagerName) {
    	managerName = newManagerName ;
	}

    /**
     * This method takes a Hotel object as a formal parameter which is later used to set the values of the managedHotel
	 * and the hotelName variables.
     * @param newHotel
     */
    public void setHotel(Hotel newHotel) {
		managedHotel = newHotel ;
        hotelName = newHotel.getHotelName() ;
    }

    /**
     * This method raises the BookFlag of a specific room in order to mark it as taken.
     * It uses a helper variable ( TempRoom ) in order to reduce the instruction count.
     * The helper variable is later used to check whether the room is taken if not the room
     * is then market as taken(BookFlag is raised), if it is it notifies us by printing a message.
     * roomNumber is used to specify the targeted room.
     * @param roomNumber
     */
    public void bookRoom(int roomNumber) {
		Rooms tempRoom = managedHotel.listOfRooms.get(roomNumber);
		if (tempRoom.isTaken()) {
			System.out.println("The room is already taken");
		} else {
			tempRoom.BookRoom();
		}
	}
}
