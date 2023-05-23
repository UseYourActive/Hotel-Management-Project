package models.rooms.enums;

/**
 * The RoomTypes enum represents the different types of rooms available.
 */
public enum RoomTypes {
    /**
     * Single room type.
     */
    SINGLE_ROOM("Single room"),

    /**
     * Double room type.
     */
    DOUBLE_ROOM("Double room"),

    /**
     * Deluxe room type.
     */
    DELUXE_ROOM("Deluxe room"),

    /**
     * President room type.
     */
    PRESIDENT_ROOM("President room");

    private final String roomType;

    /**
     * Constructs a new RoomTypes enum with the specified room type.
     *
     * @param roomType the string representation of the room type
     */
    RoomTypes(String roomType) {
        this.roomType = roomType;
    }

    /**
     * Returns the string representation of the room type.
     *
     * @return the string representation of the room type
     */
    @Override
    public String toString() {
        return this.roomType;
    }
}