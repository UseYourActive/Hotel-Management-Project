package commandlineinterface;

import errorlogger.ErrorWritable;
import exceptions.InvalidCommandException;
import xmlparsers.JAXBParser;

import java.util.List;

public class CommandFactory {
    private JAXBParser jaxbParser;
    private ErrorWritable errorLogger;

    public CommandFactory(JAXBParser jaxbParser, ErrorWritable errorLogger) {
        this.jaxbParser = jaxbParser;
        this.errorLogger = errorLogger;
    }

    public Command createCommand(DefaultCommands command, List<String> arguments) throws InvalidCommandException {
        Command commandObject;

        if(command == null) {
            throw new InvalidCommandException("Please enter a valid command!", new RuntimeException());
        }

        switch (command) {
            case OPEN:
                commandObject = Open.getInstance(this.jaxbParser, this.errorLogger, arguments);
                break;
            case CLOSE:
                commandObject = Close.getInstance(this.jaxbParser);
                break;
            case SAVE:
                commandObject = Save.getInstance(this.jaxbParser, this.errorLogger);
                break;
            case SAVE_AS:
                commandObject = SaveAs.getInstance(this.jaxbParser, this.errorLogger, arguments);
                break;
            case HELP:
                commandObject = Help.getInstance();
                break;
            case EXIT:
                commandObject = Exit.getInstance(this.jaxbParser);
                break;
            default:
                throw new InvalidCommandException("Please enter a valid command!");
        }

        return commandObject;
    }
}