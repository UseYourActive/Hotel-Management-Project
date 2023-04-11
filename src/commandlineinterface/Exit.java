package commandlineinterface;

public class Exit implements Command
{
    //region Members of the class
    private static Exit instance;
    //endregion

    //region Constructor of the class
    private Exit(){}
    //endregion

    //region Methods of the class
    public static Exit getInstance()
    {
        if(instance == null)
        {
            instance = new Exit();
            return instance;
        }

        return instance;
    }
    //endregion

    //region Overrides
    //endregion

    //region Accessors and Mutators of the class
    //endregion
}