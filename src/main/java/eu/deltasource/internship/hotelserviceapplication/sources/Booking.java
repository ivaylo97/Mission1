package eu.deltasource.internship.hotelserviceapplication.sources;

import eu.deltasource.internship.hotelserviceapplication.Support.*;

import java.time.*;
import java.util.Set;

/**
 * The Booking class is used to create bookings for the rooms.
 * It's objects are contained in a booking's set ,which is a private member of the Room class
 * Member variables :
 * TOTAL_NUMBER_OF_BOOKINGS - used to track the total number of objects created by this class,furthermore
 * it's value is used in the craft of the bookingID.
 * bookingID - a private integer variable used to differ one object of another.
 * startDate/endDate - private LocalDate variables used to represent the starting/end date of the booking.
 * guestID - a private String variable used to store the ID of the guest who made the booking.
 */
public class Booking {
	private static int TOTAL_NUMBER_OF_BOOKINGS = 0;
	private int bookingID;
	private LocalDate startDate;
	private LocalDate endDate;
	private String guestID;

	/**
	 * A private default constructor, used to prevent the creation of bookings without the
	 * mandatory information ,required for it.
	 */
	private Booking() {
	}

	/**
	 * A constructor of the Booking class,takes a String and two LocalDate typed variables as formal
	 * parameters.
	 *
	 * @param guestID      - Represents ID of the guest who requests the booking.
	 * @param newStartDate - Represents the date that is to be the booking's start date.
	 * @param newEndDate   - Represents the date that is to bethe booking's end date
	 */
	public Booking(String guestID, LocalDate newStartDate, LocalDate newEndDate) {
		assertAndSetID(guestID);
		assertAndSetDates(newStartDate, newEndDate);
		TOTAL_NUMBER_OF_BOOKINGS++;
		bookingID = TOTAL_NUMBER_OF_BOOKINGS;
	}

	/**
	 * The method uses it's passed formal parameters ,asserts if they have correct values and then uses them to
	 * Re-Set the already present and set object members.
	 *
	 * @param newGuestID   newGuestID is a string type variable , containing the guest's EGN number.
	 * @param newStartDate newStartDate is a LocalDate type variable which contains the requested booking's starting date.
	 * @param newEndDate   newEndDate is a LocalDate type variable which contains the requested booking's end date .
	 */
	void updateBooking(String newGuestID, LocalDate newStartDate, LocalDate newEndDate) {
		assertAndSetID(newGuestID);
		assertAndSetDates(newStartDate, newEndDate);
	}

	/**
	 * When invoked this method returns the booking's start date.
	 *
	 * @return startDate
	 */
	LocalDate getStartDate() {
		return startDate;
	}

	/**
	 * When invoked this method returns the booking's end date.
	 *
	 * @return endDate
	 */
	LocalDate getEndDate() {
		return endDate;
	}

	/**
	 * When invoked this method returns the EGN of the guest which owns this booking.
	 *
	 * @return Returns the EGN of the guest
	 */
	String getGuestId() {
		return guestID;
	}

	/**
	 * Method for checking if the guest's id has a valid value.
	 *
	 * @param id The guest's id.
	 */
	private void assertAndSetID(String id) {
		if (id == null || id.length() < 10) {
			throw new InvalidValueException("ID has invalid value");
		}
		guestID = id;

	}

	/**
	 * Asserts whether the dates have valid values.
	 *
	 * @param fromDate The booking's starting date.
	 * @param toDate   The booking's end date.
	 */
	private void assertAndSetDates(LocalDate fromDate, LocalDate toDate) {
		if (fromDate != null && toDate != null) {
			if (fromDate.isBefore(LocalDate.now())) {
				throw new InvalidValueException(fromDate.toString() + " is before today!");
			}
			if (toDate.isBefore(LocalDate.now())) {
				throw new InvalidValueException(toDate.toString() + " is before today !");
			}
			if (fromDate.isAfter(toDate)) {
				throw new InvalidValueException(fromDate.toString() + " is after " + toDate.toString() + " !");
			}
			startDate = fromDate;
			endDate = toDate;
		} else {
			throw new ObjectHasNullValueException("Some of the Dates has null value !");
		}
	}

	/**
	 * Checks whether the the booking,invoking the method is present in a specified Set.
	 *
	 * @param bookings Represents the set of bookings.
	 * @return Return boolean answer on whether it is present.
	 */
	boolean isPresentIn(Set<Booking> bookings) {
		return bookings.contains(this);
	}

	@Override
	public boolean equals(Object compareObject) {
		if (!(compareObject instanceof Booking)) return false;
		return this.bookingID == ((Booking) compareObject).bookingID;
	}

	@Override
	public int hashCode() {
		return this.bookingID;
	}
}
