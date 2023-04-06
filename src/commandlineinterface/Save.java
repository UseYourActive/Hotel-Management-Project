package commandlineinterface;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Save implements Commandable
{
    /* Members of the class. */
    private static Save instance;
    /*----------------------------------------------------------------------*/

    /* Constructor of the class. */
    private Save(){}
    /*----------------------------------------------------------------------*/

    /* Methods of the class. */
    public static Save getInstance()
    {
        if(instance == null)
        {
            instance = new Save();
            return instance;
        }

        return instance;
    }

    public void save(File file, String data) throws IOException
    {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(data);
        bufferedWriter.close();
    }
    /*----------------------------------------------------------------------*/

    /* Overrides. */
    /*----------------------------------------------------------------------*/

    /* Accessors and Mutators of the class. */
    /*----------------------------------------------------------------------*/
}