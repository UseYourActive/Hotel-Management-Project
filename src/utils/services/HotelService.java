package utils.services;

import models.Hotel;
import utils.errorlogger.ErrorLogWriter;
import utils.parsers.FileParser;

import javax.xml.bind.JAXBException;
import java.io.File;

public class HotelService {
    private File file;
    private Hotel repository;
    private FileParser<Hotel> jaxbParser;
    private ErrorLogWriter errorLogWriter;

    public HotelService() {}

    public HotelService(ErrorLogWriter errorLogWriter, FileParser<Hotel> jaxbParser) {
        this.repository = Hotel.getInstance(errorLogWriter);
        this.jaxbParser = jaxbParser;
    }

    public void loadRepository() throws JAXBException {
        repository = jaxbParser.readFromFile(file);
    }

    public void exportToFile() throws JAXBException {
        jaxbParser.writeToFile(repository, file);
    }

    public void createFileIfNotExist() throws JAXBException {
        jaxbParser.createFileIfNotExist(repository, file);
    }

    public void deleteFile(String pathway) throws Exception {
        if(!(jaxbParser.deleteFile(new File(pathway)))){
            throw new Exception("File cannot be deleted");
        }
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Hotel getRepository() {
        return repository;
    }

    public void setRepository(Hotel repository) {
        this.repository = repository;
    }
}
