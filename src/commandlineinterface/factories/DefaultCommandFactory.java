package commandlineinterface.factories;

import commandlineinterface.*;
import commandlineinterface.contractors.DefaultCommand;
import commandlineinterface.enums.DefaultCommands;
import utils.errorlogger.ErrorLogWriter;
import exceptions.commands.InvalidCommandException;
import utils.services.HotelService;

import java.util.List;

public class DefaultCommandFactory {
    private HotelService hotelService;
    private ErrorLogWriter errorLogger;

    public DefaultCommandFactory(HotelService hotelService, ErrorLogWriter errorLogger) {
        this.hotelService = hotelService;
        this.errorLogger = errorLogger;
    }

    public DefaultCommand createCommand(DefaultCommands command, List<String> arguments) throws InvalidCommandException {
        DefaultCommand commandObject;

        if(command == null) {
            throw new InvalidCommandException("Please enter a valid command!", new RuntimeException());
        }

        switch (command) {
            case OPEN:
                commandObject = Open.getInstance(this.hotelService, this.errorLogger, arguments);
                break;
            case CLOSE:
                commandObject = Close.getInstance(this.hotelService);
                break;
            case SAVE:
                commandObject = Save.getInstance(this.hotelService, this.errorLogger);
                break;
            case SAVEAS:
                commandObject = SaveAs.getInstance(this.hotelService, this.errorLogger, arguments);
                break;
            case HELP:
                commandObject = Help.getInstance();
                break;
            case EXIT:
                commandObject = Exit.getInstance(this.hotelService);
                break;
            default:
                throw new InvalidCommandException("Please enter a valid command!");
        }

        return commandObject;
    }
}