package models.hotel.commands;

import exceptions.reservations.NotAValidReservationDateRangeException;
import exceptions.reservations.ReservationAlreadyExistsException;
import exceptions.rooms.NoRoomFoundException;
import models.Hotel;
import models.hotel.commands.contracts.HotelCommand;
import models.reservations.Reservation;
import models.reservations.enums.ReservationStatus;
import models.rooms.Room;

import java.time.LocalDate;
import java.util.List;

public class Unavailable implements HotelCommand {
    private final long id;
    private final LocalDate from;
    private final LocalDate to;
    private final String note;
    private final List<Room> hotelRooms;

    public Unavailable(List<String> arguments, Hotel hotel) {
        this.hotelRooms = hotel.getHotelRooms();
        this.id = Long.parseLong(arguments.get(0));
        this.from = LocalDate.parse(arguments.get(1));
        this.to = LocalDate.parse(arguments.get(2));
        this.note = arguments.get(3);
    }

    @Override
    public void execute() throws NotAValidReservationDateRangeException, ReservationAlreadyExistsException, NoRoomFoundException {
        for (Room room : this.hotelRooms) {
            if (room.getNumber() == this.id) {
                Reservation customReservation = new Reservation(this.from, this.to, this.note, 0);
                customReservation.setStatus(ReservationStatus.UNAVAILABLE);

                for (Reservation reservation : room.getReservations()) {
                    if (!reservation.checkCompatability(this.from, this.to)) {
                        room.removeReservation(reservation);
                        break;
                    }
                }

                room.addReservation(customReservation);
                System.out.println("Successfully made unavailable room with number " + room.getNumber() + " from " + this.from + " to " + this.to + " with note " + this.note);

                break;
            }
        }

//        Обявява стаята с номер <room> от дата <from> до дата <to> за временно недостъпна и се добавя бележка <note>.
//        В стаята няма регистриран гост, но никой не може да бъде настанен в нея.
//        Пример: unavailable 200 2018-06-01 2019-03-01 Under construction
    }
}
