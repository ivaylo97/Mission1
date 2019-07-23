package eu.deltasource.internship.hotelserviceapplication.hotelCommodities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BedTest {

	private Bed testBed ;

	@BeforeEach
	public void setUp(){
		testBed = new Bed();
	}

	@Test
	void deployBed() {
		//when
		testBed.deployBed();
		//then
		assertTrue(testBed.isDeployed());
	}

	@Test
	void isDeployed() {
		//when
		testBed.deployBed();
		testBed.removeDeployment();
		//then
		assertFalse(testBed.isDeployed());
	}
	@Test
	void parsingConstructorTest(){
		//given
		Bed testBed2;
		//when
		testBed2 = new Bed("SINGLE");
		//then
		assertTrue(testBed2.getBedType().getBedCapacity() == 1);
	}
}
