package models.hotel;

import models.rooms.*;
import errorlogger.ErrorLogWriter;
import errorlogger.ErrorWritable;
import exceptions.InvalidRoomTypeException;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;

@XmlRootElement
public class Hotel {
    private static List<Room> hotelRooms;
    private static Hotel instance;
    private static String hotelName;
    private static ErrorWritable errorLogger;
    private static FactoryRoomCreational factory;

    private Hotel() {}

    public static Hotel getInstance() {
        if(instance == null) {
            instance = new Hotel();
            hotelRooms = new ArrayList<>();
            hotelName = "Orozov's Brothel";
            errorLogger = new ErrorLogWriter();
            factory = new RoomFactory();
            Hotel.initialize();
        }
        return instance;
    }


//    Бонуси: ●  гостите на хотела да могат да се записват по стая за различни дейности от даден списък при настаняване.
//    да се извежда списък на програмата на една стая
//    да се извежда списък на всички записали се за дадена дейност


    public String showAllRooms() {
        StringBuilder allRooms = new StringBuilder();

        for (Room room : hotelRooms) {
            allRooms.append(room.toString()).append("\n");
        }

        return String.valueOf(allRooms);
    }

    private static void initialize() {
        int NUMBER_OF_HOTEL_ROOM_INITIALIZATIONS = 5;
        int ROOM_INCREMENT = 1;

        for(int index = 1; index < NUMBER_OF_HOTEL_ROOM_INITIALIZATIONS + ROOM_INCREMENT; index++) {
            try {
                hotelRooms.add(factory.createRoom(RoomTypes.SINGLE_ROOM));
                hotelRooms.add(factory.createRoom(RoomTypes.DOUBLE_ROOM));
                hotelRooms.add(factory.createRoom(RoomTypes.DELUXE_ROOM));
                hotelRooms.add(factory.createRoom(RoomTypes.PRESIDENT_ROOM));
            } catch (InvalidRoomTypeException e) {
                errorLogger.writeToErrorLog(e);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Hotel name: ").append(hotelName).append("\n");

        for(Room room : hotelRooms) {
            stringBuilder.append(room.toString()).append("\n");
        }

        return String.valueOf(stringBuilder);
    }

    @XmlElement(name = "room")
    public static List<Room> getHotelRooms() {
        return new ArrayList<>(hotelRooms);
    }
}