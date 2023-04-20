package commandlineinterface;

public class Close implements Command {
    private static Close instance;

    private Close(){}

    public static Close getInstance() {
        if(instance == null) {
            instance = new Close();
            return instance;
        }
        return instance;
    }
}