package models.services;

import models.Hotel;
import utils.parsers.FileParser;

import javax.xml.bind.JAXBException;
import java.io.File;

public class HotelService {
    private File file;
    private Hotel repository;
    private final FileParser<Hotel> jaxbParser;

    public HotelService(FileParser<Hotel> jaxbParser) {
        this.repository = new Hotel();
        this.jaxbParser = jaxbParser;
    }

    public void loadRepository() throws JAXBException {
        this.repository = this.jaxbParser.readFromFile(this.file);
    }

    public void exportToFile() throws JAXBException {
        this.jaxbParser.writeToFile(this.repository, this.file);
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setRepository(Hotel repository) {
        this.repository = repository;
    }

    public Hotel getRepository() {
        return repository;
    }
}
