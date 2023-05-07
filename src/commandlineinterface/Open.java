package commandlineinterface;

import errorlogger.ErrorWritable;
import models.hotel.Hotel;
import xmlparsers.JAXBParser;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.List;

public class Open implements Command {
    private JAXBParser jaxbParser;
    private List<String> arguments;
    private static Open instance;
    private ErrorWritable errorLogger;

    private Open(JAXBParser jaxbParser, ErrorWritable errorLogger,List<String> arguments){
        this.jaxbParser = jaxbParser;
        this.errorLogger = errorLogger;
        this.arguments = arguments;
    }

    public static Open getInstance(JAXBParser jaxbParser, ErrorWritable errorLogger, List<String> arguments) {
        if(instance == null) {
            instance = new Open(jaxbParser, errorLogger,arguments);
            return instance;
        }
        return instance;
    }

    @Override
    public void execute() {
        String pathway = arguments.get(0);

        jaxbParser.setFile(new File(pathway));
        jaxbParser.setHotel(Hotel.getInstance());

        if(jaxbParser.getFile().exists()) {
            try {
                jaxbParser.readFromFile();
            } catch (JAXBException e) {
                errorLogger.writeToErrorLog(e);
            }
            System.out.println(pathway + " file has been successfully opened!");
        } else {
            System.out.println(pathway + " file was not found!");
        }

        try {
            jaxbParser.createFileIfNotExist(pathway);
        } catch (JAXBException e) {
            errorLogger.writeToErrorLog(e);
        }

        System.out.println("A new file has been created at: " + pathway);
    }
}