package models;

import models.rooms.*;
import models.rooms.enums.RoomTypes;
import models.rooms.factories.RoomFactory;
import utils.errorlogger.ErrorLogWriter;
import exceptions.rooms.InvalidRoomTypeException;

import javax.xml.bind.annotation.*;
import java.util.*;

@XmlRootElement(name = "hotel")
public class Hotel {
    @XmlTransient
    private List<Room> hotelRooms;
    @XmlTransient
    private static Hotel instance;
    @XmlTransient
    private static String hotelName;
    @XmlTransient
    private ErrorLogWriter errorLogger;
    @XmlTransient
    private RoomFactory factory;

    private Hotel() {
        this.hotelRooms = new ArrayList<>();
    }

    private Hotel(ErrorLogWriter errorLogger) {
        this.errorLogger = errorLogger;
        this.factory = new RoomFactory();
        this.hotelRooms = new ArrayList<>();
        initialize();
    }

    public static Hotel getInstance(ErrorLogWriter errorLogger) {
        if(instance == null) {
            instance = new Hotel(errorLogger);
            hotelName = "Orozov le grande hotel";
        }
        return instance;
    }

    public String showAllRooms() {
        StringBuilder allRooms = new StringBuilder();

        for (Room room : hotelRooms) {
            allRooms.append(room.toString()).append("\n");
        }

        return String.valueOf(allRooms);
    }

    private void initialize() {
        int NUMBER_OF_HOTEL_ROOM_INITIALIZATIONS = 5;
        int ROOM_INCREMENT = 1;

        for(int index = 1; index < NUMBER_OF_HOTEL_ROOM_INITIALIZATIONS + ROOM_INCREMENT; index++) {
            try {
                hotelRooms.add(factory.createRoom(RoomTypes.SINGLE_ROOM));
                hotelRooms.add(factory.createRoom(RoomTypes.DOUBLE_ROOM));
                hotelRooms.add(factory.createRoom(RoomTypes.DELUXE_ROOM));
                hotelRooms.add(factory.createRoom(RoomTypes.PRESIDENT_ROOM));
            } catch (InvalidRoomTypeException e) {
                e.printStackTrace();
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
    public List<Room> getHotelRooms() {
        return this.hotelRooms;
    }

    public void setHotelRooms(List<Room> hotelRooms) {
        this.hotelRooms = hotelRooms;
    }
}