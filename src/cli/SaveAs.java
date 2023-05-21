package cli;

import cli.contracts.DefaultCommand;
import models.services.HotelService;

import java.io.File;
import java.util.List;

public class SaveAs implements DefaultCommand {
    private HotelService hotelService;
    private String pathway;

    public SaveAs(HotelService hotelService, List<String> arguments) {
        this.hotelService = hotelService;
        this.pathway = arguments.get(0);
    }

    @Override
    public void execute() {
        String currentFile = hotelService.getFile().getAbsolutePath();
        hotelService.setFile(new File(pathway));

        try{
            hotelService.exportToFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Successfully saved file as: " + hotelService.getFile().getAbsolutePath());
    }
}