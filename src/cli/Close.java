package cli;

import cli.contracts.DefaultCommand;
import models.services.HotelService;

public class Close implements DefaultCommand {
    private HotelService hotelService;

    public Close(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @Override
    public void execute() {
        System.out.println("File has been successfully closed: " + hotelService.getFile().getAbsolutePath());
        hotelService.setRepository(null);
        hotelService.setFile(null);
    }
}