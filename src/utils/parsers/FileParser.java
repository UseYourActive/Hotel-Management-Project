package utils.parsers;

import javax.xml.bind.JAXBException;
import java.io.File;

public interface FileParser<T> {
    T readFromFile(File file) throws JAXBException;

    void writeToFile(T object, File file) throws JAXBException;
}