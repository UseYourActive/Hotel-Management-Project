package cli;

import cli.contracts.DefaultCommand;
import models.services.HotelService;

import javax.xml.bind.JAXBException;

public class Save implements DefaultCommand {
    private final HotelService hotelService;

    public Save(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @Override
    public void execute() {
        try {
            hotelService.exportToFile();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        System.out.println("File successfully saved at: " + hotelService.getFile().getAbsolutePath());
    }
}