package commandlineinterface;

import commandlineinterface.contractors.DefaultCommand;
import utils.errorlogger.ErrorLogWriter;
import utils.services.HotelService;

import javax.xml.bind.JAXBException;

public class Save implements DefaultCommand {
    private HotelService hotelService;
    private ErrorLogWriter errorLogger;
    private static Save instance;

    private Save(HotelService hotelService, ErrorLogWriter errorLogger){
        this.hotelService = hotelService;
        this.errorLogger = errorLogger;
    }

    public static Save getInstance(HotelService hotelService, ErrorLogWriter errorLogger) {
        if(instance == null) {
            instance = new Save(hotelService, errorLogger);
            return instance;
        }
        return instance;
    }

    @Override
    public void execute() {
        try{
            hotelService.exportToFile();
        }catch(JAXBException e){
            e.printStackTrace();
        }

        System.out.println("File successfully saved at: "+ hotelService.getFile().getAbsolutePath());
    }
}