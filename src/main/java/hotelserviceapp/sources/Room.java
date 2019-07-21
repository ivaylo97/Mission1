package hotelserviceapp.sources;


import hotelserviceapp.Support.*;
import hotelserviceapp.hotelCommodities.*;
import hotelserviceapp.hotelCommodities.BedTypes.BedTypes;
import hotelserviceapp.hotelCommodities.domain.AbstractCommodity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Room {
	static private int TOTAL_NUMBER_OF_ROOMS = 0;
	private int roomNumber;
	private int roomCapacity;
	private int numberOfShowers;
	private int numberOfToilets;
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
		TOTAL_NUMBER_OF_ROOMS++;
		roomNumber = TOTAL_NUMBER_OF_ROOMS;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	/**
	 * This method invokes all of the commodities available for the maintenance of the room.
	 *
	 * @param newMaintenanceDate A Date typed object that represents a date at which the room is under maintenance.
	 */
	public void maintainRoom(LocalDate newMaintenanceDate) {

		if (newMaintenanceDate != null) {
			for (AbstractCommodity commodity : commodities) {
				commodity.prepare();
			}
			maintenanceDates.add(newMaintenanceDate);
		}
	}

	/**
	 * This method takes the guest's EGN , fromDate to tell us which is the booking's starting day , and
	 * toDate to tell us which is the booking's last day.And roomToBeBooked which is used to address the room
	 * that is to be booked.
	 * It later traverses the booking set and checks whether the selected dates are already booked by checking whether the
	 * starting/end dates are already present in the booking set.
	 * Returns room number on successful booking , and negative value on failure.
	 *
	 * @param guestEGN       newGuestEGN is a string type variable , containing the guest's EGN number.
	 * @param fromDate       fromDate is a LocalDate type variable which contains the requested booking's starting date.
	 * @param toDate         toDate is a LocalDate type variable which contains the requested booking's end date .
	 * @param roomToBeBooked roomToBeBooked is an object which represents the room that is being booked.
	 * @param numberOfDays   numberOfDays is an integer type variable which represents the number of days for which the room will be booked.
	 */
	public int createBooking(String guestEGN, LocalDate fromDate, LocalDate toDate, Room roomToBeBooked, int numberOfDays) {
		Booking objectToBeBooked = new Booking();
		objectToBeBooked.updateRoom(guestEGN, fromDate, toDate, roomToBeBooked, numberOfDays);

		if (!objectToBeBooked.isPresentIn(bookings)) {
			if (checkAvailability(objectToBeBooked)) {
				bookings.add(objectToBeBooked);
				return roomNumber;
			}
		}
		throw new BookingAlreadyExistsException();
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

	public boolean removeBooking(String guestId, LocalDate fromDate, LocalDate toDate) {
		Iterator<Booking> temporaryIterator = bookings.iterator();
		Booking tempBooking;
		while (temporaryIterator.hasNext()) {
			tempBooking = temporaryIterator.next();
			if (guestId.equals(tempBooking.getGuestId())) {
				if (tempBooking.getStartDate().equals(fromDate) && tempBooking.getEndDate().equals(toDate)) {
					temporaryIterator.remove();
					System.out.println("Booking remove successful!");
					return true;
				}
			}
		}
		throw new BookingRemovalFailureException();
	}

	/**
	 * Removes all of the bookings currently present in the booking set.
	 */
	public void removeAllBookings() {
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
	public void setCommodities(int newNumberOfBeds, BedTypes bedType, int newNumberOfShowers, int newNumberOfToilets) {
		addBeds(newNumberOfBeds, bedType);
		addShowers(newNumberOfShowers);
		addToilets(newNumberOfToilets);
	}

	public void setCommodities(int newNumberOfBeds, int newNumberOfShowers, int newNumberOfToilets) {
		addBeds(newNumberOfBeds, null);
		addShowers(newNumberOfShowers);
		addToilets(newNumberOfToilets);
	}

	/**
	 * Returns the number of beds in the room.
	 *
	 * @return roomCapacity
	 */
	public int getRoomCapacity() {
		return roomCapacity;
	}

	/**
	 * Returns the number of showers in the room.
	 *
	 * @return numberOfShowers
	 */
	public int getNumberOfShowers() {
		return numberOfShowers;
	}

	/**
	 * Returns the number of toilets in the room.
	 *
	 * @return numberOfToilets
	 */
	public int getNumberOfToilets() {
		return numberOfToilets;
	}

	public Set<LocalDate> getMaintenanceDates() {
		return maintenanceDates;
	}

	public Set<Booking> getBookings() {
		return bookings;
	}

	public Set<AbstractCommodity> getCommodities() {
		return commodities;
	}

	/**
	 * Checks whether the passed as a formal parameter booking has any conflicts with the already present bookings in
	 * the set of bookings.
	 *
	 * @param objectToBeBooked Represents the object that we would want add to the bookings set.
	 * @return Returns boolean answer on whether there were any date conflicts.
	 */
	private boolean checkAvailability(Booking objectToBeBooked) {
		LocalDate objectToBeBookedStartDate = objectToBeBooked.getStartDate();
		LocalDate objectToBeBookedEndDate = objectToBeBooked.getEndDate();

		if (!bookings.isEmpty()) {
			for (Booking temporaryObject : bookings) {
				if (objectToBeBookedStartDate.isAfter(temporaryObject.getStartDate())) {
					if (objectToBeBookedStartDate.isBefore(temporaryObject.getEndDate())) {
						throw new OverlappingStartingDateException();
					}
				} else {
					if (objectToBeBookedEndDate.isAfter(temporaryObject.getStartDate())) {
						throw new OverlappingEndDateException();
					}
				}
			}
		}
		return true;
	}


	/**
	 * Adds as much beds as specified in the numberOfBedsToAdd variable,of the specified type.
	 */
	public void addBeds(int numberOfBedsToAdd, BedTypes bedType) {
		Bed newBed;
		if (bedType == null) {
			bedType = BedTypes.SINGLE;
		}
		for (int bedCounter = 0; bedCounter < numberOfBedsToAdd; bedCounter++) {
			newBed = new Bed(bedType.toString());
			if (!commodities.contains(newBed)) {
				commodities.add(newBed);
				newBed.deployBed();
				roomCapacity += bedType.getBedCapacity();
			}
		}
	}

	/**
	 * Adds as much showers as, are specified in the numberOfShowersToAdd variable.
	 */
	public void addShowers(int numberOfShowersToAdd) {
		Shower newShower;
		for (int showerCounter = 0; showerCounter < numberOfShowersToAdd; showerCounter++) {
			newShower = new Shower();
			if (!commodities.contains(newShower)) {
				commodities.add(newShower);
				numberOfShowers++;
			}
		}
	}

	/**
	 * Adds as much toilets as specified in the numberOfToiletsToAdd variable.
	 */
	public void addToilets(int numberOfToiletsToAdd) {
		Toilet newToilet;
		for (int toiletCounter = 0; toiletCounter < numberOfToiletsToAdd; toiletCounter++) {
			newToilet = new Toilet();
			if (!commodities.contains(newToilet)) {
				commodities.add(newToilet);
				numberOfToilets++;
			}
		}
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
