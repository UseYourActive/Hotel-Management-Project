package commandlineinterface;

public class Help implements Command
{
    private static Help instance;

    private Help(){}

    public static Help getInstance() {
        if(instance == null) {
            instance = new Help();
            return instance;
        }
        return instance;
    }

    public void execute() {
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
}