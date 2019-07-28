package eu.deltasource.internship.hotelserviceapplication.sources;

import eu.deltasource.internship.hotelserviceapplication.Support.*;
import eu.deltasource.internship.hotelserviceapplication.Support.DateExceptions.OverlappingDateException;
import eu.deltasource.internship.hotelserviceapplication.hotelCommodities.*;
import eu.deltasource.internship.hotelserviceapplication.hotelCommodities.BedTypes.BedTypes;
import eu.deltasource.internship.hotelserviceapplication.hotelCommodities.domain.AbstractCommodity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * The Room class has six private members :
 * roomNumber - private int variable , used to represent the room's number.
 * roomCapacity - private int variable , represents the room's capacity.
 * commodities - A Sett of AbstractCommodities ,used to store the room's commodities.
 * maintenanceDates - A Set of LocalDates , used to store the all the dates in which the rooms has been
 * under maintenance.
 * bookings - A Set of Bookings ,used to store all the bookings for the room.
 * roomOwnerHotel - private Hotel object , used as a link from the room to its hotel.
 * Later used to update the hotel's inventory.
 */
public class Room {
	private int roomNumber;
	private int roomCapacity;  // a.k.a bed's capacity
	private Set<AbstractCommodity> commodities;
	private Set<LocalDate> maintenanceDates;
	private Set<Booking> bookings;

