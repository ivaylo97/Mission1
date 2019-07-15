import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

	@Test
	void getNumberOfRooms(){
	}

	@Test
	void addNewRoom() {
		Hotel testHotel = new Hotel();
		Rooms testRoom = new Rooms();
		int idx = 0;
		testHotel.addNewRoom(idx,testRoom);
		assertFalse(testHotel.listOfRooms.isEmpty());
	}

	@Test
	void getHotelName() {

	}

	@Test
	void setHotelName() {
	}

	@Test
	void searchForRooms() {
		Rooms testRoom1 = new Rooms();
		Rooms testRoom2 = new Rooms();
		Hotel testHotel = new Hotel();

		testRoom1.setCommodities(3,0,0);
		testRoom2.setCommodities(2,0,0);

		testHotel.addNewRoom(0,testRoom1);
		testHotel.addNewRoom(1,testRoom2);
		assertFalse(testHotel.searchForRooms(3).isEmpty());
		assertTrue(testHotel.searchForRooms(3).size() == 1);

	}
}
