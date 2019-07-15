import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Date;
public class Rooms {
	private int roomNumber= -1 ;
	private int numberOfBeds ;
	private int numberOfShowers ;
	private int numberOfToilets ;
	Set<AbstractCommodity> commodities ;
	Set<LocalDate> maintenanceDates ;
	Set<Bookings> bookingsSet ;


	Iterator<AbstractCommodity> commodityIterator ;
	/**
	 * Constructor initializing the members of the Rooms class
	 */
	Rooms() {
		commodities = new HashSet<AbstractCommodity>();
		maintenanceDates = new HashSet<LocalDate>();
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

	/**
	 * This method invokes all of the commodities available for the maintenance of the room.
	 * @param newMaintenanceDate
	 * A Date typed object that represents a date at which the room is under maintenance.
	 */
	void  roomMaintenance(LocalDate newMaintenanceDate){
		commodityIterator = commodities.iterator();
		while(commodityIterator.hasNext()){
			commodityIterator.next().Prepare();
		}
		maintenanceDates.add(newMaintenanceDate);
	}

	/**
	 * This method takes the guest's EGN , fromDate to tell us which is the booking's starting day , and
	 * toDate to tell us which is the booking's last day.And roomToBeBooked which is used to address the room
	 * that is to be booked.
	 * It later traverses the booking set and checks whether the selected dates are already booked by checking whether the
	 * starting/end dates are already present in the booking set.
	 * Returns an asnwer on whether the booking was successful.
	 * 	@param guestEGN
	 * 	newGuestEGN is a string type variable , containing the guest's EGN number.
	 * 	@param fromDate
	 * 	fromDate is a LocalDate type variable which contains the requested booking's starting date.
	 * 	@param toDate
	 * 	toDate is a LocalDate type variable which contains the requested booking's end date .
	 *  @param roomToBeBooked
	 * 	roomToBeBooked is an object which represents the room that is being booked.
	 * 	@param numberOfDays
	 *  numberOfDays is an integer type variable which represents the number of days for which the room will be booked.
	 */
	boolean createBooking(String guestEGN, LocalDate fromDate, LocalDate toDate , Rooms roomToBeBooked , int numberOfDays){
		Bookings objectToBeBooked = new Bookings();
		Bookings temporaryObject ;
		Iterator<Bookings> temporaryIterator = bookingsSet.iterator();
		LocalDate objectToBeBookedStartDate = objectToBeBooked.getStartDate();
		LocalDate objectToBeBookedEndDate = objectToBeBooked.getEndDate();

		objectToBeBooked.updateRoom(guestEGN,fromDate,toDate,roomToBeBooked,numberOfDays);

		while(temporaryIterator.hasNext()){

			temporaryObject = temporaryIterator.next();

			if(objectToBeBookedStartDate.isAfter(temporaryObject.getStartDate())) {
				if (objectToBeBookedStartDate.isBefore(temporaryObject.getEndDate())) {
					System.out.println("The Starting date of your booking is already taken.");
					return false;
				}
			} else {
				if(objectToBeBookedEndDate.isAfter(temporaryObject.getStartDate())){
					System.out.println("The end date of your booking overlaps with another booking's days");
					return false;
				}
			}
		}
		bookingsSet.add(objectToBeBooked);
		return true;
	}

	/**
	 * An overloaded version of the upper method.The difference is that this method takes a predefined object
	 * as a parameter.
	 * It later traverses the booking set and checks whether the selected dates are already booked by checking whether
	 * the starting/end dates are already present in the booking set.
	 * @param temporaryObject
	 */
	void createBooking(Bookings temporaryObject){

		Iterator<Bookings> temporaryIterator = bookingsSet.iterator();
		LocalDate temporaryObjectStartDate = temporaryObject.getStartDate();
		LocalDate temporaryObjectEndDate = temporaryObject.getEndDate();

		while(temporaryIterator.hasNext()){
			if(temporaryObjectStartDate.isAfter(temporaryIterator.next().getStartDate())) {
				if (temporaryObjectStartDate.isBefore(temporaryIterator.next().getEndDate())) {
					System.out.println("The Starting date of your booking is already taken.");
					return;
				}
			}else {
				if(temporaryObjectEndDate.isAfter(temporaryIterator.next().getStartDate())){
					System.out.println("The end date of your booking overlaps with another booking's days");
					return;
				}
			}
		}
		bookingsSet.add(temporaryObject);
	}

	/**
	 * This method removes a booking out of the booking set.
	 * It traverses the booking set and compares the dates,which have been passed as parameters , with those that are
	 * present in a member of the set.If the comparison results in a true value the set member is removed.
	 * @param fromDate
	 * LocalDate type variable  that represents the starting date of the booking that is to be removed.
	 * @param toDate
	 * LocalDate type variable  that represents the end date of the booking that is to be removed.
	 * @param guestEGN
	 * String type variable which contains the EGN of the guest which booked the room.
	 */

	boolean removeBooking(String guestEGN,LocalDate fromDate,LocalDate toDate ){
		Iterator<Bookings> temporaryIterator = bookingsSet.iterator();
		Bookings tempBooking ;
		while(temporaryIterator.hasNext()){
			tempBooking = temporaryIterator.next();
			if(guestEGN.equals(tempBooking.getGuestEGN())) {
				if (tempBooking.getStartDate().equals(fromDate) && tempBooking.getEndDate().equals(toDate)) {
					temporaryIterator.remove();
					System.out.println("Booking remove successful!");
					return  true ;
				}
			}
		}
		return false ;
	}

	/**
	 * Removes all of the bookings currently present in the booking set.
	 */
	void removeAllBookings(){
		Iterator<Bookings> temporaryIterator = bookingsSet.iterator();
		Bookings tempBooking ;
		while ((temporaryIterator.hasNext())){
			temporaryIterator.next();
			temporaryIterator.remove();

		}
	}

	/**
	 * This method takes number of beds/showers/toilets in a single room , and adds them to the commodities.
	 * @param newNumberOfBeds
	 * An int type variable ,used to set the number of beds present in the room,also to add that number of beds into
	 * the commodities set.
	 * @param newNumberOfShowers
	 *  An int type variable ,used to set the number of showers present in the room,also to add that number of showers
	 *  into the commodities set.
	 * @param newNumberOfToilets
	 * An int type variable , used to set the number of toilets present in the room , also to to add that number of
	 * toilets into the commodities set.
	 */
	void setCommodities(int newNumberOfBeds , int newNumberOfShowers , int newNumberOfToilets){
		numberOfBeds = newNumberOfBeds ;
		numberOfShowers = newNumberOfShowers ;
		numberOfToilets = newNumberOfToilets ;

		for(int bedCounter = 0 ; bedCounter < numberOfBeds ; bedCounter ++){
			commodities.add(new Bed());
		}
		for(int showerCounter = 0 ; showerCounter < numberOfShowers ; showerCounter ++){
			commodities.add(new Shower());
		}
		for(int toiletCounter = 0 ; toiletCounter < numberOfToilets ; toiletCounter ++){
			commodities.add(new Toilet());
		}
	}

	/**
	 * Returns the number of beds in the room.
	 * @return numberOfBeds
	 */
	int getNumberOfBeds(){
		return numberOfBeds ;
	}

	/**
	 * Returns the number of showers in the room.
	 * @return numberOfShowers
	 */
	int getNumberOfShowers(){
		return numberOfShowers ;
	}

	/**
	 * Returns the number of toilets in the room.
	 * @return numberOfToilets
	 */
	int getNumberOfToilets(){
		return numberOfToilets ;
	}
}
