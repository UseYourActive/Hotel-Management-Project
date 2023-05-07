package models.rooms;

public enum RoomTypes {
    SINGLE_ROOM("Single room"),
    DOUBLE_ROOM("Double room"),
    DELUXE_ROOM("Deluxe room"),
    PRESIDENT_ROOM("President room");

    private final String roomType;

    RoomTypes(String roomType) {
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return this.roomType;
    }
}