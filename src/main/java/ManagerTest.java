import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

	Manager testManager = new Manager();
	Hotel testHotel = new Hotel();

	@org.junit.jupiter.api.Test
	void getHotel() {
		testHotel.setHotelName("Test");
		testManager.setHotel(testHotel);
		assertSame("Test", testManager.getHotelName());
	}

	@org.junit.jupiter.api.Test
	void getManagerName() {
		testManager.setManagerName("TestManagerName");
		assertSame("TestManagerName", testManager.getManagerName());
	}

	@org.junit.jupiter.api.Test
	void setManagerName() {
		testManager.setManagerName("TestManagerName");
		assertSame("TestManagerName", testManager.getManagerName());
	}

	@org.junit.jupiter.api.Test
	void setHotelName() {
		testHotel.setHotelName("Test");
		testManager.setHotel(testHotel);
		assertSame("Test", testManager.getHotelName());
	}

	@org.junit.jupiter.api.Test
	void bookRoom() {
		Rooms testRoom = new Rooms();
		testManager.setHotel(testHotel);
		int roomIndex = 0 ;

		testManager.managedHotel.addNewRoom(0,testRoom);
		testManager.bookRoom(roomIndex);
		assertTrue(testManager.managedHotel.listOfRooms.get(roomIndex).isTaken());
	}
}
