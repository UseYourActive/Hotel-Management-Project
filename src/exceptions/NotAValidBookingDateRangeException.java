package exceptions;

public class NotAValidBookingDateRangeException extends Exception{
    public NotAValidBookingDateRangeException(){}

    public NotAValidBookingDateRangeException(String message) {
        super(message);
    }

    public NotAValidBookingDateRangeException(Throwable cause) {
        super(cause);
    }

    public NotAValidBookingDateRangeException(String message, Throwable cause) {
        super(message, cause);
    }
}
