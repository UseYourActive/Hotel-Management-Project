package exceptions.commands;

public class InvalidCommandException extends CommandException {
    public InvalidCommandException(){}

    public InvalidCommandException(String message) {
        super(message);
    }
    public InvalidCommandException(Throwable cause) {
        super(cause);
    }

    public InvalidCommandException(String message, Throwable cause) {
        super(message, cause);
    }
}