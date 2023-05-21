package models.hotel.commands;

import exceptions.rooms.NoRoomFoundException;
import models.Hotel;
import models.hotel.commands.contracts.HotelCommand;
import models.rooms.Room;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FindImportant implements HotelCommand {
    private Hotel hotel;
    private final int numberOfBeds;
    private final LocalDate from;
    private final LocalDate to;
    private final List<String> arguments;

    public FindImportant(List<String> arguments, Hotel hotel) {
        this.arguments = arguments;
        this.hotel = hotel;
        this.numberOfBeds = Integer.parseInt(arguments.get(0));
        this.from = LocalDate.parse(arguments.get(1));
        this.to = LocalDate.parse(arguments.get(2));
    }

    @Override
    public void execute() throws NoRoomFoundException {
        Find find = new Find(arguments, hotel);

        if(find.getRoomList(numberOfBeds, from, to).isEmpty()){
            throw new NoRoomFoundException("Didn't find any room");
        }

        List<Room> roomList = new ArrayList<>();

        for (Room room : this.hotel.getHotelRooms()) {
            if (room.getNumberOfBeds() >= numberOfBeds) {
                roomList.add(room);
            }
        }

        if(roomList.isEmpty()){
            throw new NoRoomFoundException("There has not been an available room found!");
        }

        for(Room fromRoom : roomList){
            if(fromRoom.getBusyReservation(from,to) == null){
                continue;
            }
            for(Room toRoom : roomList){
                if(fromRoom.equals(toRoom)){
                    continue;
                }

                if(fromRoom.getBusyReservation(from, to).getNumberOfGuests() <= toRoom.getNumberOfBeds() && toRoom.getFreeReservation(from, to) != null){
                    System.out.println("It is possible to move reservation from " + fromRoom + " to " + toRoom + ". Do you wish to do it? Yes/No");
                }
            }
        }

//        Да се реализира алгоритъм, който предлага спешно намиране на стая за важен гост в случай на липса на свободни стаи за даден период.
//        Алгоритъмът да предлага разместване на настанените от най-много две стаи.
    }
}
