package commandlineinterface;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveAs implements Commandable
{
    /* Members of the class. */
    private static SaveAs instance;
    /*----------------------------------------------------------------------*/

    /* Constructor of the class. */
    private SaveAs(){}
    /*----------------------------------------------------------------------*/

    /* Methods of the class. */
    public static SaveAs getInstance()
    {
        if(instance == null)
        {
            instance = new SaveAs();
            return instance;
        }

        return instance;
    }

    public void saveAs(String fileData, String data) throws IOException
    {
        File file = new File(fileData);

        if(!file.exists())
        {
            file.createNewFile();
        }

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