import java.util.ArrayList;
//Just hotfix test
public class HotelServiceApplication {
    public static void main(String[] args)
    {

        Manager Ivan = new Manager();
        Hotel transylvania = new Hotel();
        Rooms room101 = new Rooms();
        Rooms room102 = new Rooms();
        ArrayList<Rooms> tempList ;


        transylvania.setHotelName("transylvania");
        Ivan.setHotelName("transylvania");
        Ivan.managedHotel = transylvania ;
        transylvania.addNewRoom(0,room101);
        transylvania.addNewRoom(1,room102);

        Ivan.setHotelName(transylvania.getHotelName());

        tempList=Ivan.managedHotel.searchForFreeRooms();
        if(tempList != null)
            tempList.get(0).BookRoom();

        for(int generalPurposeCounter = 0 ,numberOfRooms = transylvania.getNumberOfRooms();  generalPurposeCounter < numberOfRooms ; generalPurposeCounter ++ )
        {
            Ivan.managedHotel.listOfRooms.get(generalPurposeCounter).UnbookRoom();

        }

    }




}
