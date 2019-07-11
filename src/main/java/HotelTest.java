import static org.junit.jupiter.api.Assertions.*;

class HotelTest {
	Hotel testHotel = new Hotel();

	@org.junit.jupiter.api.Test
	void getNumberOfRooms() {
		assertEquals(1, testHotel.getNumberOfRooms());
	}

	@org.junit.jupiter.api.Test
	void initNumberOfRooms() {
		assertEquals(1, testHotel.getNumberOfRooms());
	}


	@org.junit.jupiter.api.Test
	void addNewRoom() {
		Rooms testRoom = new Rooms();
		testHotel.addNewRoom(0,testRoom);
		assertEquals(2,testHotel.getNumberOfRooms());

	}

	@org.junit.jupiter.api.Test
	void getHotelName() {
		testHotel.setHotelName("TestHotelName");
		assertSame("TestHotelName",testHotel.getHotelName());
	}

	@org.junit.jupiter.api.Test
	void setHotelName() {
		testHotel.setHotelName("TestHotelName");
		assertSame("TestHotelName",testHotel.getHotelName());
	}

	@org.junit.jupiter.api.Test
	void searchForFreeRooms() {
		Rooms testRoom = new Rooms();
		testHotel.addNewRoom(0,testRoom);
		assertTrue(testHotel.searchForFreeRooms().isEmpty());
	}
}
