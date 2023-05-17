package models.hotelcommands;

import exceptions.reservations.NotAValidReservationDateRangeException;
import exceptions.reservations.ReservationAlreadyExistsException;
import exceptions.rooms.UnavailableRoomException;
import models.Hotel;
import models.hotelcommands.contracts.HotelCommand;
import models.reservations.Reservation;
import models.rooms.Room;

import java.time.LocalDate;
import java.util.List;

public class Unavailable implements HotelCommand {
    private Hotel hotel;
    private long id;
    private LocalDate from;
    private LocalDate to;
    private String note;

    public Unavailable(List<String> arguments, Hotel hotel) {
        this.hotel = hotel;
        this.id = Long.parseLong(arguments.get(0));
        this.from = LocalDate.parse(arguments.get(1));
        this.to = LocalDate.parse(arguments.get(2));
        this.note = arguments.get(3);
    }

    @Override
    public void execute() throws NotAValidReservationDateRangeException, UnavailableRoomException, ReservationAlreadyExistsException {

        for(Room room : hotel.getHotelRooms()){
            if(room.getNumber() == id){
                if(!room.addReservation(new Reservation(from, to, note, 0))){
                    throw new UnavailableRoomException("There is already a restriction to this room");
                }
                break;
            }
        }

//        Обявява стаята с номер <room> от дата <from> до дата <to> за временно недостъпна и се добавя бележка <note>.
//        В стаята няма регистриран гост, но никой не може да бъде настанен в нея.
//        Пример: unavailable 200 2018-06-01 2019-03-01 Under construction
    }
}
