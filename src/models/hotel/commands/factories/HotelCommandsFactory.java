package models.hotel.commands.factories;

import exceptions.commands.InvalidCommandException;
import models.hotel.commands.*;
import models.hotel.commands.contracts.HotelCommand;
import models.hotel.commands.enums.HotelCommands;
import models.services.HotelService;

import java.util.List;

public class HotelCommandsFactory {
    private HotelService hotelService;

    public HotelCommandsFactory(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    public HotelCommand createCommand(HotelCommands command, List<String> arguments) throws InvalidCommandException {
        HotelCommand commandObject;

        if (command == null) {
            throw new InvalidCommandException("Please enter a valid command!", new RuntimeException());
        }

        commandObject = switch (command) {
            case CHECKIN -> new CheckIn(arguments, hotelService.getRepository());
            case AVAILABILITY -> new Availability(arguments, hotelService.getRepository());
            case CHECKOUT -> new CheckOut(arguments, hotelService.getRepository());
            case REPORT -> new Report(arguments, hotelService.getRepository());
            case FIND -> new Find(arguments, hotelService.getRepository());
            case FINDIMPORTANT -> new FindImportant(arguments, hotelService.getRepository());
            case UNAVAILABLE -> new Unavailable(arguments, hotelService.getRepository());
        };

        return commandObject;
    }
}
