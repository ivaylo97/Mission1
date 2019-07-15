import java.time.*;
public class Bookings {
	private LocalDate startDate ;
	private LocalDate endDate ;
	private int numberOfDays ;
	private Rooms bookedRoom ;
	private String guestEGN;


	Bookings(){
		startDate = LocalDate.parse("2001-01-01") ;
		endDate = LocalDate.parse("2001-01-01") ;
		bookedRoom = null ;
		guestEGN = "" ;
	}
	Bookings(String EGN, LocalDate newStartDate, LocalDate newEndDate , Rooms roomToBeBooked) {
		if(EGN.length()<10){
				System.out.println("Invalid EGN.");
		} else {
			guestEGN = EGN ;
		}
		if(startDate.toString() == ""){
			System.out.println("Invalid  start date.");
		} else {
			startDate = newStartDate ;
		}
		if(endDate.toString() == ""){
			System.out.println("Invalid end date");
		} else {
			endDate = newEndDate ;
		}
		if(roomToBeBooked == null){
			System.out.println("Invalid room");
		} else {
			bookedRoom = roomToBeBooked ;
		}
	}

	/**
	 * This method takes the listed parameters below and uses them to initialize the class' members.
	 * @param newGuestEGN
	 * newGuestEGN is a string type variable , containing the guest's EGN number.
	 * @param newStartDate
	 * newStartDate is a LocalDate type variable which contains the requested booking's starting date.
	 * @param newEndDate
	 * newEndDate is a LocalDate type variable which contains the requested booking's end date .
	 * @param newBookedRoom
	 * newBookedRoom is an object which represents the room that is being booked.
	 * @param newNumberOfDays
	 * newNumberOfDays is an integer type variable which represents the number of days for which the room will be booked.
	 */

	public void updateRoom(String newGuestEGN, LocalDate newStartDate, LocalDate newEndDate , Rooms newBookedRoom , int newNumberOfDays) {
		startDate = newStartDate ;
		endDate = newEndDate ;
		bookedRoom = newBookedRoom ;
		guestEGN = newGuestEGN ;
		numberOfDays = newNumberOfDays;

	}

	/**
	 * When invoked this method returns the booking's start date.
	 * @return startDate
	 */
	public LocalDate getStartDate(){
		return startDate ;
	}

	/**
	 * When invoked this method returns the booking's end date.
	 * @return endDate
	 */
	public LocalDate getEndDate(){
		return  endDate ;
	}

	/**
	 * When invoked this method returns the EGN of the guest which owns this booking.
	 * @return
	 */
	public String getGuestEGN(){
		return guestEGN ;
	}

	/**
	 * Returns the number of days variable.
	 * @return
	 */
	public int getNumberOfDays(){
		return  numberOfDays;
	}

	/**
	 * Returns the booked room object.
	 * @return
	 */
	public Rooms getBookedRoom() {
		return bookedRoom;
	}
}
