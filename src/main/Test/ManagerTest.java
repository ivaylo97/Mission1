import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

 public class ManagerTest {



	@org.junit.jupiter.api.Test
public	void getHotel() {
		Manager testManager = new Manager();
		Hotel testHotel = new Hotel();
		testHotel.setHotelName("Test");
		testManager.setHotel(testHotel);
		assertSame("Test", testManager.getHotelName());
	}

	@org.junit.jupiter.api.Test
public	void getManagerName() {
		Manager testManager = new Manager();
		Hotel testHotel = new Hotel();
		testManager.setManagerName("TestManagerName");
		assertSame("TestManagerName", testManager.getManagerName());
	}

	@org.junit.jupiter.api.Test
public	void setManagerName() {
		Manager testManager = new Manager();
		Hotel testHotel = new Hotel();
		testManager.setManagerName("TestManagerName");
		assertSame("TestManagerName", testManager.getManagerName());
	}

	@org.junit.jupiter.api.Test
public	void setHotelName() {
		Manager testManager = new Manager();
		Hotel testHotel = new Hotel();
		testHotel.setHotelName("Test");
		testManager.setHotel(testHotel);
		assertSame("Test", testManager.getHotelName());
	}

	@org.junit.jupiter.api.Test
public	void bookRoom() {
		Manager testManager = new Manager();
		Hotel testHotel = new Hotel();
		Rooms testRoom = new Rooms();
		testManager.setHotel(testHotel);
		int roomIndex = 0 ;

		testManager.managedHotel.addNewRoom(0,testRoom);
		testManager.bookRoom(roomIndex);
		assertTrue(testManager.managedHotel.listOfRooms.get(roomIndex).isTaken());
	}
}
