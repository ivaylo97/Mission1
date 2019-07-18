import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RoomsTest {

	@Test
public	void initNumberRooms() {
		Rooms testObject = new Rooms();

	}

	@org.junit.jupiter.api.Test
public	void getNumberOfCreatedRooms(){
		Rooms testObject = new Rooms();
		assertEquals(1, testObject.getRoomNumber());
	}

	@org.junit.jupiter.api.Test
public	void isTaken() {
		Rooms testObject = new Rooms();
		assertFalse(testObject.isTaken());
	}

	@org.junit.jupiter.api.Test
public	void bookRoom() {
		Rooms testObject = new Rooms();
		testObject.BookRoom();
		assertTrue(testObject.isTaken());
	}

	@org.junit.jupiter.api.Test
public	void unbookRoom() {
		Rooms testObject = new Rooms();
		testObject.UnbookRoom();
		assertFalse(testObject.isTaken());
	}
}
