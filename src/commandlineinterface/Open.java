package commandlineinterface;

import commandlineinterface.contractors.DefaultCommand;
import utils.errorlogger.ErrorLogWriter;
import utils.services.HotelService;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.List;

public class Open implements DefaultCommand {
    private HotelService hotelService;
    private static Open instance;
    private ErrorLogWriter errorLogger;
    private String pathway;

    private Open(HotelService hotelService, ErrorLogWriter errorLogger, List<String> arguments){
        this.hotelService = hotelService;
        this.errorLogger = errorLogger;
        this.pathway = arguments.get(0);
    }

    public static Open getInstance(HotelService hotelService, ErrorLogWriter errorLogger, List<String> arguments) {
        if(instance == null) {
            instance = new Open(hotelService, errorLogger,arguments);
            return instance;
        }
        return instance;
    }

    @Override
    public void execute() {
        hotelService.setFile(new File(pathway));
        if(hotelService.getFile().exists()){
            try {
                hotelService.loadRepository();
            } catch (JAXBException e) {
                e.printStackTrace();
            }
            System.out.println(pathway + " file has been successfully opened!");
        }else {
            System.out.println("File not found!");

            try {
                hotelService.createFileIfNotExist();
            } catch (JAXBException e) {
                e.printStackTrace();
            }

            System.out.println("File has been created!");
        }

    }
}