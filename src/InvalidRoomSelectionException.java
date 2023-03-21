public class InvalidRoomSelectionException extends Exception
{
    InvalidRoomSelectionException(){}

    InvalidRoomSelectionException(String message)
    {
        super(message);
    }

    InvalidRoomSelectionException(Throwable cause)
    {
        super(cause);
    }

    InvalidRoomSelectionException(String message, Throwable cause)
    {
        super(message, cause);
    }
}