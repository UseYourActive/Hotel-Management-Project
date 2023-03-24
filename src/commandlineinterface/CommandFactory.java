package commandlineinterface;

public class CommandFactory
{
    /* Members of the class. */
    /*----------------------------------------------------------------------*/

    /* Constructor of the class. */
    /*----------------------------------------------------------------------*/

    /* Methods of the class. */
    public Commandable createRoom(Commands command) throws InvalidCommandException
    {
        Commandable commandObject;

        if(command == null)
        {
            throw new InvalidCommandException("Please enter a valid command!", new RuntimeException());
        }

        switch (command)
        {
            case OPEN:
                commandObject = new Open();
                break;
            case CLOSE:
                commandObject = new Close();
                break;
            case SAVE:
                commandObject = new Save();
                break;
            case SAVE_AS:
                commandObject = new SaveAs();
                break;
            case HELP:
                commandObject = new Help();
                break;
            case EXIT:
                commandObject = new Exit();
                break;
            default:
                throw new InvalidCommandException("Please enter a valid command!");
        }

        return commandObject;
    }
    /*----------------------------------------------------------------------*/

    /* Overrides. */
    /*----------------------------------------------------------------------*/

    /* Accessors and Mutators of the class. */
    /*----------------------------------------------------------------------*/
}