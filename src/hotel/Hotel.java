package hotel;

import guest.Guest;
import rooms.*;
import errorlogger.ErrorLogWriter;
import errorlogger.ErrorWritable;
import exceptions.InvalidRoomTypeException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Hotel
{
    /* Members of the class. */
    private static List<Room> hotelRooms;
    private static final Hotel instance = new Hotel(); // Eager singleton
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
        hotelRooms = new ArrayList<>();
        errorLogger = new ErrorLogWriter();
        factory = new RoomFactory();
        return instance;
    }

    public void checkIn(Room room, Date from, Date to, String note, List<Guest> guestList)
    {
//        Регистриране в стая с номер <room> от дата <from> до дата <to> и се добавя бележка <note>.
//        Незадължителният параметър <guests> задава броя на гостите, настанени в стаята.
//        Ако той не е указан, се счита, че броят на настанените гости е равен на броя на леглата в стаята.
//        Пример: checkin 229 2020-03-23 2020-03-31 The Simpsons
    }

    public void availability(Date date)
    {
//        Извежда списък на свободните стаи на дата <date>, ако не е зададена, се използва текущата дата.
    }

    public void checkOut(Room room)
    {
//        Освобождаване на заета стая с номер <room>.
    }

    public void report(Date from, Date to)
    {
//        Извежда справка за използването на стаи в периода от дата <from> до <to>.
//        Извежда се списък, в който за всяка стая, използвана в дадения период, се извежда и броя на дните, в които е била използвана.
    }

    public String find(int numberOfBeds, Date from, Date to)
    {
//        Намиране на подходяща свободна стая с поне <beds> на брой легла в периода от <from> до <to>.
//        При наличие на повече свободни стаи се предпочитат такива с по-малко на брой легла.

        StringBuilder availableRooms = new StringBuilder();

        for (Room room : hotelRooms) {
            if (room.isAvailable()) {
                availableRooms.append("\n").append("\n").append(room);
            }
        }

        return String.valueOf(availableRooms);
    }

    public String find()
    {
//        Намиране на подходяща свободна стая с поне <beds> на брой легла в периода от <from> до <to>.
//        При наличие на повече свободни стаи се предпочитат такива с по-малко на брой легла.


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

    public String findImportant(int numberOfBeds, Date from, Date to)
    {
//        Да се реализира алгоритъм, който предлага спешно намиране на стая за важен гост в случай на липса на свободни стаи за даден период.
//        Алгоритъмът да предлага разместване на настанените от най-много две стаи.

        StringBuilder availableRooms = new StringBuilder();

        for (Room room : hotelRooms) {
            if (room.isAvailable()) {
                availableRooms.append("\n").append("\n").append(room);
            }
        }

        return String.valueOf(availableRooms);
    }

    public void unavailable(Room room, Date from, Date to, String note)
    {
//        Обявява стаята с номер <room> от дата <from> до дата <to> за временно недостъпна и се добавя бележка <note>.
//        В стаята няма регистриран гост, но никой не може да бъде настанен в нея.
//        Пример: unavailable 200 2018-06-01 2019-03-01 Under construction
    }


//    Бонуси: ●  гостите на хотела да могат да се записват по стая за различни дейности от даден списък при настаняване.
//    да се извежда списък на програмата на една стая
//    да се извежда списък на всички записали се за дадена дейност

















    public String showAllRooms()
    {
        StringBuilder allRooms = new StringBuilder();

        for (Room room : hotelRooms) {
            allRooms.append(room.toString()).append("\n");
        }

        return String.valueOf(allRooms);
    }

    public void initialize()
    {
        int NUMBER_OF_HOTEL_ROOM_INITIALIZATIONS = 5;
        int ROOM_INCREMENT = 1;

        for(int index = 1; index < NUMBER_OF_HOTEL_ROOM_INITIALIZATIONS + ROOM_INCREMENT; index++)
        {
            try
            {
                hotelRooms.add((SingleRoom) factory.createRoom(RoomTypes.SINGLE_ROOM));
                hotelRooms.add((DoubleRoom) factory.createRoom(RoomTypes.DOUBLE_ROOM));
                hotelRooms.add((DeluxeRoom) factory.createRoom(RoomTypes.DELUXE_ROOM));
                hotelRooms.add((PresidentRoom) factory.createRoom(RoomTypes.PRESIDENT_ROOM));
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