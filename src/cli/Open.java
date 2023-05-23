package cli;

import cli.contracts.DefaultCommand;
import models.services.HotelService;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.List;

public class Open implements DefaultCommand {
    private final HotelService hotelService;
    private final String pathway;

    public Open(HotelService hotelService, List<String> arguments) {
        this.hotelService = hotelService;
        this.pathway = arguments.get(0);
    }

    @Override
    public void execute() throws JAXBException {
        hotelService.setFile(new File(pathway));
        if (hotelService.getFile().exists()) {
            hotelService.loadRepository();

            System.out.println(pathway + " file has been successfully opened!");
        } else {
            System.out.println("File not found!");

            RoomGenerator.generateRooms(this.hotelService);
            hotelService.exportToFile();

            System.out.println("File has been created!");
        }
    }
}