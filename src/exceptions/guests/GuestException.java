package exceptions.guests;

public class GuestException extends Exception{
    public GuestException(){}

    public GuestException(String message) {
        super(message);
    }

    public GuestException(Throwable cause) {
        super(cause);
    }

    public GuestException(String message, Throwable cause) {
        super(message, cause);
    }
}