	/**
	 * Constructor initializing the members of the Room class
	 */
	public Room() {
		commodities = new HashSet<>();
		maintenanceDates = new HashSet<>();
		bookings = new HashSet<>();
		roomCapacity = 0;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	/**
	 * This method invokes all of the commodities available for the maintenance of the room.
	 *
	 * @param newMaintenanceDate A Date typed object that represents a date at which the room is under maintenance.
	 */
	void maintainRoom(LocalDate newMaintenanceDate) {

		if (newMaintenanceDate == null) {
			throw new ObjectHasNullValueException("newMaintenanceDate has null value !");
		}
		for (AbstractCommodity commodity : commodities) {
			commodity.prepare();
		}
		maintenanceDates.add(newMaintenanceDate);
	}

	/**
	 * This method takes the guest's EGN , fromDate to tell us which is the booking's starting day , and
	 * toDate to tell us which is the booking's last day.And roomToBeBooked which is used to address the room
	 * that is to be booked.
	 * It later traverses the booking set and checks whether the selected dates are already booked by checking whether the
	 * starting/end dates are already present in the booking set.
	 * Returns room number on successful booking , and negative value on failure.
	 *
	 * @param guestEGN newGuestEGN is a string type variable , containing the guest's EGN number.
	 * @param fromDate fromDate is a LocalDate type variable which contains the requested booking's starting date.
	 * @param toDate   toDate is a LocalDate type variable which contains the requested booking's end date .
	 */
	int createBooking(String guestEGN, LocalDate fromDate, LocalDate toDate) {
		Booking objectToBeBooked = new Booking(guestEGN, fromDate, toDate);

		if (!objectToBeBooked.isPresentIn(bookings)) {
			if (checkAvailability(fromDate, toDate)) {
				bookings.add(objectToBeBooked);
				return roomNumber;
			}
			throw new OverlappingDateException("The selected dates overlap with already existing ones !");
		}
		return -1;
	}

	/**
	 * This method removes a booking out of the booking set.
	 * It traverses the booking set and compares the dates,which have been passed as parameters , with those that are
	 * present in a member of the set.If the comparison results in a true value the set member is removed.
	 *
	 * @param fromDate LocalDate type variable  that represents the starting date of the booking that is to be removed.
	 * @param toDate   LocalDate type variable  that represents the end date of the booking that is to be removed.
	 * @param guestId  String type variable which contains the EGN of the guest which booked the room.
	 */
	void removeBooking(String guestId, LocalDate fromDate, LocalDate toDate) {
		if (guestId == null) {
			throw new ObjectHasNullValueException("guestID has null value !");
		}
		if (fromDate == null || toDate == null) {
			throw new ObjectHasNullValueException("from/to date has null value !");
		}
		for (Booking book : bookings) {
			if (book.getGuestId().equals(guestId)) {
				if (book.getStartDate().equals(fromDate) && book.getEndDate().equals(toDate)) {
					bookings.remove(book);
					System.out.println("Booking remove successful!");
				}
			}
		}
	}

	/**
	 * Removes all of the bookings currently present in the booking set.
	 */
	void removeAllBookings() {
		bookings.clear();
	}

	/**
	 * This method takes number of beds/showers/toilets in a single room , and adds them to the commodities.
	 *
	 * @param newNumberOfBeds    An int type variable ,used to set the number of beds present in the room,also to add that number of beds into
	 *                           the commodities set.
	 * @param bedType            An instances of the BedType enumeration,which is located in the BedTypes class.It specifies the type of the bed
	 *                           that is to be added to the room.
	 * @param newNumberOfShowers An int type variable ,used to set the number of showers present in the room,also to add that number of showers
	 *                           into the commodities set.
	 * @param newNumberOfToilets An int type variable , used to set the number of toilets present in the room , also to to add that number of
	 *                           toilets into the commodities set.
	 */
	void setCommodities(int newNumberOfBeds, BedTypes bedType, int newNumberOfShowers, int newNumberOfToilets) {
		for (int bedCounter = 0; bedCounter < newNumberOfBeds; bedCounter++) {
			addCommodity(new Bed(bedType));
		}
		for (int showerCounter = 0; showerCounter < newNumberOfShowers; showerCounter++) {
			addCommodity(new Shower());
		}
		for (int toiletCounter = 0; toiletCounter < newNumberOfToilets; toiletCounter++) {
			addCommodity(new Toilet());
		}
	}

	/**
	 * Returns the number of beds in the room.
	 *
	 * @return roomCapacity
	 */
	int getRoomCapacity() {
		return roomCapacity;
	}

	/**
	 * Iterates over the commodities set and returns the number of showers in the room.
	 *
	 * @return numberOfShowers
	 */
	int getNumberOfShowers() {
		int numberOfShowers = 0;

		for (AbstractCommodity commodity : commodities) {
			if (commodity instanceof Shower) {
				numberOfShowers++;
			}
		}
		return numberOfShowers;
	}

	/**
	 * Iterates the commodities set and returns the number of toilets in the room.
	 *
	 * @return numberOfToilets
	 */
	int getNumberOfToilets() {
		int numberOfToilets = 0;
		for (AbstractCommodity commodity : commodities) {
			if (commodity instanceof Toilet) {
				numberOfToilets++;
			}
		}
		return numberOfToilets;
	}

	/**
	 * @return - Returns the set of maintenanceDates.
	 */
	Set<LocalDate> getMaintenanceDates() {
		return maintenanceDates;
	}

	/**
	 * @return - Returns the set of bookings.
	 */
	Set<Booking> getBookings() {
		return bookings;
	}

	/**
	 * @return - Returns the set of commodities.
	 */
	Set<AbstractCommodity> getCommodities() {
		return commodities;
	}

	/**
	 * Checks whether the passed as a formal parameter booking has any conflicts with the already present bookings in
	 * the set of bookings.
	 *
	 * @param fromDate - A not null LocalDate type variable ,
	 *                 representing the booking's starting date
	 * @param toDate   - A not null LocalDate type variable,
	 *                 representing the booking's expire date.
	 * @return Returns boolean answer on whether there were any date conflicts.
	 */
	boolean checkAvailability(LocalDate fromDate, LocalDate toDate) {

		if (!bookings.isEmpty()) {
			for (Booking temporaryObject : bookings) {
				if (fromDate.isAfter(temporaryObject.getStartDate())) {
					if (fromDate.isBefore(temporaryObject.getEndDate())) {
						return false;
					}
				} else {
					if (toDate.isAfter(temporaryObject.getStartDate())) {
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * The method is used to change/set/initialize the room's number.
	 *
	 * @param roomNumber - An integer type variable ,representing the the room number that is to be assigned to the
	 *                   current room.
	 */
	void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	/**
	 * Adds a commodity to the room's set of commodities.
	 *
	 * @param commodity Represents the commodity that we want to add to the room.
	 */
	void addCommodity(AbstractCommodity commodity) {
		if (commodity == null) {
			throw new ObjectHasNullValueException("commodity has null value !");
		}
		if (commodities.contains(commodity)) {
			throw new ObjectIsAlreadyPresentException("The commodity is already present inside the commodities set.");
		}
		if (commodity instanceof Bed) {
			if (!((Bed) commodity).isDeployed()) {
				((Bed) commodity).deployBed();
				roomCapacity += ((Bed) commodity).getBedType().getBedCapacity();
			}
		}
		commodities.add(commodity);
	}

	/**
	 * A boolean returning method , whose purpose is to compare the data members of an whole
	 * booking object , with the specified guestID, fromDate and toDate.
	 *
	 * @param booking  A booking type object which is used in the comparisons.
	 * @param guestID  A string variable representing the sought after booking's guest ID.
	 * @param fromDate A LocalDate type variable that represents the starting date of the
	 *                 sought after booking.
	 * @param toDate   A LocalDate type variable that represents the expiration date of the
	 *                 sought after booking.
	 * @return Returns a boolean answer on whether the booking with the specified guest ID, start date
	 * and end date is present within the booking's set.
	 */
	boolean compare(Booking booking, String guestID, LocalDate fromDate, LocalDate toDate) {
		if (guestID.equals(booking.getGuestId())) {
			return fromDate.equals(booking.getStartDate()) && toDate.equals(booking.getEndDate());
		}

		return false;
	}

	@Override
	public boolean equals(Object compareObject) {
		if (!(compareObject instanceof Room)) return false;
		return this.roomNumber == ((Room) compareObject).roomNumber;
	}

	@Override
	public int hashCode() {
		return this.roomNumber;
	}
}
