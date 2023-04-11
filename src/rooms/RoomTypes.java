package rooms;

public enum RoomTypes
{
    //region Members of the class
    SINGLE_ROOM("Single room"),
    DOUBLE_ROOM("Double room"),
    DELUXE_ROOM("Deluxe room"),
    PRESIDENT_ROOM("President room");

    private final String roomType;
    //endregion

    //region Constructor of the class
    RoomTypes(String roomType)
    {
        this.roomType = roomType;
    }
    //endregion

    //region Methods of the class
    @Override
    public String toString()
    {
        return roomType;
    }
    //endregion

    //region Overrides
    //endregion

    //region Accessors and Mutators of the class
    //endregion
}