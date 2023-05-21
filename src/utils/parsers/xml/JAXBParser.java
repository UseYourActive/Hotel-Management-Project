package utils.parsers.xml;

import models.Hotel;
import utils.parsers.FileParser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JAXBParser implements FileParser<Hotel> {
    public JAXBParser() {}

    public Hotel readFromFile(File file) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Hotel.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (Hotel) unmarshaller.unmarshal(file);
    }

    public void writeToFile(Hotel hotel, File file) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Hotel.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(hotel, file);
    }
}
