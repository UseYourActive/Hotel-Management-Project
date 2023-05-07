package commandlineinterface;

import errorlogger.ErrorLogWriter;
import errorlogger.ErrorWritable;
import xmlparsers.JAXBParser;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;

public class Save implements Command {
    private JAXBParser jaxbParser;
    private ErrorWritable errorLogger;
    private static Save instance;

    private Save(JAXBParser jaxbParser, ErrorWritable errorLogger){
        this.jaxbParser = jaxbParser;
        this.errorLogger = errorLogger;
    }

    public static Save getInstance(JAXBParser jaxbParser, ErrorWritable errorLogger) {
        if(instance == null) {
            instance = new Save(jaxbParser, errorLogger);
            return instance;
        }
        return instance;
    }

    @Override
    public void execute() {
        try{
            jaxbParser.writeToFile();
        }catch(JAXBException e){
            errorLogger.writeToErrorLog(e);
        }

        System.out.println("File successfully saved at: "+ jaxbParser.getFile().getAbsolutePath());
    }
}