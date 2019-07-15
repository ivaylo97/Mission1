import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class RoomsTest {


	@Test
	void initNumberOfRooms() {
		Rooms testRoom = new Rooms();
		assertTrue(testRoom.getRoomNumber() == 1);
	}

	@Test
	void roomMaintenance() {
		LocalDate testMaintenanceDate = LocalDate.parse("2001-01-01");
		Rooms testRoom = new Rooms();
		testRoom.roomMaintenance(testMaintenanceDate);
		assertFalse(testRoom.maintenanceDates.isEmpty());
	}

	@Test
	void createBooking() {
		int testNumberOfDays = 365 ;
		Rooms testRoomToBeBooked = new Rooms();
		LocalDate testStartDate = LocalDate.parse("2001-01-01");
		LocalDate testEndDate = LocalDate.parse("2002-02-02");
		String guestEng = "1";
		testRoomToBeBooked.createBooking(guestEng,testStartDate,testEndDate,testRoomToBeBooked,testNumberOfDays);
		assertFalse(testRoomToBeBooked.bookingsSet.isEmpty());
	}

	@Test
	void createBooking1() {
		Bookings testBooking = new Bookings();
		Rooms testBookRoom = new Rooms();
		LocalDate testStartDate = LocalDate.parse("2000-02-02");
		LocalDate testEndDate = LocalDate.parse("2000-02-02");
		testBooking.updateRoom("test",testStartDate,testEndDate,testBookRoom,1);

		testBookRoom.createBooking(testBooking);
		assertFalse(testBookRoom.bookingsSet.isEmpty());
	}

	@Test
	void removeBooking() {
		int testNumberOfDays = 365 ;
		Rooms testRoomToBeUnbooked = new Rooms();
		LocalDate testStartDate = LocalDate.parse("2001-01-01");
		LocalDate testEndDate = LocalDate.parse("2002-02-02");
		String guestEng = "1";

		testRoomToBeUnbooked.createBooking(guestEng,testStartDate,testEndDate,testRoomToBeUnbooked,testNumberOfDays);
		assertFalse(testRoomToBeUnbooked.bookingsSet.isEmpty());

		testRoomToBeUnbooked.removeBooking(guestEng,testStartDate,testEndDate);
		assertTrue(testRoomToBeUnbooked.bookingsSet.isEmpty());
	}

	@Test
	void removeAllBookings() {
		Bookings testBooking = new Bookings();
		Rooms testBookRoom = new Rooms();
		LocalDate testStartDate = LocalDate.parse("2000-02-02");
		LocalDate testEndDate = LocalDate.parse("2000-02-02");
		testBooking.updateRoom("test",testStartDate,testEndDate,testBookRoom,1);

		testBookRoom.createBooking(testBooking);

		testBookRoom.removeAllBookings();
		assertTrue(testBookRoom.bookingsSet.isEmpty());
	}

	@Test
	void setCommodities() {
		int numberOfBeds = 1 ;
		int numberoOfToilets  = 3;
		int numberOfShowers = 3 ;
		Rooms testRoom = new Rooms();
		testRoom.setCommodities(numberOfBeds,numberOfShowers,numberoOfToilets);
		assertFalse(testRoom.commodities.isEmpty());
		assertTrue(testRoom.getNumberOfBeds()== 1);
		assertTrue(testRoom.getNumberOfShowers() == 3);
		assertTrue(testRoom.getNumberOfToilets() == 3);
	}

	@Test
	void getNumberOfBeds() {

	}

	@Test
	void getNumberOfShowers() {
	}

	@Test
	void getNumberOfToilets() {
	}
}
