package exceptions;

public class InvalidRoomTypeException extends Exception {
    InvalidRoomTypeException(){}

    public InvalidRoomTypeException(String message) {
        super(message);
    }

    InvalidRoomTypeException(Throwable cause) {
        super(cause);
    }

    public InvalidRoomTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}