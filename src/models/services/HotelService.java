package models.services;

import models.Hotel;
import utils.parsers.FileParser;

import javax.xml.bind.JAXBException;
import java.io.File;

public class HotelService {
    private File file;
    private Hotel repository;
    private FileParser<Hotel> jaxbParser;

    public HotelService() {
    }

    public HotelService(FileParser<Hotel> jaxbParser, Hotel hotel) {
        this.repository = hotel;
        this.jaxbParser = jaxbParser;
    }

    public void loadRepository() throws JAXBException {
        repository = jaxbParser.readFromFile(file);
    }

    public void exportToFile() throws JAXBException {
        jaxbParser.writeToFile(repository, file);
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

    public FileParser<Hotel> getJaxbParser() {
        return jaxbParser;
    }

    public void setJaxbParser(FileParser<Hotel> jaxbParser) {
        this.jaxbParser = jaxbParser;
    }
}
