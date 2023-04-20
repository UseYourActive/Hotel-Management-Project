package commandlineinterface;

public enum Commands {
    OPEN("Open"),
    CLOSE("Close"),
    SAVE("Save"),
    SAVE_AS("Save as"),
    HELP("Help"),
    EXIT("Exit");

    private final String command;

    Commands(String roomType) {
        this.command = roomType;
    }

    @Override
    public String toString() {
        return command;
    }
}