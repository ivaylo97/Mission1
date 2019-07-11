import java.util.Date;
public class Bookings {
	private Date startDate ;
	private Date endDate ;
	private Rooms bookedRoom ;
	private String guestEGN;


	Bookings(){
		startDate = null ;
		endDate = null ;
		bookedRoom = null ;
		guestEGN = "" ;
	}
	Bookings(String EGN, Date newStartDate, Date newEndDate , Rooms roomToBeBooked) {
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
	 * @param newStartDate
	 * @param newEndDate
	 * @param newBookedRoom
	 */

	public void updateRoom(String newGuestEGN, Date newStartDate, Date newEndDate , Rooms newBookedRoom) {
		startDate = newStartDate ;
		endDate = newEndDate ;
		bookedRoom = newBookedRoom ;
		guestEGN = newGuestEGN ;
	}
}
