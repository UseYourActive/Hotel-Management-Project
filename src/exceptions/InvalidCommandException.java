package exceptions;

public class InvalidCommandException extends Exception {
    InvalidCommandException(){}

    public InvalidCommandException(String message) {
        super(message);
    }
    InvalidCommandException(Throwable cause) {
        super(cause);
    }

    public InvalidCommandException(String message, Throwable cause) {
        super(message, cause);
    }
}