package commandlineinterface;

public class Close implements Command
{
    //region Members of the class
    private static Close instance;
    //endregion

    //region Constructor of the class
    private Close(){}
    //endregion

    //region Methods of the class
    public static Close getInstance()
    {
        if(instance == null)
        {
            instance = new Close();
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