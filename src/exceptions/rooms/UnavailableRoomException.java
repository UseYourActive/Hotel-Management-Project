package exceptions.rooms;

import exceptions.rooms.RoomException;

public class UnavailableRoomException extends RoomException {
    public UnavailableRoomException(){}

    public UnavailableRoomException(String message) {
        super(message);
    }

    public UnavailableRoomException(Throwable cause) {
        super(cause);
    }

    public UnavailableRoomException(String message, Throwable cause) {
        super(message, cause);
    }
}
