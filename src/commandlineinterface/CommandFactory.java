package commandlineinterface;

import exceptions.InvalidCommandException;

public class CommandFactory {
    public Command createCommand(Commands command) throws InvalidCommandException {
        Command commandObject;

        if(command == null) {
            throw new InvalidCommandException("Please enter a valid command!", new RuntimeException());
        }

        switch (command) {
            case OPEN:
                commandObject = Open.getInstance();
                break;
            case CLOSE:
                commandObject = Close.getInstance();
                break;
            case SAVE:
                commandObject = Save.getInstance();
                break;
            case SAVE_AS:
                commandObject = SaveAs.getInstance();
                break;
            case HELP:
                commandObject = Help.getInstance();
                break;
            case EXIT:
                commandObject = Exit.getInstance();
                break;
            default:
                throw new InvalidCommandException("Please enter a valid command!");
        }

        return commandObject;
    }
}