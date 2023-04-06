package commandlineinterface;

public enum Commands
{
    /* Members of the class. */
    OPEN("Open"),
    CLOSE("Close"),
    SAVE("Save"),
    SAVE_AS("Save as"),
    HELP("Help"),
    EXIT("Exit");

    private final String command;
    /*----------------------------------------------------------------------*/

    /* Constructor of the class. */
    Commands(String roomType)
    {
        this.command = roomType;
    }
    /*----------------------------------------------------------------------*/

    /* Methods of the class. */
    @Override
    public String toString()
    {
        return command;
    }
    /*----------------------------------------------------------------------*/

    /* Overrides. */
    /*----------------------------------------------------------------------*/

    /* Accessors and Mutators of the class. */
    /*----------------------------------------------------------------------*/
}