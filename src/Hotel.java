import java.util.ArrayList ;


public class Hotel {

    private String hotelName;
    public ArrayList<Rooms> listOfRooms;
    static int numberOfRooms = -1 ;
//-------------------------------------------
   Hotel()
   {
       hotelName = "\0" ; // Or "Unnamed" ??
       listOfRooms = new ArrayList<Rooms>();
       InitNumberOfRooms();
   }
//-------------------------------------------
	public int getNumberOfRooms()
	{
		return numberOfRooms;
	}
//-------------------------------------------
	void InitNumberOfRooms()
	{
		if (numberOfRooms < 0)
			numberOfRooms = 0 ;
	}
//--------------------------------------------
	public void addNewRoom(int idx , Rooms NewRoom)
	{
		listOfRooms.add(idx,NewRoom);
		numberOfRooms++;
	}
//----------------------------------------------
    /**
     * Returns the Hotel's name
     * @return
     */
    public String getHotelName()
{
    return hotelName;
}
//-------------------------------------------
    /**
     * This variable is used as a new value for the Hotel Name member.
     * @param newHotelName
     */
    public void setHotelName(String newHotelName)
{
        hotelName = newHotelName ;
}
//-------------------------------------------
    /**
     * Searches the list of rooms for free ones , if there are any it returns them in an arraylist format.
     * If none are free returns null.
     * @return
     */
    public ArrayList<Rooms> searchForFreeRooms()
    {
        boolean isNotEmpty = false ;
        ArrayList<Rooms> temporaryList = new ArrayList<>();
        for(int roomCounter = 0; roomCounter < Rooms.numberOfCreatedRooms; roomCounter ++)
        {
            if(listOfRooms.get(roomCounter).isTaken())
            {
                isNotEmpty = true ;
                temporaryList.add(listOfRooms.get(roomCounter));
            }
        }

        if(isNotEmpty)
            return temporaryList ;
        else
            return null ;
    }

}
/*=================================== Helper Class ================================================================================
 */
class Rooms
{
    static int numberOfCreatedRooms = -1;
    private int roomNumber;
    private boolean isBooked;
//------------------------------------------
    /**
     * Constructor initializing the members of the Rooms class
     */
 Rooms()
 {
     setNumberOfCreatedRooms();
     numberOfCreatedRooms++ ;
     roomNumber = numberOfCreatedRooms;
 }
//------------------------------------------
    /**
     * numberOfCreatedRooms is a static member of the Rooms class
     * it's purpose is to contain the absolute number of created rooms
     * and thus to assist in the automatic generation ot the rooms numbers.
     * This methods'  sole purpose is to initialize the numberOfCreatedRooms variable
     * (if it has not been initialized ) to zero ( 0 )
     */
    void setNumberOfCreatedRooms()
{
    if(numberOfCreatedRooms < 0 )
        numberOfCreatedRooms = 0 ;
}
//------------------------------------------
    /**
     * This method checks whether the isBooked (which is a testament of whether a room is free or not)
     * and return a boolean value as an answer
     */
    /**
     * Returns a value based on whether a rooms is taken or not
     * @return
     */
    public boolean isTaken()
    {
        return isBooked;
    }
//------------------------------------------
    /**
     * This method raises the isBooked  flag of a specific room
     */
    public void BookRoom()
    {
        if(!isTaken())
            isBooked = true ;
        else
            System.out.println("The room is already taken");
    }
//------------------------------------------
    /**
     * This method sets the isBooked of a specific room to false (a.k.a Not taken)
     */

    public void UnbookRoom()
    {
        if(isBooked)
            isBooked = false ;
    }

}
