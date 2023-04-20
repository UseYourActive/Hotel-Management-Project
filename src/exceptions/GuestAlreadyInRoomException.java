package exceptions;

public class GuestAlreadyInRoomException extends Exception {
    GuestAlreadyInRoomException(){}

    GuestAlreadyInRoomException(String message) {
        super(message);
    }
    GuestAlreadyInRoomException(Throwable cause) {
        super(cause);
    }

    public GuestAlreadyInRoomException(String message, Throwable cause) {
        super(message, cause);
    }
}