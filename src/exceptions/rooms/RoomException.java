package exceptions.rooms;

public class RoomException extends Exception{
    public RoomException(){}

    public RoomException(String message) {
        super(message);
    }
    public RoomException(Throwable cause) {
        super(cause);
    }

    public RoomException(String message, Throwable cause) {
        super(message, cause);
    }
}
