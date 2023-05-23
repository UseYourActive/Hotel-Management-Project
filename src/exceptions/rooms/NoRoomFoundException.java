package exceptions.rooms;

public class NoRoomFoundException extends RoomException {
    public NoRoomFoundException(){}

    public NoRoomFoundException(String message) {
        super(message);
    }

    public NoRoomFoundException(Throwable cause) {
        super(cause);
    }

    public NoRoomFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoRoomFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
