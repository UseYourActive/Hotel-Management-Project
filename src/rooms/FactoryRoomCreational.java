package rooms;

import exceptions.InvalidRoomTypeException;

public interface FactoryRoomCreational
{
    RoomCreator createRoom(RoomTypes roomType) throws InvalidRoomTypeException;
}