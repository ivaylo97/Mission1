package eu.deltasource.internship.hotelserviceapplication.sources;

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
		testHotel = new Hotel();
		testRoom = new Room();
		testRoom.setRoomOwnerHotel(testHotel);
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
		int expectedBookedRoomNumber;
		LocalDate testStartDate = LocalDate.parse("2020-01-01");
		LocalDate testEndDate = LocalDate.parse("2020-02-02");
		String guestEng = "1111111111";
		testHotel.addNewRoom(testRoom);
		Booking booking = new Booking(guestEng,testStartDate,testEndDate,testRoom);
		//when
		expectedBookedRoomNumber = testRoom.createBooking(guestEng, testStartDate, testEndDate, testRoom, testNumberOfDays);
		//then
		assertThrows(RuntimeException.class,()->{
			testRoom.createBooking(booking);
		});
		assertFalse(testRoom.getBookings().isEmpty());
		assertEquals(2, expectedBookedRoomNumber);
	}


	@Test
	void testRemoveBooking() {
		//given
		int testNumberOfDays = 365;
		LocalDate testStartDate = LocalDate.parse("2020-01-01");
		LocalDate testEndDate = LocalDate.parse("2020-02-02");
		String guestEng = "11111111111";
		testHotel.addNewRoom(testRoom);
		//when
		testRoom.createBooking(guestEng, testStartDate, testEndDate, testRoom, testNumberOfDays);
		testRoom.removeBooking(guestEng, testStartDate, testEndDate);
		//then
		assertTrue(testRoom.getBookings().isEmpty());
	}

	@Test
	void testRemoveAllBookings() {
		//given
		Hotel testHotel = new Hotel();
		int testNumberOfDays = 365;
		LocalDate testStartDate = LocalDate.parse("2020-01-01");
		LocalDate testEndDate = LocalDate.parse("2020-02-02");
		String guestEng = "1111111111";
		testHotel.addNewRoom(testRoom);
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
		testRoom.setCommodities(numberOfBeds,BedTypes.SINGLE, numberOfShowers, numberOfToilets);
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


}
