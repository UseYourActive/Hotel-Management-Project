package exceptions;

public class UnavailableRoomException extends Exception{
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
