package rooms;

public class PresidentRoom extends Room// za 4ma
{
    /* Members of the class. */
    /*----------------------------------------------------------------------*/

    /* Constructor of the class. */
    public PresidentRoom(int numberOfBeds)
    {
        super(numberOfBeds);
    }
    /*----------------------------------------------------------------------*/

    /* Methods of the class. */
    /*----------------------------------------------------------------------*/

    /* Overrides. */
    @Override
    public String createRoom()
    {
        return this.toString();
    }

    @Override
    public String toString()
    {
        return "Rooms.PresidentRoom{}";
    }

    /*----------------------------------------------------------------------*/

    /* Accessors and Mutators of the class. */
    /*----------------------------------------------------------------------*/
}