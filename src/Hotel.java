import errorlogger.ErrorLogWriter;
import errorlogger.ErrorWritable;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Hotel
{
    /* Members of the class. */
    private static Set<Room> hotelRooms;
    private static volatile Hotel instance;
    private String hotelName;
    private static ErrorWritable errorLogger;
    private static FactoryRoomCreational factory;
    /*----------------------------------------------------------------------*/

    /* Constructor of the class. */
    private Hotel() {}
    /*----------------------------------------------------------------------*/

    /* Methods of the class. */
    public static Hotel getInstance()
    {
        if (instance == null)
        {
            synchronized (Hotel.class)
            {
                if(instance == null)
                {
                    hotelRooms = new HashSet<>();
                    errorLogger = new ErrorLogWriter();
                    instance = new Hotel();
                    factory = new RoomFactory();
                    return instance;
                }
            }
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

    public String showAllRooms()
    {
        StringBuilder allRooms = new StringBuilder();

        for (Room room : hotelRooms) {
            allRooms.append(room.toString()).append("\n");
        }

        return String.valueOf(allRooms);
    }

    public void checkout(Room room)
    {

    }

    public void initialize()
    {
        int numberOfHotelRooms = 20;
        int ROOM_INCREMENT = 1;

        for(int index = 1; index < numberOfHotelRooms + ROOM_INCREMENT; index++)
        {
            try
            {
                factory.createRoom(RoomTypes.SINGLE_ROOM);
                factory.createRoom(RoomTypes.DOUBLE_ROOM);
                factory.createRoom(RoomTypes.DELUXE_ROOM);
                factory.createRoom(RoomTypes.PRESIDENT_ROOM);
            }
            catch (InvalidRoomTypeException e)
            {
                errorLogger.writeToErrorLog(e);
            }
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