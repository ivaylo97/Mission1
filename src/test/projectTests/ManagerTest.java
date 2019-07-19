package projectTests;

import hotelserviceapp.sources.*;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


class ManagerTest {

	private Manager Ivan;
	private Hotel transylvania;
	private Room testRoom1;
	private Room testRoom2;

	@BeforeEach
	void setUp() {
		Ivan = new Manager();
		transylvania = new Hotel();
		testRoom1 = new Room();
		testRoom2 = new Room();
	}

	@Test
	void testBookRoom() {
		//given
		Room testRoom3 = new Room();
		//when
		testRoom1.setCommodities(1, 1, 1);
		testRoom2.setCommodities(3, 1, 2);
		testRoom3.setCommodities(2, 2, 2);

		transylvania.setHotelName("transylvania");
		Ivan.setHotel(transylvania);
		transylvania.addNewRoom(0, testRoom1);
		transylvania.addNewRoom(1, testRoom2);
		transylvania.addNewRoom(2, testRoom3);

		Ivan.bookRoom("1111111111", configureDate("2019-08-20"), configureDate("2019-08-25"), 2, 5);
		Ivan.bookRoom("2222222222", configureDate("2019-08-22"), configureDate("2019-08-23"), 1, 1);
		Ivan.bookRoom("33333333333", configureDate("2019-08-19"), configureDate("2019-08-21"), 2, 2);
		//then
		assertFalse(testRoom1.getBookings().isEmpty());
		assertTrue(testRoom2.getBookings().isEmpty());
		assertFalse(testRoom3.getBookings().isEmpty());


	}


	@Test
	void testUnBookRoom() {
		//given
		String EGN = "1111111111";
		LocalDate startDate = LocalDate.parse("2020-01-01");
		LocalDate endDate = LocalDate.parse("2020-02-02");
		int numberOfRequiredBeds = 3;
		int numberOfDays = 5;
		Manager Ivan = new Manager();
		Hotel transylvania = new Hotel();

		//when
		testRoom1.setCommodities(3, 1, 1);
		testRoom2.setCommodities(3, 1, 1);

		transylvania.addNewRoom(0, testRoom1);
		transylvania.addNewRoom(1, testRoom2);

		Ivan.setHotel(transylvania);
		Ivan.bookRoom(EGN, startDate, endDate, numberOfRequiredBeds, numberOfDays);
		//then
		assertTrue(Ivan.getManagedHotel().listOfRooms.get(0).removeBooking(EGN, startDate, endDate));
	}

	static LocalDate configureDate(String date) {
		return LocalDate.parse(date);
	}

}

