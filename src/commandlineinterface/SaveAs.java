package commandlineinterface;

import commandlineinterface.contractors.DefaultCommand;
import utils.errorlogger.ErrorLogWriter;
import utils.services.HotelService;

import java.io.File;
import java.util.List;

public class SaveAs implements DefaultCommand {
    private HotelService hotelService;
    private ErrorLogWriter errorLogger;
    private static SaveAs instance;
    private String pathway;

    private SaveAs(HotelService hotelService, ErrorLogWriter errorLogger, List<String> arguments){
        this.hotelService = hotelService;
        this.errorLogger = errorLogger;
        this.pathway = arguments.get(0);
    }

    public static SaveAs getInstance(HotelService hotelService, ErrorLogWriter errorLogger, List<String> arguments) {
        if(instance == null) {
            instance = new SaveAs(hotelService, errorLogger, arguments);
            return instance;
        }
        return instance;
    }


    @Override
    public void execute() {
        String currentFile = hotelService.getFile().getAbsolutePath();
        hotelService.setFile(new File(pathway));

        try{
            hotelService.exportToFile();
            hotelService.deleteFile(currentFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Successfully saved file as: " + hotelService.getFile().getAbsolutePath());
    }
}