package eu.deltasource.internship.hotelserviceapplication.sources;

import eu.deltasource.internship.hotelserviceapplication.hotelCommodities.Bed;
import eu.deltasource.internship.hotelserviceapplication.hotelCommodities.BedTypes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

	private Hotel testHotel;
	private Room testRoom1;
	private Room testRoom2;


	@BeforeEach
	public void setUp() {

		testHotel = new Hotel("testHotel");
		testRoom1 = new Room();
		testRoom2 = new Room();

	}

	@Test
	void testSetHotelName() {
		//when + then
		assertThrows(RuntimeException.class, () -> {
			testHotel.setHotelName("");
		});
	}

	@Test
	void testAddNewRoom() {
		//given
		Room nullRoom = null;
		//when
		testHotel.addNewRoom(testRoom1);
		//then
		assertThrows(RuntimeException.class,()->{
			testHotel.addNewRoom(nullRoom);
		});
		assertFalse(testHotel.getListOfRooms().isEmpty());
	}

	@Test
	void testSearchForRooms() {
		//given
		testRoom1.setCommodities(3, BedTypes.SINGLE, 0, 0);
		testRoom2.setCommodities(2, BedTypes.SINGLE, 0, 0);
		//when
		testHotel.addNewRoom( testRoom1);
		testHotel.addNewRoom( testRoom2);
		//then
		assertFalse(testHotel.searchForRooms(3).isEmpty());
		assertEquals(1, testHotel.searchForRooms(3).size());

	}

	@Test
	void testAddCommodityToRoom() {
		//given
		Hotel testHotel = new Hotel("testHotel");
		Bed newBed = new Bed(BedTypes.SINGLE);
		testHotel.addNewRoom(testRoom1);
		//when
		testHotel.AddCommodityToRoom(newBed,testRoom1.getRoomNumber());
		//then
		assertTrue(testHotel.getInventory().contains(newBed));

	}
}
