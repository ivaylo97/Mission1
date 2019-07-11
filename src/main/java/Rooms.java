public class Rooms
{
	static int numberOfCreatedRooms = -1;
	private int roomNumber;
	private boolean isBooked;

	/**
	 * Constructor initializing the members of the Rooms class
	 */
	Rooms() {
		setNumberOfCreatedRooms();
		numberOfCreatedRooms++ ;
		roomNumber = numberOfCreatedRooms;
		isBooked = false ;
	}

	/**
	 * numberOfCreatedRooms is a static member of the Rooms class
	 * it's purpose is to contain the absolute number of created rooms
	 * and thus to assist in the automatic generation ot the rooms numbers.
	 * This methods'  sole purpose is to initialize the numberOfCreatedRooms variable
	 * (if it has not been initialized ) to zero ( 0 )
	 */
	void setNumberOfCreatedRooms() {
		if(numberOfCreatedRooms < 0 )
			numberOfCreatedRooms = 0 ;
	}

	int getNumberOfCreatedRooms(){
		return numberOfCreatedRooms;
	}


	/**
	 * This method checks whether the isBooked (which is a testament of whether a room is free or not)
	 * and return a boolean value as an answer
	 */
	/**
	 * Returns a value based on whether a rooms is taken or not
	 * @return isBooked
	 */
	public boolean isTaken() {
		return isBooked;
	}

	/**
	 * This method raises the isBooked  flag of a specific room
	 */
	public void BookRoom() {
		if(!isTaken())
			isBooked = true ;
		else
			System.out.println("The room is already taken");
	}

	/**
	 * This method sets the isBooked of a specific room to false (a.k.a Not taken)
	 */

	public void UnbookRoom() {
		if(isBooked) {
			isBooked = false;
		}
	}

}
