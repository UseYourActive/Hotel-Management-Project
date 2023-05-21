package utils.parsers;

import models.Hotel;

import javax.xml.bind.JAXBException;
import java.io.File;

public interface FileParser <T> {
    T readFromFile(File file) throws JAXBException;
    void writeToFile(Hotel hotel, File file) throws JAXBException;
}
