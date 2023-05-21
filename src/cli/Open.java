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
    public void execute() {
        hotelService.setFile(new File(pathway));
        if (hotelService.getFile().exists()) {
            try {
                hotelService.loadRepository();
            } catch (JAXBException e) {
                e.printStackTrace();
            }
            System.out.println(pathway + " file has been successfully opened!");
        }else {
            System.out.println("File not found!");

            try {
                hotelService.exportToFile();
            } catch (JAXBException e) {
                e.printStackTrace();
            }

            System.out.println("File has been created!");
        }

    }
}