public class InvalidRoomTypeException extends Exception
{
    InvalidRoomTypeException(){}

    InvalidRoomTypeException(String message)
    {
        super(message);
    }

    InvalidRoomTypeException(Throwable cause)
    {
        super(cause);
    }

    InvalidRoomTypeException(String message, Throwable cause)
    {
        super(message, cause);
    }
}