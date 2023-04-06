package commandlineinterface;

public class Open implements Commandable
{
    /* Members of the class. */
    private static Open instance;
    /*----------------------------------------------------------------------*/

    /* Constructor of the class. */
    private Open(){}
    /*----------------------------------------------------------------------*/

    /* Methods of the class. */
    public static Open getInstance()
    {
        if(instance == null)
        {
            instance = new Open();
            return instance;
        }

        return instance;
    }
    /*----------------------------------------------------------------------*/

    /* Overrides. */
    /*----------------------------------------------------------------------*/

    /* Accessors and Mutators of the class. */
    /*----------------------------------------------------------------------*/
}