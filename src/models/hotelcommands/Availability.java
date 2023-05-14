package models.hotelcommands;

import models.Hotel;
import models.hotelcommands.contracts.HotelCommand;
import models.rooms.Room;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Availability implements HotelCommand {
    private Hotel hotel;
    private LocalDate date;

    public Availability(List<String> arguments, Hotel hotel) {
        this.hotel = hotel;

        if(arguments.isEmpty()){
            date = LocalDate.now();
        }else {
            date = LocalDate.parse(arguments.get(0));
        }
    }

    @Override
    public void execute() {
        Set<Room> roomList = new HashSet<>();

        for(Room room : hotel.getHotelRooms()){
            if(room.method(this.date)){
                roomList.add(room);
            }
        }

       printRooms(roomList);

//        Извежда списък на свободните стаи на дата <date>, ако не е зададена, се използва текущата дата.
    }

    public void printRooms(Set<Room> roomList){
        for(Room room : roomList){
            System.out.println(room);
        }
    }
}
