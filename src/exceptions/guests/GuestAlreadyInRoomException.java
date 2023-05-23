package exceptions.guests;

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

    public GuestAlreadyInRoomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}