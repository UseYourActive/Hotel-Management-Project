package exceptions.rooms;

import exceptions.rooms.RoomException;

public class InvalidRoomTypeException extends RoomException {
    public InvalidRoomTypeException(){}

    public InvalidRoomTypeException(String message) {
        super(message);
    }

    public InvalidRoomTypeException(Throwable cause) {
        super(cause);
    }

    public InvalidRoomTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}