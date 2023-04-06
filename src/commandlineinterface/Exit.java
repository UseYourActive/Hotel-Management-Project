package commandlineinterface;

public class Exit implements Commandable
{
    /* Members of the class. */
    private static Exit instance;
    /*----------------------------------------------------------------------*/

    /* Constructor of the class. */
    private Exit(){}
    /*----------------------------------------------------------------------*/

    /* Methods of the class. */
    public static Exit getInstance()
    {
        if(instance == null)
        {
            instance = new Exit();
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