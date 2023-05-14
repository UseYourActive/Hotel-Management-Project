package commandlineinterface.enums;

public enum DefaultCommands {
    OPEN("open"),
    CLOSE("close"),
    SAVE("save"),
    SAVEAS("saveas"),
    HELP("help"),
    EXIT("exit");

    private final String command;

    DefaultCommands(String roomType) {
        this.command = roomType;
    }

    @Override
    public String toString() {
        return command;
    }

    public String getCommand() {
        return command;
    }
}