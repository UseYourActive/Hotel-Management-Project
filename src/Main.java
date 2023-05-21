import models.Hotel;
import models.reservations.Reservation;
import models.rooms.PresidentRoom;
import models.rooms.Room;
import utils.parsers.xml.JAXBParser;

import java.io.File;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {
        //Application.run();

        JAXBParser jaxbParser = new JAXBParser();
        Hotel hotel = new Hotel();

        LocalDate start1 = LocalDate.parse("2024-10-10");
        LocalDate end1 = LocalDate.parse("2024-10-13");
        String note1 = "QKOBACH";
        int numberOfGuests1 = 1;

        Room room1 = new PresidentRoom();
        Reservation reservation1 = new Reservation(start1, end1, note1, numberOfGuests1);

        room1.addReservation(reservation1);

        for (Room room : hotel.getHotelRooms()) {
            room.addReservation(reservation1);
        }

        jaxbParser.writeToFile(hotel, new File("book1.xml"));
    }
}