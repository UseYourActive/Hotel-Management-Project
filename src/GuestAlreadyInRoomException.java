public class GuestAlreadyInRoomException extends Exception
{
    GuestAlreadyInRoomException(){}

    GuestAlreadyInRoomException(String message)
    {
        super(message);
    }

    GuestAlreadyInRoomException(String message, Throwable cause)
    {
        super(message, cause);
    }
}