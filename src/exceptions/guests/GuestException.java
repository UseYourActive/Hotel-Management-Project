package exceptions.guests;

import exceptions.HotelException;

public class GuestException extends HotelException {
    public GuestException() {
    }

    public GuestException(String message) {
        super(message);
    }

    public GuestException(Throwable cause) {
        super(cause);
    }

    public GuestException(String message, Throwable cause) {
        super(message, cause);
    }

    public GuestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
