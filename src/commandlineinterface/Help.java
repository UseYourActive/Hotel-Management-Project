package commandlineinterface;

public class Help implements Command
{
    //region Members of the class
    private static Help instance;
    //endregion

    //region Constructor of the class
    private Help(){}
    //endregion

    //region Methods of the class
    public static Help getInstance()
    {
        if(instance == null)
        {
            instance = new Help();
            return instance;
        }

        return instance;
    }

    public void execute()
    {
        System.out.println("""
                The following commands are supported:
                open               <file> opens <file>
                close              closes currently opened file
                save               saves the currently open file
                saveas <file>      saves the currently open file in <file>")
                help               prints this information
                exit               exits the program
                """);
    }
    //endregion

    //region Overrides
    //endregion

    //region Accessors and Mutators of the class
    //endregion
}