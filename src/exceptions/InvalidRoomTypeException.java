package exceptions;

public class InvalidRoomTypeException extends Exception {
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