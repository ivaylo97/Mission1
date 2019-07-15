import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class BookingsTest {

	@Test
	void updateRoom() {
		Bookings testBooking = new Bookings();
		Rooms testBookRoom = new Rooms();
		LocalDate testStartDate = LocalDate.parse("2000-02-02");
		LocalDate testEndDate = LocalDate.parse("2000-02-02");
		testBooking.updateRoom("test",testStartDate,testEndDate,testBookRoom,1);
		assertTrue(testBooking.getGuestEGN().equals("test"));
		assertTrue(testBooking.getStartDate().equals(testStartDate));
		assertTrue(testBooking.getEndDate().equals(testEndDate));
		assertTrue(testBooking.getBookedRoom().equals(testBookRoom));
		assertTrue(testBooking.getNumberOfDays() == 1);
	}
}
