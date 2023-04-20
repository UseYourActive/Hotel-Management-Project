package commandlineinterface;

public class Open implements Command {
    private static Open instance;

    private Open(){}

    public static Open getInstance() {
        if(instance == null) {
            instance = new Open();
            return instance;
        }
        return instance;
    }
}