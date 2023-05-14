package exceptions.reservations;

import exceptions.reservations.ReservationException;

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
}
