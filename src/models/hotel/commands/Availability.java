package models.hotel.commands;

import models.Hotel;
import models.hotel.commands.contracts.HotelCommand;
import models.rooms.Room;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Availability implements HotelCommand {
    private final LocalDate date;
    private final List<Room> hotelRooms;

    public Availability(List<String> arguments, Hotel hotel) {
        this.hotelRooms = hotel.getHotelRooms();

        if (arguments.isEmpty()) {
            date = LocalDate.now();
        } else {
            date = LocalDate.parse(arguments.get(0));
        }
    }

    @Override
    public void execute() {
        Set<Room> roomList = new HashSet<>();

        for (Room room : this.hotelRooms) {
            if (room.checkReservationStatus(this.date)) {
                roomList.add(room);
            }
        }

        printRooms(roomList);

//        Извежда списък на свободните стаи на дата <date>, ако не е зададена, се използва текущата дата.
    }

    public void printRooms(Set<Room> roomList) {
        for (Room room : roomList) {
            System.out.println("Room number: " + room.getNumber());
            System.out.println("Number of beds: " + room.getNumberOfBeds());
        }
    }
}
