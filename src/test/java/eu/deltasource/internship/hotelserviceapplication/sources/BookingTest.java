package eu.deltasource.internship.hotelserviceapplication.sources;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {

	private LocalDate testStartDate;
	private LocalDate testEndDate;
	@BeforeEach
	public void setUp(){
		 testStartDate = LocalDate.parse("2020-02-02");
		 testEndDate = LocalDate.parse("2020-02-02");
	}

	@Test
	void testUpdateBooking() {
		//given
		Hotel testHotel = new Hotel("TestHotel");

		Room testBookRoom = new Room();
		testHotel.addNewRoom(testBookRoom);
		LocalDate testStartDate = LocalDate.parse("2020-02-02");
		LocalDate testEndDate = LocalDate.parse("2020-02-03");
		Booking testBooking = new Booking("1111111111", testStartDate, testEndDate);

		//then
		assertTrue("1111111111".equals(testBooking.getGuestId()));
		assertTrue(testStartDate.equals(testBooking.getStartDate()));
		assertTrue(testEndDate.equals(testBooking.getEndDate()));
		assertThrows(RuntimeException.class,()->{
			testBooking.updateBooking(null,testStartDate,testEndDate);
		});
		assertThrows(RuntimeException.class,()->{
			testBooking.updateBooking("123456789",testStartDate,testEndDate);
		});
		assertThrows(RuntimeException.class,()->{
			testBooking.updateBooking("1234567890",testEndDate,testStartDate);
		});
		assertThrows(RuntimeException.class,()->{
			testBooking.updateBooking("1234567890",null,testEndDate);
		});
		assertThrows(RuntimeException.class,()->{
			testBooking.updateBooking("1234567890",LocalDate.parse("1997-01-01"),testEndDate);
		});
		assertThrows(RuntimeException.class,()->{
			testBooking.updateBooking("1234567890",testStartDate,LocalDate.parse("1997-01-01"));
		});
	}

	@Test
	void isPresentIn() {
		//given
		Booking presentBooking = new Booking("1111111111", testStartDate, testEndDate);
		Booking notPresentBooking = new Booking("1111112222", testStartDate, testEndDate);
		Set bookings = new HashSet();

		//when
		bookings.add(presentBooking);

		//then
		assertTrue(presentBooking.isPresentIn(bookings));
		assertFalse(notPresentBooking.isPresentIn(bookings));

	}
}

