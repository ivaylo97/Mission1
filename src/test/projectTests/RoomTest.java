package projectTests;

import hotelserviceapp.hotelCommodities.BedTypes.BedTypes;
import hotelserviceapp.sources.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
	Room testRoom;

	@BeforeEach
	public void setUp() {
		testRoom = new Room();
	}

	@Test
	void testInitNumberOfRooms() {
		assertTrue(testRoom.getRoomNumber() == 1);
	}

	@Test
	void testMaintainRoom() {
		//given
		LocalDate testMaintenanceDate = LocalDate.parse("2020-01-01");
		//when
		testRoom.maintainRoom(testMaintenanceDate);
		//then
		assertFalse(testRoom.getMaintenanceDates().isEmpty());
	}

	@Test
	void testCreateBooking() {
		//given
		int testNumberOfDays = 365;
		int expectedBookedRoomNumber ;
		LocalDate testStartDate = LocalDate.parse("2020-01-01");
		LocalDate testEndDate = LocalDate.parse("2020-02-02");
		String guestEng = "1111111111";
		//when
		expectedBookedRoomNumber = testRoom.createBooking(guestEng, testStartDate, testEndDate, testRoom, testNumberOfDays);
		//then
		assertFalse(testRoom.getBookings().isEmpty());
		assertTrue(expectedBookedRoomNumber == 1);
	}


	@Test
	void testRemoveBooking() {
		//given
		int testNumberOfDays = 365;
		LocalDate testStartDate = LocalDate.parse("2020-01-01");
		LocalDate testEndDate = LocalDate.parse("2020-02-02");
		String guestEng = "11111111111";
		//when
		testRoom.createBooking(guestEng, testStartDate, testEndDate, testRoom, testNumberOfDays);
		testRoom.removeBooking(guestEng, testStartDate, testEndDate);
		//then
		assertTrue(testRoom.getBookings().isEmpty());
	}

	@Test
	void testRemoveAllBookings() {
		//given
		int testNumberOfDays = 365;
		LocalDate testStartDate = LocalDate.parse("2020-01-01");
		LocalDate testEndDate = LocalDate.parse("2020-02-02");
		String guestEng = "1111111111";
		//when
		testRoom.createBooking(guestEng, testStartDate, testEndDate, testRoom, testNumberOfDays);
		testRoom.removeAllBookings();
		//then
		assertTrue(testRoom.getBookings().isEmpty());
	}

	@Test
	void testSetCommodities() {
		//given
		int numberOfBeds = 3;
		int numberOfToilets = 3;
		int numberOfShowers = 3;
		//when
		testRoom.setCommodities(numberOfBeds, numberOfShowers, numberOfToilets);
		//then
		assertFalse(testRoom.getCommodities().isEmpty());
		assertTrue(testRoom.getRoomCapacity() == 3);
		assertTrue(testRoom.getNumberOfShowers() == 3);
		assertTrue(testRoom.getNumberOfToilets() == 3);
	}

	@Test
	void setCommodities1() {
		//given
		int numberOfBeds = 3;
		int numberOfToilets = 3;
		int numberOfShowers = 3;
		//when
		testRoom.setCommodities(numberOfBeds, BedTypes.DOUBLE, numberOfShowers, numberOfToilets);
		//then
		assertFalse(testRoom.getCommodities().isEmpty());
		assertTrue(testRoom.getRoomCapacity() == 6);
		assertTrue(testRoom.getNumberOfShowers() == 3);
		assertTrue(testRoom.getNumberOfToilets() == 3);
	}

	@Test
	void addBeds() {
		//given
		int numberOfBedsToAdd = 5;
		//when
		testRoom.addBeds(numberOfBedsToAdd, BedTypes.KING_SIZE);
		//then
		assertTrue(testRoom.getRoomCapacity() == 10);

	}

	@Test
	void addShowers() {
		//given
		int numberOfShowersToAdd = 3 ;
		//when
		testRoom.addShowers(numberOfShowersToAdd);
		//then
		assertTrue(testRoom.getNumberOfShowers() == 3);
	}

	@Test
	void addToilets() {
		//given
		int numberOfToiletsToAdd = 5 ;
		//when
		testRoom.addToilets(numberOfToiletsToAdd);
		//then
		assertTrue(testRoom.getNumberOfToilets() == 5);
	}
}
