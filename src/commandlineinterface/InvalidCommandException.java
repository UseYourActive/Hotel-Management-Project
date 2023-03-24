package commandlineinterface;

public class InvalidCommandException extends Exception
{
    InvalidCommandException(){}

    InvalidCommandException(String message)
    {
        super(message);
    }
    InvalidCommandException(Throwable cause)
    {
        super(cause);
    }

    InvalidCommandException(String message, Throwable cause)
    {
        super(message, cause);
    }
}