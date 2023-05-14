package exceptions.guests;

import exceptions.guests.GuestException;

public class GuestAlreadyInRoomException extends GuestException {
    public GuestAlreadyInRoomException(){}

    public GuestAlreadyInRoomException(String message) {
        super(message);
    }
    public GuestAlreadyInRoomException(Throwable cause) {
        super(cause);
    }

    public GuestAlreadyInRoomException(String message, Throwable cause) {
        super(message, cause);
    }
}