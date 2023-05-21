package models.hotel.commands;

import exceptions.rooms.NoRoomFoundException;
import models.Hotel;
import models.hotel.commands.contracts.HotelCommand;
import models.rooms.Room;

import java.util.List;

public class CheckOut implements HotelCommand {
    private final long id;
    private final List<Room> hotelRooms;

    public CheckOut(List<String> arguments, Hotel hotel) {
        this.hotelRooms = hotel.getHotelRooms();
        this.id = Long.parseLong(arguments.get(0));
    }

    @Override
    public void execute() throws NoRoomFoundException {
        for (Room room : this.hotelRooms) {
            if (room.getNumber() == id) {
                room.updateRoomStatusCheckedOut();
            }
        }

//        Освобождаване на заета стая с номер <room>.
    }
}
