package xmlparsers;

import models.hotel.Hotel;

import javax.xml.bind.*;
import java.io.*;

public final class JAXBParser {
    private File file;
    private Hotel hotel;

    public JAXBParser() {}

    public JAXBParser(Hotel hotel) {
        this.hotel = hotel;
    }

    public void readFromFile() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Hotel.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        hotel = (Hotel) unmarshaller.unmarshal(this.file);
    }

    public void writeToFile() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Hotel.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(hotel, this.file);
    }

    public void createFileIfNotExist(String pathway) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Hotel.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(hotel, new File(pathway));
    }

    public boolean deleteFile(String pathway){
        File file = new File(pathway);
        return file.delete();
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}