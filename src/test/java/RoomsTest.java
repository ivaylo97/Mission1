package java;

import hotelserviceapp.sources.Rooms;
import hotelserviceapp.sources.Booking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class RoomsTest {
Rooms testRoom;

	@BeforeEach
	public void setUp() {
		testRoom = new Rooms();
	}

	@Test
	void initNumberOfRooms() {
		//given @BeforeEach
		//when testRoom.getRoomNumber();
		//then
		assertTrue(testRoom.getRoomNumber() == 1);
	}

	@Test
	void roomMaintenance() {
		//given
		LocalDate testMaintenanceDate = LocalDate.parse("2001-01-01");
		//when
		testRoom.maintainRoom(testMaintenanceDate);
		//then
		assertFalse(testRoom.getMaintenanceDates().isEmpty());
	}

	@Test
	void createBooking() {
		//given
		int testNumberOfDays = 365;
		LocalDate testStartDate = LocalDate.parse("2001-01-01");
		LocalDate testEndDate = LocalDate.parse("2002-02-02");
		String guestEng = "1111111111";
		//when
		testRoom.createBooking(guestEng, testStartDate, testEndDate, testRoom, testNumberOfDays);
		//then
		assertFalse(testRoom.getBookings().isEmpty());
	}

	@Test
	void createBooking1() {
		//given
		Booking testBooking = new Booking();
		LocalDate testStartDate = LocalDate.parse("2000-02-02");
		LocalDate testEndDate = LocalDate.parse("2000-02-02");
		//when
		testBooking.updateRoom("1111111111", testStartDate, testEndDate, testRoom, 1);
		testRoom.createBooking(testBooking);
		//then
		assertFalse(testRoom.getBookings().isEmpty());
	}

	@Test
	void removeBooking() {
		//given
		int testNumberOfDays = 365;
		LocalDate testStartDate = LocalDate.parse("2001-01-01");
		LocalDate testEndDate = LocalDate.parse("2002-02-02");
		String guestEng = "11111111111";
		//when
		testRoom.createBooking(guestEng, testStartDate, testEndDate, testRoom, testNumberOfDays);
		testRoom.removeBooking(guestEng, testStartDate, testEndDate);
		//then
		assertTrue(testRoom.getBookings().isEmpty());
	}

	@Test
	void removeAllBookings() {
		//given
		Booking testBooking = new Booking();
		LocalDate testStartDate = LocalDate.parse("2000-02-02");
		LocalDate testEndDate = LocalDate.parse("2000-02-02");
		//when
		testBooking.updateRoom("1111111111", testStartDate, testEndDate, testRoom, 1);
		testRoom.createBooking(testBooking);
		testRoom.removeAllBookings();
		//then
		assertTrue(testRoom.getBookings().isEmpty());
	}

	@Test
	void setCommodities() {
		//given
		int numberOfBeds = 1;
		int numberOfToilets = 3;
		int numberOfShowers = 3;
		//when
		testRoom.setCommodities(numberOfBeds, numberOfShowers, numberOfToilets);
		//then
		assertFalse(testRoom.getCommodities().isEmpty());
		assertTrue(testRoom.getNumberOfBeds() == 1);
		assertTrue(testRoom.getNumberOfShowers() == 3);
		assertTrue(testRoom.getNumberOfToilets() == 3);
	}
}
