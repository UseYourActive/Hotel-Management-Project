package commandlineinterface;

public enum Commands
{
    //region Members of the class
    OPEN("Open"),
    CLOSE("Close"),
    SAVE("Save"),
    SAVE_AS("Save as"),
    HELP("Help"),
    EXIT("Exit");

    private final String command;
    //endregion

    //region Constructor of the class
    Commands(String roomType)
    {
        this.command = roomType;
    }
    //endregion

    //region Methods of the class
    @Override
    public String toString()
    {
        return command;
    }
    //endregion

    //region Overrides
    //endregion

    //region Accessors and Mutators of the class
    //endregion
}