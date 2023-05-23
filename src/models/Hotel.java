package models;

import models.rooms.Room;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "hotel")
public class Hotel {
    @XmlElementWrapper(name = "rooms")
    @XmlElement(name = "room")
    private final List<Room> hotelRooms;

    @XmlTransient
    private final String hotelName;

    public Hotel() {
        this.hotelRooms = new ArrayList<>();
        this.hotelName = "Orozov le grande hotel";
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Hotel name: ").append(hotelName).append("\n");

        for (Room room : hotelRooms) {
            stringBuilder.append(room.toString()).append("\n");
        }

        return String.valueOf(stringBuilder);
    }

    public List<Room> getHotelRooms() {
        return this.hotelRooms;
    }
}