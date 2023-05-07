package exceptions;

public class GuestAlreadyInRoomException extends Exception {
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