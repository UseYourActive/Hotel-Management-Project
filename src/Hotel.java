import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Hotel
{
    /* Members of the class. */
    private static List<Room> hotelRooms;
    private static Hotel instance;
    private String hotelName;
    /*----------------------------------------------------------------------*/

    /* Constructor of the class. */
    private Hotel(){}
    /*----------------------------------------------------------------------*/

    /* Methods of the class. */
    public static Hotel getInstance()
    {
        if (instance == null)
        {
            hotelRooms = new ArrayList<>();
            instance = new Hotel();
            Hotel.initialize();
            return instance;
        }
        return instance;
    }
    // Da opravq findAvailableRoom metodite
    public String findAvailableRoom()
    {
        LocalDate today = LocalDate.now();

        StringBuilder availableRooms = new StringBuilder();
        for (Room room : hotelRooms)
        {
            if(room.isAvailable())
            {
                availableRooms.append("\n").append("\n").append(room);
            }
        }
        return String.valueOf(availableRooms);
    }

    public String findAvailableRoom(Date date)
    {
        StringBuilder availableRooms = new StringBuilder();

        for (Room room : hotelRooms) {
            if (room.isAvailable()) {
                availableRooms.append("\n").append("\n").append(room);
            }
        }

        return String.valueOf(availableRooms);
    }

    public void checkout(Room room)
    {

    }

    public static void initialize()
    {
        int numberOfHotelRooms = 20;
        int ROOM_INCREMENT = 1;

        for(int index = 1; index < numberOfHotelRooms + ROOM_INCREMENT; index++)
        {
            hotelRooms.add(new Room(index, RandomNumberGenerator.generateNumberOfBeds()));
        }
    }

    // add rooms or initialize them to be already in the list!
    /*----------------------------------------------------------------------*/

    /* Overrides. */
    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Hotel name: ").append(this.hotelName).append("\n");

        for(Room room : hotelRooms)
        {
            stringBuilder.append(room.toString()).append("\n");
        }

        return String.valueOf(stringBuilder);
    }
    /*----------------------------------------------------------------------*/

    /* Accessors and Mutators of the class. */
    public void setHotelName(String hotelName)
    {
        this.hotelName = hotelName;
    }
    /*----------------------------------------------------------------------*/
}