package eu.deltasource.internship.hotelserviceapplication.sources;

import eu.deltasource.internship.hotelserviceapplication.hotelCommodities.Bed;
import eu.deltasource.internship.hotelserviceapplication.hotelCommodities.BedTypes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
	private Room testRoom;
	private Hotel testHotel;

	@BeforeEach
	void setUp() {
		testHotel = new Hotel("testHotel");
		testRoom = new Room();
	}


	@Test
	void testMaintainRoom() {
		//given
		LocalDate testMaintenanceDate = LocalDate.parse("2020-01-01");
		LocalDate nullMaintenanceDate = null;
		//when
		testRoom.maintainRoom(testMaintenanceDate);
		//then
		assertFalse(testRoom.getMaintenanceDates().isEmpty());
		assertThrows(RuntimeException.class, () -> {
			testRoom.maintainRoom(nullMaintenanceDate);
		});
	}

	@Test
	void testCreateBooking() {
		//given
		int expectedBookedRoomNumber;
		LocalDate testStartDate = LocalDate.parse("2020-01-01");
		LocalDate testEndDate = LocalDate.parse("2020-02-02");
		String guestEng = "1111111111";
		testHotel.addNewRoom(testRoom);
		//when
		expectedBookedRoomNumber = testRoom.createBooking(guestEng, testStartDate, testEndDate);
		//then
		assertThrows(RuntimeException.class, () -> {
			testRoom.createBooking(guestEng, testStartDate, testEndDate);
		});
		assertFalse(testRoom.getBookings().isEmpty());
		assertEquals(1, expectedBookedRoomNumber);
	}


	@Test
	void testRemoveBooking() {
		//given
		LocalDate testStartDate = LocalDate.parse("2020-01-01");
		LocalDate testEndDate = LocalDate.parse("2020-02-02");
		LocalDate nullDate = null;
		String guestID = "11111111111";
		testHotel.addNewRoom(testRoom);
		//when
		testRoom.createBooking(guestID, testStartDate, testEndDate);
		testRoom.removeBooking(guestID, testStartDate, testEndDate);
		//then
		assertTrue(testRoom.getBookings().isEmpty());
		assertThrows(RuntimeException.class, () -> {
			testRoom.removeBooking(guestID, nullDate, testEndDate);
		});
		assertThrows(RuntimeException.class, () -> {
			testRoom.removeBooking(guestID, testStartDate, nullDate);
		});
	}

	@Test
	void testRemoveAllBookings() {
		//given
		Hotel testHotel = new Hotel("testHotel");
		LocalDate testStartDate = LocalDate.parse("2020-01-01");
		LocalDate testEndDate = LocalDate.parse("2020-02-02");
		String guestEng = "1111111111";
		testHotel.addNewRoom(testRoom);
		//when
		testRoom.createBooking(guestEng, testStartDate, testEndDate);
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
		testRoom.setCommodities(numberOfBeds, BedTypes.SINGLE, numberOfShowers, numberOfToilets);
		//then
		assertFalse(testRoom.getCommodities().isEmpty());
		assertEquals(3, testRoom.getRoomCapacity());
		assertEquals(3, testRoom.getNumberOfShowers());
		assertEquals(3, testRoom.getNumberOfToilets());
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
		assertEquals(6, testRoom.getRoomCapacity());
		assertEquals(3, testRoom.getNumberOfShowers());
		assertEquals(3, testRoom.getNumberOfToilets());
	}

	@Test
	void testAddCommodity() {
		//given
		Bed bed1 = new Bed(BedTypes.SINGLE);
		Bed nullBed = null;
		//when
		testRoom.addCommodity(bed1);
		//then
		assertThrows(RuntimeException.class, () -> {
			testRoom.addCommodity(nullBed);
		});
		assertThrows(RuntimeException.class, () -> {
			testRoom.addCommodity(bed1);
		});
	}

	@Test
	void testCheckAvailability() {
		//given
		String guestID = "0123456789";
		LocalDate startDate = LocalDate.of(2020, 3, 3);
		LocalDate endDate = LocalDate.of(2020, 3, 20);
		//when
		testRoom.createBooking(guestID, startDate, endDate);
		//then
		assertFalse(testRoom.checkAvailability(LocalDate.of(2020, 3, 4), LocalDate.of(2020, 3, 17)));
	}

	@Test
	void testCompare() {
		//given
		String guestID = "0123456789";
		LocalDate startDate = LocalDate.of(2020, 3, 3);
		LocalDate endDate = LocalDate.of(2020, 3, 20);
		testRoom.createBooking(guestID, startDate, endDate);
		Booking testBooking = testRoom.getBookings().iterator().next();
		//when + then
		assertTrue(testRoom.compare(testBooking, guestID, startDate, endDate));
		assertFalse(testRoom.compare(testBooking, "1234567890", startDate, endDate));
	}
}
