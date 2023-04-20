package commandlineinterface;

public class Exit implements Command {
    private static Exit instance;

    private Exit(){}

    public static Exit getInstance() {
        if(instance == null) {
            instance = new Exit();
            return instance;
        }
        return instance;
    }
}