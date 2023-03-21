public class RoomFactory
{
    public RoomCreator createNotification(RoomTypes roomType) throws InvalidRoomSelectionException
    {
        RoomCreator roomCreator;

        if (roomType == null)
        {
            throw new InvalidRoomSelectionException("Could not find such a room type!");
        }

        switch (roomType)
        {
            case SINGLE_ROOM:
                roomCreator = new SingleRoom(1); // return i bez break?
                break;
            case DOUBLE_ROOM:
                roomCreator =  new DoubleRoom(2); // return i bez break?
                break;
            case DELUXE_ROOM:
                roomCreator = new DeluxeRoom(3); // return i bez break?
                break;
            case PRESIDENT_ROOM:
                roomCreator = new PresidentRoom(4); // return i bez break?
                break;
            default:
                throw new InvalidRoomSelectionException("Could not find such a room!", new RuntimeException());
        }

        return roomCreator;
    }
}