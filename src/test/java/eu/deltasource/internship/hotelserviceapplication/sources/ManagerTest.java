package eu.deltasource.internship.hotelserviceapplication.sources;

import eu.deltasource.internship.hotelserviceapplication.hotelCommodities.*;
import eu.deltasource.internship.hotelserviceapplication.hotelCommodities.BedTypes.*;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


class ManagerTest {

	private Manager Ivan;
	private Hotel testHotel;
	private Room testRoom1;
	private Room testRoom2;


	@BeforeEach
	void setUp() {
		Ivan = new Manager("Ivan");
		testHotel = new Hotel("testHotel");
		testRoom1 = new Room();
		testRoom2 = new Room();
		testRoom1.setRoomOwnerHotel(testHotel);
		testRoom2.setRoomOwnerHotel(testHotel);
	}

	@Test
	void testBookRoom() {
		//given
		Room testRoom3 = new Room();
		int expectedBookedRoomNumber1;
		int expectedBookedRoomNumber2;
		testRoom3.setRoomOwnerHotel(testHotel);
		//when
		testRoom1.setCommodities(1, BedTypes.SINGLE, 1, 1);
		testRoom2.setCommodities(3, BedTypes.SINGLE, 1, 2);
		testRoom3.setCommodities(2, BedTypes.SINGLE, 2, 2);


		testHotel.setHotelName("testHotel");
		Ivan.setHotel(testHotel);
		testHotel.addNewRoom(testRoom1);
		testHotel.addNewRoom(testRoom2);
		testHotel.addNewRoom(testRoom3);

		expectedBookedRoomNumber1 = Ivan.bookRoom("1111111111", configureDate("2019-08-20"), configureDate("2019-08-25"), 2);
		expectedBookedRoomNumber2 = Ivan.bookRoom("2222222222", configureDate("2019-08-22"), configureDate("2019-08-23"), 1);

		//then
		assertThrows(RuntimeException.class, () -> {
			Ivan.bookRoom("33333333333", configureDate("2019-08-19"), configureDate("2019-08-21"), 2);
		});
		assertThrows(RuntimeException.class, () -> {
			Ivan.bookRoom("33333333333", configureDate("2019-08-19"), configureDate("2019-08-28"), 2);
		});
		assertFalse(testRoom1.getBookings().isEmpty());
		assertTrue(testRoom2.getBookings().isEmpty());
		assertFalse(testRoom3.getBookings().isEmpty());
		assertEquals(3, expectedBookedRoomNumber1);
		assertEquals(1, expectedBookedRoomNumber2);


	}

	@Test
	void testBookRoomScenario1() {
		int expectedRoomNumber;
		//given
		testRoom1.addCommodity(new Bed(BedTypes.DOUBLE));
		testHotel.addNewRoom(testRoom1);
		Ivan.setHotel(testHotel);
		//when
		expectedRoomNumber = Ivan.bookRoom("peter-id11", configureDate("2020-01-01"), configureDate("2020-01-02"), 2);
		//then
		assertEquals(1, expectedRoomNumber);
	}

	@Test
	void testBookRoomScenario2() {
		//given
		Ivan.setHotel(testHotel);
		//when + then
		assertThrows(RuntimeException.class, () -> {
			Ivan.bookRoom("peter-id11", configureDate("2020-01-01"), configureDate("2020-01-02"), 2);
		});
	}

	@Test
	void testBookRoomScenario3() {
		//given
		testRoom1.addCommodity(new Bed(BedTypes.SINGLE));
		testHotel.addNewRoom(testRoom1);
		Ivan.setHotel(testHotel);
		//when
		assertThrows(RuntimeException.class, () -> {
			Ivan.bookRoom("peter-id11", configureDate("2020-01-01"), configureDate("2020-01-02"), 2);
		});

	}


	@Test
	void testUnBookRoom() {
		//given
		String EGN = "1111111111";
		LocalDate startDate = LocalDate.parse("2020-01-01");
		LocalDate endDate = LocalDate.parse("2020-02-02");
		int numberOfRequiredBeds = 3;
		Manager Ivan = new Manager("Ivan");
		Hotel transylvania = new Hotel("Ivan's Hotel");


		//when
		testRoom1.setCommodities(3, BedTypes.SINGLE, 1, 1);
		testRoom2.setCommodities(3, BedTypes.SINGLE, 1, 1);

		transylvania.addNewRoom(testRoom1);
		transylvania.addNewRoom(testRoom2);

		Ivan.setHotel(transylvania);
		Ivan.bookRoom(EGN, startDate, endDate, numberOfRequiredBeds);
		Ivan.unBookRoom(EGN,startDate,endDate);
		//then
		assertTrue(testRoom1.getBookings().isEmpty());
		assertThrows(RuntimeException.class, () -> {
			Ivan.unBookRoom(null, null, null);
		});
		assertThrows(RuntimeException.class, () -> {
			Ivan.unBookRoom("1234567890", null, null);
		});
	}
	@Test
	void testSetManagerName(){
		//given
		String managerName = "Ivan";
		//when
		Ivan.setManagerName(managerName);
		//then
		assertThrows(RuntimeException.class,()->{
			Ivan.setManagerName("");
		});
		assertEquals(managerName, Ivan.getManagerName());
	}
	@Test
	void testSetHotel(){
		//given
		Hotel nullHotel = null;
		//when + then
		assertThrows(RuntimeException.class,()->{
			Ivan.setHotel(nullHotel);
		});
	}

	static LocalDate configureDate(String date) {
		return LocalDate.parse(date);
	}

}

