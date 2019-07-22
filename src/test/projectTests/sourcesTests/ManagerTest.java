package projectTests.sourcesTests;

import hotelserviceapp.hotelCommodities.BedTypes.BedTypes;
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
		int expectedBookedRoomNumber1;
		int expectedBookedRoomNumber2;
		//when
		testRoom1.setCommodities(1, 1, 1);
		testRoom2.setCommodities(3, 1, 2);
		testRoom3.setCommodities(2, 2, 2);

		transylvania.setHotelName("transylvania");
		Ivan.setHotel(transylvania);
		transylvania.addNewRoom(testRoom1);
		transylvania.addNewRoom(testRoom2);
		transylvania.addNewRoom(testRoom3);

		expectedBookedRoomNumber1 = Ivan.bookRoom("1111111111", configureDate("2019-08-20"), configureDate("2019-08-25"), 2, 5);
		expectedBookedRoomNumber2 = Ivan.bookRoom("2222222222", configureDate("2019-08-22"), configureDate("2019-08-23"), 1, 1);

		//then
		assertThrows(RuntimeException.class, () -> {
			Ivan.bookRoom("33333333333", configureDate("2019-08-19"), configureDate("2019-08-21"), 2, 2);
		});
		assertThrows(RuntimeException.class, () -> {
			Ivan.bookRoom("33333333333", configureDate("2019-08-19"), configureDate("2019-08-28"), 2, 2);
		});
		assertFalse(testRoom1.getBookings().isEmpty());
		assertTrue(testRoom2.getBookings().isEmpty());
		assertFalse(testRoom3.getBookings().isEmpty());
		assertEquals(4, expectedBookedRoomNumber1);
		assertEquals(2, expectedBookedRoomNumber2);


	}

	@Test
	void testBookRoomScenario1() {
		int expectedRoomNumber;
		//given
		testRoom1.addBeds(1, BedTypes.DOUBLE);
		transylvania.addNewRoom(0, testRoom1);
		Ivan.setHotel(transylvania);
		//when
		expectedRoomNumber = Ivan.bookRoom("peter-id11", configureDate("2020-01-01"), configureDate("2020-01-02"), 2, 1);
		//then
		assertEquals(1, expectedRoomNumber);
	}

	@Test
	void testBookRoomScenario2() {
		//given
		Ivan.setHotel(transylvania);
		//when + then
		assertThrows(RuntimeException.class, () -> {
			Ivan.bookRoom("peter-id11", configureDate("2020-01-01"), configureDate("2020-01-02"), 2, 1);
		});
	}

	@Test
	void testBookRoomScenario3() {
		//given
		testRoom1.addBeds(1, BedTypes.SINGLE);
		transylvania.addNewRoom(0, testRoom1);
		Ivan.setHotel(transylvania);
		//when
		assertThrows(RuntimeException.class, () -> {
			Ivan.bookRoom("peter-id11", configureDate("2020-01-01"), configureDate("2020-01-02"), 2, 1);
		});

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

		transylvania.addNewRoom(testRoom1);
		transylvania.addNewRoom(testRoom2);

		Ivan.setHotel(transylvania);
		Ivan.bookRoom(EGN, startDate, endDate, numberOfRequiredBeds, numberOfDays);
		//then
		assertTrue(Ivan.unBookRoom(EGN, startDate, endDate));
		assertThrows(RuntimeException.class, () -> {
			Ivan.unBookRoom(null, null, null);
		});
	}

	static LocalDate configureDate(String date) {
		return LocalDate.parse(date);
	}

}

