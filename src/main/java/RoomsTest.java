import static org.junit.jupiter.api.Assertions.*;

class RoomsTest {
	Rooms testObject = new Rooms();

	@org.junit.jupiter.api.Test
	void setNumberOfCreatedRooms() {
		assertEquals(1, testObject.getNumberOfCreatedRooms());
	}

	@org.junit.jupiter.api.Test
	void getNumberOfCreatedRooms(){
		assertEquals(1, testObject.getNumberOfCreatedRooms());
	}

	@org.junit.jupiter.api.Test
	void isTaken() {
		assertFalse(testObject.isTaken());
	}

	@org.junit.jupiter.api.Test
	void bookRoom() {
		testObject.BookRoom();
		assertTrue(testObject.isTaken());
	}

	@org.junit.jupiter.api.Test
	void unbookRoom() {
		testObject.UnbookRoom();
		assertFalse(testObject.isTaken());
	}
}
