package models;

import models.rooms.Room;
import models.rooms.factories.RoomFactory;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "hotel")
public class Hotel {
    private List<Room> hotelRooms;
    @XmlTransient
    private final String hotelName;
    @XmlTransient
    private final RoomFactory factory;

    public Hotel() {
        this.factory = new RoomFactory();
        this.hotelRooms = new ArrayList<>();
        hotelName = "Orozov le grande hotel";
    }

    public String showAllRooms() {
        StringBuilder allRooms = new StringBuilder();

        for (Room room : hotelRooms) {
            allRooms.append(room.toString()).append("\n");
        }

        return String.valueOf(allRooms);
    }

//    private void initialize() {
//        int NUMBER_OF_HOTEL_ROOM_INITIALIZATIONS = 5;
//        int ROOM_INCREMENT = 1;
//
//        for(int index = 1; index < NUMBER_OF_HOTEL_ROOM_INITIALIZATIONS + ROOM_INCREMENT; index++) {
//            try {
//                hotelRooms.add(factory.createRoom(RoomTypes.SINGLE_ROOM));
//                hotelRooms.add(factory.createRoom(RoomTypes.DOUBLE_ROOM));
//                hotelRooms.add(factory.createRoom(RoomTypes.DELUXE_ROOM));
//                hotelRooms.add(factory.createRoom(RoomTypes.PRESIDENT_ROOM));
//            } catch (InvalidRoomTypeException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Hotel name: ").append(hotelName).append("\n");

        for (Room room : hotelRooms) {
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