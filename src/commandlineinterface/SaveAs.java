package commandlineinterface;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveAs implements Command {
    private static SaveAs instance;

    private SaveAs(){}

    public static SaveAs getInstance() {
        if(instance == null) {
            instance = new SaveAs();
            return instance;
        }
        return instance;
    }

    public void saveAs(String fileData, String data) throws IOException {
        File file = new File(fileData);

        if(!file.exists()) {
            file.createNewFile();
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

        bufferedWriter.write(data);

        bufferedWriter.close();
    }
}