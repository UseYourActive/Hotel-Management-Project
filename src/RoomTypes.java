public enum RoomTypes
{
    SINGLE_ROOM("Single room"),
    DOUBLE_ROOM("Double room"),
    DELUXE_ROOM("Deluxe room"),
    PRESIDENT_ROOM("President room");

    private String roomType;
    RoomTypes(String roomType)
    {
        this.roomType = roomType;
    }

    public String displayRoomType()
    {
        return this.roomType;
    }

    @Override
    public String toString() {
        return roomType;
    }
}