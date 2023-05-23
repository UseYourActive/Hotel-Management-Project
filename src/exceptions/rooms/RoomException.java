package exceptions.rooms;

import exceptions.HotelException;

public class RoomException extends HotelException {
    public RoomException() {
    }

    public RoomException(String message) {
        super(message);
    }

    public RoomException(Throwable cause) {
        super(cause);
    }

    public RoomException(String message, Throwable cause) {
        super(message, cause);
    }

    public RoomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
