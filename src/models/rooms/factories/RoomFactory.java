package models.rooms.factories;

import exceptions.rooms.InvalidRoomTypeException;
import models.rooms.*;
import models.rooms.contractors.FactoryRoomCreational;
import models.rooms.enums.RoomTypes;

public class RoomFactory implements FactoryRoomCreational {
    @SuppressWarnings("All")
    public Room createRoom(RoomTypes roomType) throws InvalidRoomTypeException {
        Room roomCreator;

        if (roomType == null) {
            throw new InvalidRoomTypeException("Could not find such a room type!");
        }

        switch (roomType) {
            case SINGLE_ROOM:
                roomCreator = new SingleRoom(); // return i bez break?
                break;
            case DOUBLE_ROOM:
                roomCreator =  new DoubleRoom(); // return i bez break?
                break;
            case DELUXE_ROOM:
                roomCreator = new DeluxeRoom(); // return i bez break?
                break;
            case PRESIDENT_ROOM:
                roomCreator = new PresidentRoom(); // return i bez break?
                break;
            default:
                throw new InvalidRoomTypeException("Could not find such a room type!", new RuntimeException());
        }

        return roomCreator;
    }
}