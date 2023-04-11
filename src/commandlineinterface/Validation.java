package commandlineinterface;

import java.io.File;

public class Validation implements Validator
{
    //region Members of the class
    //endregion

    //region Constructor of the class
    public Validation() {}
    //endregion

    //region Methods of the class
    @SuppressWarnings("All")
    public boolean isFileOpened(File file)
    {
        if(file != null)
        {
            return true;
        }
        return false;
    }

    @SuppressWarnings("All")
    public boolean isNullOrEmpty(String string)
    {
        if(string.length() == 0 || string == null)
        {
            return true;
        }
        return false;
    }
    //endregion

    //region Overrides
    //endregion

    //region Accessors and Mutators of the class
    //endregion
}