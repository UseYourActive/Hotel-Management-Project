package models.hotelcommands;

import exceptions.rooms.NoRoomFoundException;
import models.Hotel;
import models.hotelcommands.contracts.HotelCommand;
import models.rooms.Room;

import java.util.List;

public class CheckOut implements HotelCommand {
    private Hotel hotel;
    private long id;

    public CheckOut(List<String> arguments, Hotel hotel) {
        this.hotel = hotel;
        this.id = Long.parseLong(arguments.get(0));
    }

    @Override
    public void execute() throws NoRoomFoundException {
        for(Room room : hotel.getHotelRooms()){
            if(room.getNumber() == id){
                room.updateRoomStatusCheckedOut();
            }
        }

//        Освобождаване на заета стая с номер <room>.
    }
}
