package exceptions.rooms;

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

    public InvalidRoomTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}