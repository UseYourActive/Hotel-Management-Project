package cli.factories;

import cli.*;
import cli.contracts.DefaultCommand;
import cli.enums.DefaultCommands;
import exceptions.commands.InvalidCommandException;
import models.services.HotelService;

import java.util.List;

public class DefaultCommandFactory {
    private final HotelService hotelService;

    public DefaultCommandFactory(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    public DefaultCommand createCommand(DefaultCommands command, List<String> arguments) throws InvalidCommandException {
        DefaultCommand commandObject;

        if(command == null) {
            throw new InvalidCommandException("Please enter a valid command!", new RuntimeException());
        }

        switch (command) {
            case OPEN:
                commandObject = new Open(this.hotelService, arguments);
                break;
            case CLOSE:
                commandObject = new Close(this.hotelService);
                break;
            case SAVE:
                commandObject = new Save(this.hotelService);
                break;
            case SAVEAS:
                commandObject = new SaveAs(this.hotelService, arguments);
                break;
            case HELP:
                commandObject = new Help();
                break;
            case EXIT:
                commandObject = new Exit(this.hotelService);
                break;
            default:
                throw new InvalidCommandException("Please enter a valid command!");
        }

        return commandObject;
    }
}