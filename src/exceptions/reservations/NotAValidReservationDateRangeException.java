package exceptions.reservations;

import exceptions.reservations.ReservationException;

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
}
