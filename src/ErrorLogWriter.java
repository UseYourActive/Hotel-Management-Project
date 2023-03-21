import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;

public class ErrorLogWriter implements WriteError
{
    /* Members of the class. */
    private final static String ERROR_LOG_PATH = String.valueOf(Paths.get("ErrorLog.txt"));
    /*----------------------------------------------------------------------*/

    /* Constructor of the class. */
    ErrorLogWriter(){}
    /*----------------------------------------------------------------------*/

    /* Methods of the class. */
    @Override
    public final void writeToErrorLog(Exception e)
    {
        try
        {
            FileWriter newFile = new FileWriter(ERROR_LOG_PATH, true);
            BufferedWriter buffFile = new BufferedWriter(newFile);
            PrintWriter printFile = new PrintWriter(buffFile, true);
            e.printStackTrace(printFile);
        }
        catch (Exception blowUp)
        {
            throw new RuntimeException("Could not write the exception to the file.", blowUp);
        }
    }
    /*----------------------------------------------------------------------*/
}