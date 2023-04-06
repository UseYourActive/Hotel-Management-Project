package rooms;

import exceptions.InvalidRoomTypeException;

public class RoomFactory implements FactoryRoomCreational
{
    /* Members of the class. */
    /*----------------------------------------------------------------------*/

    /* Constructor of the class. */
    /*----------------------------------------------------------------------*/

    /* Methods of the class. */
    public RoomCreator createRoom(RoomTypes roomType) throws InvalidRoomTypeException
    {
        RoomCreator roomCreator;

        if (roomType == null)
        {
            throw new InvalidRoomTypeException("Could not find such a room type!");
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
                throw new InvalidRoomTypeException("Could not find such a room type!", new RuntimeException());
        }

        return roomCreator;
    }
    /*----------------------------------------------------------------------*/

    /* Overrides. */
    /*----------------------------------------------------------------------*/

    /* Accessors and Mutators of the class. */
    /*----------------------------------------------------------------------*/
}