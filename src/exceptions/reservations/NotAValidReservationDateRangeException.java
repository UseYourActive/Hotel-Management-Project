package exceptions.reservations;

public class NotAValidReservationDateRangeException extends ReservationException {
    public NotAValidReservationDateRangeException(){}

    public NotAValidReservationDateRangeException(String message) {
        super(message);
    }

    public NotAValidReservationDateRangeException(Throwable cause) {
        super(cause);
    }

    public NotAValidReservationDateRangeException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotAValidReservationDateRangeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
