import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

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
     * @param
     */
    public boolean bookRoom(String guestEGN,LocalDate fromDate , LocalDate toDate , int numberOfRequiredBeds,int numberOfDays) {
		ArrayList<Rooms> listOfFreeRooms = managedHotel.searchForRooms(numberOfRequiredBeds);

		if(!listOfFreeRooms.isEmpty()){

			for(int roomsCounter = 0 ; roomsCounter < listOfFreeRooms.size() ; roomsCounter ++){
				if(listOfFreeRooms.get(roomsCounter).createBooking(guestEGN,fromDate,toDate,listOfFreeRooms.get(roomsCounter),numberOfDays)){
					listOfFreeRooms.get(roomsCounter).roomMaintenance(fromDate);
					System.out.println("Booking successful!");
					return true ;
				}
			}
		}
		System.out.println("None of the rooms had the number of required beds.");
		return false ;
	}

	/**
	 * A boolean returning method , responsible for the unbooking of a specific - user pointed out room.
	 * @param guestEGN
	 * Contains the guest eng in a string format.
	 * @param fromDate
	 * Represent sought booking's starting date.
	 * @param toDate
	 * Represents the sought booking's end date.
	 * @return
	 * Returns TRUE on success and FALSE if the rooms hasn't been found.
	 */
	public boolean unBookRoom(String guestEGN,LocalDate fromDate , LocalDate toDate ){
		for(int roomsCounter = 0 ; roomsCounter < managedHotel.listOfRooms.size() ; roomsCounter++){
			if(managedHotel.listOfRooms.get(roomsCounter).removeBooking(guestEGN,fromDate,toDate)){
				managedHotel.listOfRooms.get(roomsCounter).roomMaintenance(toDate);
				return  true ;
			}
		}
		return false ;
	}
}
