package rooms;

import exceptions.InvalidRoomTypeException;

public interface FactoryRoomCreational {
    Room createRoom(RoomTypes roomType) throws InvalidRoomTypeException;
}