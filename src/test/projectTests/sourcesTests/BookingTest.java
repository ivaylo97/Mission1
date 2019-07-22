package projectTests.sourcesTests;

import hotelserviceapp.sources.Hotel;
import hotelserviceapp.sources.Room;
import hotelserviceapp.sources.Booking;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {

	@Test
	void testUpdateRoom() {
		//given
		Hotel testHotel = new Hotel();
		Booking testBooking = new Booking();
		Room testBookRoom = new Room();
		testHotel.addNewRoom(testBookRoom);
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
	void testAssertRoom() {
		//given
		Booking testBooking = new Booking();
		assertThrows(RuntimeException.class, () -> {
			testBooking.assertRoom(null);
		});

	}

	@Test
	void isPresentIn() {
		Booking presentBooking = new Booking();
		Booking notPresentBooking = new Booking();
		Set bookings = new HashSet();
		bookings.add(presentBooking);
		assertTrue(presentBooking.isPresentIn(bookings));
		assertFalse(notPresentBooking.isPresentIn(bookings));

	}
}

