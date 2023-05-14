package exceptions.reservations;

public class ReservationException extends Exception{
    public ReservationException(){}

    public ReservationException(String message) {
        super(message);
    }

    public ReservationException(Throwable cause) {
        super(cause);
    }

    public ReservationException(String message, Throwable cause) {
        super(message, cause);
    }
}
