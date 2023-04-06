package rooms;

public enum RoomTypes
{
    /* Members of the class. */
    SINGLE_ROOM("Single room"),
    DOUBLE_ROOM("Double room"),
    DELUXE_ROOM("Deluxe room"),
    PRESIDENT_ROOM("President room");

    private final String roomType;
    /*----------------------------------------------------------------------*/

    /* Constructor of the class. */
    RoomTypes(String roomType)
    {
        this.roomType = roomType;
    }
    /*----------------------------------------------------------------------*/

    /* Methods of the class. */
    @Override
    public String toString()
    {
        return roomType;
    }
    /*----------------------------------------------------------------------*/

    /* Overrides. */
    /*----------------------------------------------------------------------*/

    /* Accessors and Mutators of the class. */
    /*----------------------------------------------------------------------*/
}