package exceptions.reservations;

import exceptions.HotelException;

public class ReservationException extends HotelException {
    public ReservationException() {
    }

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
