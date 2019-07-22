package projectTests;

import hotelserviceapp.sources.Room;
import hotelserviceapp.sources.Booking;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {

	@Test
	void testUpdateRoom() {
		//given
		Booking testBooking = new Booking();
		Room testBookRoom = new Room();
		LocalDate testStartDate = LocalDate.parse("2020-02-02");
		LocalDate testEndDate = LocalDate.parse("2020-02-02");
		//when
		testBooking.updateRoom("1111111111", testStartDate, testEndDate, testBookRoom, 1);
		//then
		assertTrue("1111111111".equals(testBooking.getGuestId()));
		assertTrue(testStartDate.equals(testBooking.getStartDate()));
		assertTrue(testEndDate.equals(testBooking.getEndDate()));
		assertTrue(testBookRoom.equals(testBooking.getBookedRoom()));

	}
	@Test
	void assertRoom() {
	}

	@Test
	void isPresentIn() {
	}
}

