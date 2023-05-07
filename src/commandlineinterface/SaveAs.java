package commandlineinterface;

import errorlogger.ErrorWritable;
import xmlparsers.JAXBParser;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.List;

public class SaveAs implements Command {
    private JAXBParser jaxbParser;
    private ErrorWritable errorLogger;
    private List<String> arguments;
    private static SaveAs instance;

    private SaveAs(JAXBParser jaxbParser, ErrorWritable errorLogger, List<String> arguments){
        this.jaxbParser = jaxbParser;
        this.errorLogger = errorLogger;
        this.arguments = arguments;
    }

    public static SaveAs getInstance(JAXBParser jaxbParser, ErrorWritable errorLogger, List<String> arguments) {
        if(instance == null) {
            instance = new SaveAs(jaxbParser, errorLogger, arguments);
            return instance;
        }
        return instance;
    }


    @Override
    public void execute() {
        String pathway = arguments.get(0);

        String currentFile= jaxbParser.getFile().getAbsolutePath();
        jaxbParser.setFile(new File(pathway));

        try{
            jaxbParser.writeToFile();
            jaxbParser.deleteFile(currentFile);
        } catch (JAXBException e) {
            errorLogger.writeToErrorLog(e);
        }

        System.out.println("Successfully saved file as: " + jaxbParser.getFile().getAbsolutePath());
    }
}