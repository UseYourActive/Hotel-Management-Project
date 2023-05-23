package models.rooms.factories;

import exceptions.rooms.InvalidRoomTypeException;
import models.rooms.enums.RoomTypes;
import models.services.HotelService;

public class RoomGenerator {
    public static void generateRooms(HotelService hotelService) {
        RoomFactory factory = new RoomFactory();

        int NUMBER_OF_HOTEL_ROOM_INITIALIZATIONS = 5;
        int ROOM_INCREMENT = 1;

        for (int index = 1; index < NUMBER_OF_HOTEL_ROOM_INITIALIZATIONS + ROOM_INCREMENT; index++) {
            try {
                hotelService.getRepository().getHotelRooms().add(factory.createRoom(RoomTypes.SINGLE_ROOM));
                hotelService.getRepository().getHotelRooms().add(factory.createRoom(RoomTypes.DOUBLE_ROOM));
                hotelService.getRepository().getHotelRooms().add(factory.createRoom(RoomTypes.DELUXE_ROOM));
                hotelService.getRepository().getHotelRooms().add(factory.createRoom(RoomTypes.PRESIDENT_ROOM));
            } catch (InvalidRoomTypeException e) {
                e.printStackTrace();
            }
        }
    }
}
