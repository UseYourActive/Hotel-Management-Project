package models.hotelcommands;

import exceptions.reservations.NotAValidReservationDateRangeException;
import exceptions.reservations.ReservationAlreadyExistsException;
import models.Hotel;
import models.hotelcommands.contracts.HotelCommand;
import models.reservation.Reservation;
import models.rooms.Room;

import java.time.LocalDate;
import java.util.List;

public class CheckIn implements HotelCommand {
    private Hotel hotel;
    private long id;
    private LocalDate from;
    private LocalDate to;
    private String note;
    private int argumentSize;
    private int numberOfGuests;

    public CheckIn(List<String> arguments, Hotel hotel) {
        this.hotel = hotel;
        this.id = Long.parseLong(arguments.get(0));
        this.from = LocalDate.parse(arguments.get(1));
        this.to = LocalDate.parse(arguments.get(2));
        this.note = arguments.get(3);
        this.argumentSize = arguments.size();

        if(argumentSize == 5){
            numberOfGuests = Integer.parseInt(arguments.get(4));
        }
    }

    @Override
    public void execute() throws NotAValidReservationDateRangeException, ReservationAlreadyExistsException {
        for(Room room : hotel.getHotelRooms()){
            if(room.getNumber() == id){
                if(argumentSize != 5) {
                    numberOfGuests = room.getNumberOfBeds();
                }

                Reservation reservation = new Reservation(from, to, note, numberOfGuests);
                if(!room.addReservation(reservation)){
                    throw new ReservationAlreadyExistsException("Can't make a reservation, one already exists");
                }
                break;
            }
        }

//        Регистриране в стая с номер <room> от дата <from> до дата <to> и се добавя бележка <note>.
//        Незадължителният параметър <guests> задава броя на гостите, настанени в стаята.
//        Ако той не е указан, се счита, че броят на настанените гости е равен на броя на леглата в стаята.
//        Пример: checkin 229 2020-03-23 2020-03-31 The Simpsons
    }
}
