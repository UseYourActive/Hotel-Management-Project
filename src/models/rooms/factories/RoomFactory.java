package models.rooms.factories;

import exceptions.rooms.InvalidRoomTypeException;
import models.rooms.*;
import models.rooms.contracts.FactoryRoomCreational;
import models.rooms.enums.RoomTypes;

import java.util.concurrent.atomic.AtomicInteger;

public class RoomFactory implements FactoryRoomCreational {
    private static final AtomicInteger number = new AtomicInteger(0);

    public Room createRoom(RoomTypes roomType) throws InvalidRoomTypeException {
        Room roomCreator;

        if (roomType == null) {
            throw new InvalidRoomTypeException("Could not find such a room type!");
        }

        roomCreator = switch (roomType) {
            case SINGLE_ROOM -> new SingleRoom();
            case DOUBLE_ROOM -> new DoubleRoom();
            case DELUXE_ROOM -> new DeluxeRoom();
            case PRESIDENT_ROOM -> new PresidentRoom();
        };

        roomCreator.setNumber(number.incrementAndGet());

        return roomCreator;
    }
}