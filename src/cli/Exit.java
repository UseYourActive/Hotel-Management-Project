package cli;

import cli.contracts.DefaultCommand;
import models.services.HotelService;

public class Exit implements DefaultCommand {
    private HotelService hotelService;

    public Exit(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    public void execute(){
        hotelService.setRepository(null);
        hotelService.setFile(null);
        hotelService = null;
        System.out.println("Exiting program...");
        System.gc();
        System.exit(0);
    }
}