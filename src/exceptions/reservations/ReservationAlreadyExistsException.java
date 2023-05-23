package exceptions.reservations;

public class ReservationAlreadyExistsException extends ReservationException {
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

    public ReservationAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
