package commandlineinterface;

public class Close implements Commandable
{
    /* Members of the class. */
    /*----------------------------------------------------------------------*/
    private static Close instance;
    /* Constructor of the class. */
    private Close(){}
    /*----------------------------------------------------------------------*/

    /* Methods of the class. */
    public static Close getInstance()
    {
        if(instance == null)
        {
            instance = new Close();
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