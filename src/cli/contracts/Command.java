package cli.contracts;

import exceptions.HotelException;

import javax.xml.bind.JAXBException;

public interface Command {
    void execute() throws HotelException, JAXBException;
}