import hotelserviceapp.sources.Rooms;
import hotelserviceapp.sources.Booking;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {

	@Test
	void updateRoom() {
		//given
		Booking testBooking = new Booking();
		Rooms testBookRoom = new Rooms();
		LocalDate testStartDate = LocalDate.parse("2000-02-02");
		LocalDate testEndDate = LocalDate.parse("2000-02-02");
		//when
		testBooking.updateRoom("test", testStartDate, testEndDate, testBookRoom, 1);
		//then
		assertTrue(testBooking.getGuestEGN().equals("test"));
		assertTrue(testBooking.getStartDate().equals(testStartDate));
		assertTrue(testBooking.getEndDate().equals(testEndDate));
		assertTrue(testBooking.getBookedRoom().equals(testBookRoom));
		assertTrue(testBooking.getNumberOfDays() == 1);
	}
}

