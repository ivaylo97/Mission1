import static org.junit.jupiter.api.Assertions.*;

public class HotelTest {

	@org.junit.jupiter.api.Test
 public	void getNumberOfRooms() {
		Hotel testHotel = new Hotel();
		assertEquals(0, testHotel.getNumberOfRooms());
	}

	@org.junit.jupiter.api.Test
public	void initNumberOfRooms() {
		Hotel testHotel = new Hotel();
		assertEquals(0, testHotel.getNumberOfRooms());
	}


	@org.junit.jupiter.api.Test
public	void addNewRoom() {
		Hotel testHotel = new Hotel();
		Rooms testRoom = new Rooms();
		testHotel.addNewRoom(0,testRoom);
		assertEquals(1,testHotel.getNumberOfRooms());

	}

	@org.junit.jupiter.api.Test
public	void getHotelName() {
		Hotel testHotel = new Hotel();
		testHotel.setHotelName("TestHotelName");
		assertSame("TestHotelName",testHotel.getHotelName());
	}

	@org.junit.jupiter.api.Test
public	void setHotelName() {
		Hotel testHotel = new Hotel();
		testHotel.setHotelName("TestHotelName");
		assertSame("TestHotelName",testHotel.getHotelName());
	}

	@org.junit.jupiter.api.Test
public	void searchForFreeRooms() {
		Hotel testHotel = new Hotel();
		Rooms testRoom = new Rooms();
		testHotel.addNewRoom(0,testRoom);
		assertTrue(testHotel.searchForFreeRooms().isEmpty());
	}
}
