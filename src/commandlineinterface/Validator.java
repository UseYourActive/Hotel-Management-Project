package commandlineinterface;

import java.io.File;

public interface Validator {
    boolean isFileOpened(File file);
    boolean isNullOrEmpty(String string);
}