import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Date;
public class Rooms {
	static private int roomNumber= -1 ;
	//private boolean isBooked ; Removed because of task 2 !
	Set<AbstractCommodity> commodities ;
	Set<Date> maintenanceDates ;
	Set<Bookings> bookingsSet ;

	Iterator<AbstractCommodity> commodityIterator ;
	/**
	 * Constructor initializing the members of the Rooms class
	 */
	Rooms() {
		commodities = new HashSet<AbstractCommodity>();
		maintenanceDates = new HashSet<Date>();
		bookingsSet = new HashSet<Bookings>();
		initNumberOfRooms();

		roomNumber++;

	}
	int getRoomNumber(){
		return roomNumber;
	}

	/**
	 * numberOfCreatedRooms is a static member of the Rooms class
	 * it's purpose is to contain the absolute number of created rooms
	 * and thus to assist in the automatic generation ot the rooms numbers.
	 * This methods'  sole purpose is to initialize the numberOfCreatedRooms variable
	 * (if it has not been initialized ) to zero ( 0 )
	 */
	void initNumberOfRooms() {
		if(roomNumber < 0 )
			roomNumber = 0 ;
     }

//	int getNumberOfCreatedRooms(){
//		return numberOfCreatedRooms;
//	}


	/**
	 * This method checks whether the isBooked (which is a testament of whether a room is free or not)
	 * and return a boolean value as an answer
	 */
	/**
	 * Returns a value based on whether a rooms is taken or not
	 * @return isBooked
	 */
	//public boolean isTaken() {
	//	return isBooked;
	//}

	/**
	 * This method raises the isBooked  flag of a specific room
	 */
	//public void BookRoom() {
	//	if(!isTaken())
	//		isBooked = true ;
	//	else
	//		System.out.println("The room is already taken");
	//}

	/**
	 * This method sets the isBooked of a specific room to false (a.k.a Not taken)
	 */

	//public void UnbookRoom() {
	//	if(isBooked) {
	//		isBooked = false;
	//	}
	//}

	/**
	 * This method invokes all of the commodities available for the maintenance of the room.
	 * It take a Date object as a formal parameter and uses it to create a log of when the room was
	 * under maintenance.
	 * @param newMaintenanceDate
	 */
	void  roomMaintenance(Date newMaintenanceDate){
		commodityIterator = commodities.iterator();
		while(commodityIterator.hasNext()){
			commodityIterator.next().Prepare();
			maintenanceDates.add(newMaintenanceDate);
		}
	}

	/**
	 * This method takes the guest's EGN , fromDate to tell us which is the booking's starting day , and
	 * toDate to tell us which is the booking's last day.And roomToBeBooked which is used to address the room
	 * that is to be booked.
	 * @param guestEGN
	 * @param fromDate
	 * @param toDate
	 * @param roomToBeBooked
	 */
	void createBooking(String guestEGN,Date fromDate,Date toDate , Rooms roomToBeBooked){
		Bookings TemporaryObject = new Bookings();
		TemporaryObject.updateRoom(guestEGN,fromDate,toDate,roomToBeBooked);
		bookingsSet.add(TemporaryObject);
	}

	void removeBooking(Date fromDate,Date toDate , Rooms roomToBeBooked){

	}

	/**
	 * This method takes number of beds/showers/toilets in a single room , and adds them to the commodities.
	 * @param numberOfBeds
	 * @param numberOfShowers
	 * @param numberOfToilets
	 */
	void setCommodities(int numberOfBeds , int numberOfShowers , int numberOfToilets){
		int[] commoditiesArray = {numberOfBeds,numberOfShowers,numberOfToilets};
		while(commoditiesArray[0] > 0){
			commodities.add(new Bed());
			commoditiesArray[0] --;
		}
		while(commoditiesArray[1] > 0){
			commodities.add(new Shower());
			commoditiesArray[1] --;
		}
		while (commoditiesArray[2] > 0){
			commodities.add(new Toilet());
			commoditiesArray[2] -- ;
		}
	}


}
