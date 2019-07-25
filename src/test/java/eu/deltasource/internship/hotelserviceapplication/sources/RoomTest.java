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
	public void setUp() {
		testHotel = new Hotel("testHotel");
		testRoom = new Room();
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
		String guestEng = "11111111111";
		testHotel.addNewRoom(testRoom);
		//when
		testRoom.createBooking(guestEng, testStartDate, testEndDate);
		testRoom.removeBooking(guestEng, testStartDate, testEndDate);
		//then
		assertTrue(testRoom.getBookings().isEmpty());
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

}
