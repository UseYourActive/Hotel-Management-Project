package commandlineinterface;

import java.io.File;

public class Validation implements Validator
{
    /* Members of the class. */
    /*----------------------------------------------------------------------*/

    /* Constructor of the class. */
    public Validation() {}
    /*----------------------------------------------------------------------*/

    /* Methods of the class. */
    public boolean isFileOpened(File file)
    {
        if(file != null)
        {
            return true;
        }
        return false;
    }

    public boolean isNullOrEmpty(String string)
    {
        if(string.length() == 0 || string == null)
        {
            return true;
        }
        return false;
    }
    /*----------------------------------------------------------------------*/

    /* Overrides. */
    /*----------------------------------------------------------------------*/

    /* Accessors and Mutators of the class. */
    /*----------------------------------------------------------------------*/
}