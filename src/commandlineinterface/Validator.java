package commandlineinterface;

import java.io.File;

public class Validator {
    public Validator() {}

    @SuppressWarnings("All")
    public boolean isFileOpened(File file) {
        if(file != null) {
            return true;
        }
        return false;
    }

    @SuppressWarnings("All")
    public boolean isNullOrEmpty(String string) {
        if(string.length() == 0 || string == null) {
            return true;
        }
        return false;
    }
}