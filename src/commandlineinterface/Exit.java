package commandlineinterface;

import commandlineinterface.contractors.DefaultCommand;
import utils.services.HotelService;

public class Exit implements DefaultCommand {
    private HotelService hotelService;
    private static Exit instance;

    private Exit(HotelService hotelService){
        this.hotelService = hotelService;
    }

    public static Exit getInstance(HotelService hotelService) {
        if(instance == null) {
            instance = new Exit(hotelService);
            return instance;
        }
        return instance;
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