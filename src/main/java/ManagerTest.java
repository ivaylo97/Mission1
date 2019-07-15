import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

	@Test
	void setHotel() {
	}

	@Test
	void bookRoom() {
		Manager Ivan = new Manager();
		Hotel transylvania = new Hotel();
		Rooms room101 = new Rooms();
		Rooms room102 = new Rooms();
		Rooms room103 = new Rooms();
		ArrayList<Rooms> tempList;

		room101.setCommodities(1, 1, 1);
		room102.setCommodities(3, 1, 2);
		room103.setCommodities(2,2,2);

		transylvania.setHotelName("transylvania");
		Ivan.setHotel(transylvania);
		Ivan.managedHotel = transylvania;
		transylvania.addNewRoom(0, room101);
		transylvania.addNewRoom(1, room102);
		transylvania.addNewRoom(2, room103);

 /*
 TO DO
  */

		Ivan.bookRoom("1111111111", configureDate("2019-07-20"), configureDate("2019-07-25"), 2, 5);
		Ivan.bookRoom("2222222222", configureDate("2019-07-22"), configureDate("2019-07-23"), 1, 1);
		Ivan.bookRoom("33333333333",configureDate("2019-07-19"),configureDate("2019-07-21"),2,2);

		assertFalse(room101.bookingsSet.isEmpty());
		assertTrue(room102.bookingsSet.isEmpty());
		assertFalse(room103.bookingsSet.isEmpty());


	}


	@Test
	void unBookRoom() {
		String EGN ="1" ;
		LocalDate startDate = LocalDate.parse("2001-01-01");
		LocalDate endDate = LocalDate.parse("2002-02-02");
		int numberOfRequiredBeds = 3;
		int numberOfDays = 5 ;
		Manager testManager = new Manager();
		Hotel testHotel = new Hotel();
		Rooms testRoom1 = new Rooms();
		Rooms testRoom2 = new Rooms();
		testRoom1.setCommodities(3,1,1);
		testRoom2.setCommodities(3,1,1);

		testHotel.addNewRoom(0,testRoom1);
		testHotel.addNewRoom(1,testRoom2);

		testManager.setHotel(testHotel);

		testManager.bookRoom(EGN,startDate,endDate,numberOfRequiredBeds,numberOfDays);

		assertTrue(testManager.managedHotel.listOfRooms.get(0).removeBooking(EGN,startDate,endDate));
	}
	static LocalDate configureDate(String date){
		return LocalDate.parse(date);
	};
}
/*
	@Test
	void bookRoom() {
		String EGN ="1" ;
		LocalDate startDate = LocalDate.parse("2001-01-01");
		LocalDate endDate = LocalDate.parse("2002-02-02");
		int numberOfRequiredBeds = 3;
		int numberOfDays = 5 ;
		Manager testManager = new Manager();
		Hotel testHotel = new Hotel();
		Rooms testRoom1 = new Rooms();
		Rooms testRoom2 = new Rooms();
		Rooms testRoom3 = new Rooms();

		testRoom1.setCommodities(1,1,1);
		testRoom2.setCommodities(3,1,2);
		testRoom3.setCommodities(2,1,1);

		testHotel.addNewRoom(0,testRoom1);
		testHotel.addNewRoom(1,testRoom2);
		testHotel.addNewRoom(2,testRoom3);

		testManager.setHotel(testHotel);
		testManager.bookRoom("EGN")
		testManager.bookRoom(EGN,startDate,endDate,numberOfRequiredBeds,numberOfDays);

		assertFalse(testRoom1.bookingsSet.isEmpty());
	}

 */
