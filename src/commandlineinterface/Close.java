package commandlineinterface;

import commandlineinterface.contractors.DefaultCommand;
import utils.services.HotelService;

public class Close implements DefaultCommand {
    private HotelService hotelService;
    private static Close instance;

    private Close(HotelService hotelService){
        this.hotelService = hotelService;
    }

    public static Close getInstance(HotelService hotelService) {
        if(instance == null) {
            instance = new Close(hotelService);
            return instance;
        }
        return instance;
    }

    @Override
    public void execute() {
        hotelService.setRepository(null);
        hotelService.setFile(null);
        System.out.println("File has been successfully closed: "+ hotelService.getFile().getAbsolutePath());
    }
}