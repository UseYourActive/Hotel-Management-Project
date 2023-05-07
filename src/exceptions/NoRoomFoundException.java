package exceptions;

public class NoRoomFoundException extends Exception{
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
}
