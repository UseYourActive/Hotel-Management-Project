package models.hotel.commands;

import models.Hotel;
import models.hotel.commands.contracts.HotelCommand;
import models.rooms.Room;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Find implements HotelCommand {
    private final int numberOfBeds;
    private final LocalDate from;
    private final LocalDate to;
    private final List<Room> hotelRooms;

    public Find(List<String> arguments, Hotel hotel) {
        this.hotelRooms = hotel.getHotelRooms();
        this.numberOfBeds = Integer.parseInt(arguments.get(0));
        this.from = LocalDate.parse(arguments.get(1));
        this.to = LocalDate.parse(arguments.get(2));
    }

    @Override
    public void execute() {
        for (Room room : getRoomList(numberOfBeds, from, to)) {
            System.out.println(room);
        }
//        Намиране на подходяща свободна стая с поне <beds> на брой легла в периода от <from> до <to>.
//        При наличие на повече свободни стаи се предпочитат такива с по-малко на брой легла.
    }

    public List<Room> getRoomList(int numberOfBeds, LocalDate from, LocalDate to){

        List<Room> roomList = new ArrayList<>();

        for (Room room : this.hotelRooms) {
            if (room.getNumberOfBeds() >= numberOfBeds) {
                if (room.checkRoomIfAvailable(from, to)) {
                    roomList.add(room);
                }
            }
        }

        Collections.sort(roomList);

        return roomList;
    }
}
