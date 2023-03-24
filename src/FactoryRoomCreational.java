public interface FactoryRoomCreational
{
    RoomCreator createRoom(RoomTypes roomType) throws InvalidRoomTypeException;
}