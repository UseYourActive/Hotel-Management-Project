package commandlineinterface;

public enum DefaultCommands {
    OPEN("Open"),
    CLOSE("Close"),
    SAVE("Save"),
    SAVE_AS("Save as"),
    HELP("Help"),
    EXIT("Exit");

    private final String command;

    DefaultCommands(String roomType) {
        this.command = roomType;
    }

    @Override
    public String toString() {
        return command;
    }
}