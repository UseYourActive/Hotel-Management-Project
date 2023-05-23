package exceptions.rooms;

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

    public UnavailableRoomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
