package exceptions;

public class ReservationAlreadyExistsException extends Exception{
    public ReservationAlreadyExistsException(){}

    public ReservationAlreadyExistsException(String message) {
        super(message);
    }

    public ReservationAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public ReservationAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
