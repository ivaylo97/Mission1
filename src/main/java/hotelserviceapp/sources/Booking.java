package hotelserviceapp.sources;

import hotelserviceapp.hotelCommodities.domain.AbstractCommodity;

import java.time.*;

public class Booking {
	static private int totalNumberOfBookings  = 0;
	private int bookingID ;
	private LocalDate startDate;
	private LocalDate endDate;
	private int numberOfDays;
	private Rooms bookedRoom;
	private String guestEGN;

	public Booking() {
		guestEGN = "";
	}

	public Booking(String EGN, LocalDate newStartDate, LocalDate newEndDate, Rooms roomToBeBooked) {
		assertAndSetEGN(EGN);
		assertAndSetDates(newStartDate, newEndDate);
		assertRoom(roomToBeBooked);
		bookingID = hashCode();
	}

	/**
	 * This method takes the listed parameters below and uses them to initialize the class' members.
	 *
	 * @param newGuestEGN     newGuestEGN is a string type variable , containing the guest's EGN number.
	 * @param newStartDate    newStartDate is a LocalDate type variable which contains the requested booking's starting date.
	 * @param newEndDate      newEndDate is a LocalDate type variable which contains the requested booking's end date .
	 * @param newBookedRoom   newBookedRoom is an object which represents the room that is being booked.
	 * @param newNumberOfDays newNumberOfDays is an integer type variable which represents the number of days for which the room will be booked.
	 */

	public void updateRoom(String newGuestEGN, LocalDate newStartDate, LocalDate newEndDate, Rooms newBookedRoom, int newNumberOfDays) {
		assertAndSetEGN(newGuestEGN);
		assertAndSetDates(newStartDate, newEndDate);
		assertRoom(newBookedRoom);
		numberOfDays = newNumberOfDays;

	}

	/**
	 * When invoked this method returns the booking's start date.
	 *
	 * @return startDate
	 */
	public LocalDate getStartDate() {
		return startDate;
	}

	/**
	 * When invoked this method returns the booking's end date.
	 *
	 * @return endDate
	 */
	public LocalDate getEndDate() {
		return endDate;
	}

	/**
	 * When invoked this method returns the EGN of the guest which owns this booking.
	 *
	 * @return
	 */
	public String getGuestEGN() {
		return guestEGN;
	}

	/**
	 * Returns the number of days variable.
	 *
	 * @return
	 */
	public int getNumberOfDays() {
		return numberOfDays;
	}

	/**
	 * Returns the booked room object.
	 *
	 * @return
	 */
	public Rooms getBookedRoom() {
		return bookedRoom;
	}

	/**
	 * Method for checking if the guest's EGN has a correct value.
	 *
	 * @param EGN The guest's EGN.
	 */
	private void assertAndSetEGN(String EGN) {
		if (EGN.length() < 10) {
			System.out.println("ERROR :: Invalid EGN !");
			guestEGN = "";
			return;
		}
		if (EGN.isEmpty()) {
			System.out.println("WARNING :: EGN Empty String!");
			return;
		}
		if (EGN == null) {
			System.out.println("ERROR :: EGN is null !");
			guestEGN = "";
			return;
		}
		guestEGN = EGN;
	}

	/**
	 * Asserts whether the dates have correct values.
	 *
	 * @param fromDate The booking's starting date.
	 * @param toDate   The booking's end date.
	 */
	private void assertAndSetDates(LocalDate fromDate, LocalDate toDate) {
		if (fromDate == null) {
			System.out.println("ERROR :: fromDate has a null value !");
			return;
		}
		if (toDate == null) {
			System.out.println("ERROR :: toDate has a null value !");
			return;
		}
		if (fromDate.isBefore(LocalDate.now())) {
			System.out.println("ERROR :: Invalid value :: The staring date is before today !");
			//return;
		}
		if (toDate.isBefore(LocalDate.now())) {
			System.out.println("ERROR :: Invalid value :: The end date is before today !");
			//return;
		}
		if (fromDate.isAfter(toDate)) {
			System.out.println("ERROR :: Thr starting date is after the end date !");
			return;
		}
		startDate = fromDate;
		endDate = toDate;
	}

	/**
	 * Asserts whether the room to be booked is a valid object.
	 *
	 * @param roomToBeBooked roomToBeBooked represents the object that is about to be booked.
	 */
	void assertRoom(Rooms roomToBeBooked) {
		if (roomToBeBooked == null) {
			System.out.println("ERROR :: Room object has null value !");
			return;
		}
		if (roomToBeBooked.getRoomNumber() <= 0) {
			System.out.println("WARNING :: Room number has negative value, may be invalid object !");
		}
		bookedRoom = roomToBeBooked;
	}

	@Override
	public boolean equals(Object compareObject) {
		if (!(compareObject instanceof Booking)) return false;
		return this.bookingID == ((Booking) compareObject).bookingID;
	}
	@Override
	public int hashCode(){
		totalNumberOfBookings++;
		return  totalNumberOfBookings;
	}
}
