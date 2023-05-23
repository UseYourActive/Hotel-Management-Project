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

        if (command == null) {
            throw new InvalidCommandException("Please enter a valid command!", new RuntimeException());
        }

        commandObject = switch (command) {
            case OPEN -> new Open(this.hotelService, arguments);
            case CLOSE -> new Close(this.hotelService);
            case SAVE -> new Save(this.hotelService);
            case SAVEAS -> new SaveAs(this.hotelService, arguments);
            case HELP -> new Help();
            case EXIT -> new Exit(this.hotelService);
        };

        return commandObject;
    }
}