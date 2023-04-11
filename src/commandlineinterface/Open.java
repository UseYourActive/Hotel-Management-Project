package commandlineinterface;

public class Open implements Command
{
    //region Members of the class
    private static Open instance;
    //endregion

    //region Constructor of the class
    private Open(){}
    //endregion

    //region Methods of the class
    public static Open getInstance()
    {
        if(instance == null)
        {
            instance = new Open();
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