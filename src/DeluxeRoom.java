public class DeluxeRoom extends Room// za 3ma
{
    /* Members of the class. */
    /*----------------------------------------------------------------------*/

    /* Constructor of the class. */
    public DeluxeRoom(int numberOfBeds)
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
        return "DeluxeRoom{}";
    }

    /*----------------------------------------------------------------------*/

    /* Accessors and Mutators of the class. */
    /*----------------------------------------------------------------------*/
}