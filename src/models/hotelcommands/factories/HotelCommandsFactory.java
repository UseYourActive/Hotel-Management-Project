package models.hotelcommands.factories;

import models.hotelcommands.*;
import models.hotelcommands.contracts.HotelCommand;
import models.hotelcommands.enums.HotelCommands;
import utils.errorlogger.ErrorLogWriter;
import exceptions.commands.InvalidCommandException;
import utils.services.HotelService;
import models.Hotel;

import java.util.List;

public class HotelCommandsFactory {
    private Hotel hotel;
    private ErrorLogWriter errorLogger;

    public HotelCommandsFactory(HotelService hotelService, ErrorLogWriter errorLogger) {
        this.hotel = hotelService.getRepository();
        this.errorLogger = errorLogger;
    }

    public HotelCommand createCommand(HotelCommands command, List<String> arguments) throws InvalidCommandException {
        HotelCommand commandObject;

        if(command == null) {
            throw new InvalidCommandException("Please enter a valid command!", new RuntimeException());
        }

        commandObject = switch (command) {
            case CHECKIN -> new CheckIn(arguments, hotel);
            case AVAILABILITY -> new Availability(arguments, hotel);
            case CHECKOUT -> new CheckOut(arguments, hotel);
            case REPORT -> new Report(arguments, hotel);
            case FIND -> new Find(arguments, hotel);
            case FINDIMPORTANT -> new FindImportant(arguments, hotel);
            case UNAVAILABLE -> new Unavailable(arguments, hotel);
        };

        return commandObject;
    }
}
