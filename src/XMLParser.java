import errorlogger.ErrorWritable;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XMLParser
{
    /* Members of the class. */
    private ErrorWritable errorLogger;
    /*----------------------------------------------------------------------*/

    /* Constructor of the class. */

    public XMLParser(ErrorWritable errorLogger)
    {
        this.errorLogger = errorLogger;
    }
    /*----------------------------------------------------------------------*/

    /* Methods of the class. */
    public void readFile(File file)
    {
        try
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
        }
        catch (Exception e)
        {
            errorLogger.writeToErrorLog(e);
        }
    }
    /*----------------------------------------------------------------------*/

    /* Overrides. */
    /*----------------------------------------------------------------------*/

    /* Accessors and Mutators of the class. */
    /*----------------------------------------------------------------------*/
}