package models.rooms.contractors;

import exceptions.rooms.InvalidRoomTypeException;
import models.rooms.Room;
import models.rooms.enums.RoomTypes;

public interface FactoryRoomCreational {
    Room createRoom(RoomTypes roomType) throws InvalidRoomTypeException;
}