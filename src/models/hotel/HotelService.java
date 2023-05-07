package models.hotel;

import java.time.Duration;
import java.time.LocalDate;
import java.util.*;

import exceptions.NoRoomFoundException;
import exceptions.NotAValidBookingDateRangeException;
import exceptions.ReservationAlreadyExistsException;
import models.reservation.Reservation;
import models.rooms.Room;
import xmlparsers.JAXBParser;

public class HotelService {
    private Hotel hotel;
    private List<String> arguments;
    private JAXBParser jaxbParser;

    public HotelService(Hotel hotel, List<String> arguments) {
        this.hotel = hotel;
        this.arguments = arguments;
        jaxbParser = new JAXBParser();
    }

    public void checkIn() throws ReservationAlreadyExistsException, NotAValidBookingDateRangeException {
        long id = Long.parseLong(arguments.get(0));
        LocalDate from = LocalDate.parse(arguments.get(1));
        LocalDate to = LocalDate.parse(arguments.get(2));
        String note = arguments.get(3);
        int numberOfGuests;

        for(Room room : Hotel.getHotelRooms()){
            if(room.getNumber() == id){
                if(arguments.size() == 5) {
                    numberOfGuests = Integer.parseInt(arguments.get(4));
                }else {
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

    public void availability() {
        LocalDate date;
        Set<Room> roomList = new HashSet<>();

        if(arguments.isEmpty()){
            date = LocalDate.now();
        }else {
            date = LocalDate.parse(arguments.get(0));
        }

        for(Room room : Hotel.getHotelRooms()){
            if(room.method(date)){
                roomList.add(room);
            }
        }

        for(Room room : roomList){
            System.out.println(room);
        }

//        Извежда списък на свободните стаи на дата <date>, ако не е зададена, се използва текущата дата.
    }

    public void checkOut() throws NoRoomFoundException {
        long id = Long.parseLong(arguments.get(0));

        for(Room room : Hotel.getHotelRooms()){
            if(room.getNumber() == id){
                room.updateRoomStatusCheckedOut();
            }
        }

//        Освобождаване на заета стая с номер <room>.
    }

    public void report() {
        LocalDate from = LocalDate.parse(arguments.get(0)).minusDays(1);
        LocalDate to = LocalDate.parse(arguments.get(1)).plusDays(1);

        Map<Long, Long> map = new HashMap<>();

        for(Room room : Hotel.getHotelRooms()){
            long numberOfDays = 0;
            for(Reservation reservation : room.getReservations()){
                LocalDate start = reservation.getStartDate();
                LocalDate end = reservation.getEndDate();
                if(start.isAfter(from) && end.isBefore(to)){
                   numberOfDays += Duration.between(start, end).toDays();
                }
            }
            map.put(room.getNumber(), numberOfDays);
        }

        for(Map.Entry<Long, Long> record : map.entrySet()){
            System.out.println("Room: " + record.getKey() + " Number of days occupied in the period: " + record.getValue());
        }

//        Извежда справка за използването на стаи в периода от дата <from> до <to>.
//        Извежда се списък, в който за всяка стая, използвана в дадения период, се извежда и броя на дните, в които е била използвана.
    }

    public List<Room> find() throws Exception {
        int numberOfBeds = Integer.parseInt(arguments.get(0));
        LocalDate from = LocalDate.parse(arguments.get(1));
        LocalDate to = LocalDate.parse(arguments.get(2));

        List<Room> roomList = new ArrayList<>();

        for(Room room : Hotel.getHotelRooms()){
            if(room.getNumberOfBeds() >= numberOfBeds){
                if(room.checkRoomIfAvailable(from,to)){
                    roomList.add(room);
                }
            }
        }

        Collections.sort(roomList);

        for(Room room : roomList){
            System.out.println(room);
        }

        return roomList;
//        Намиране на подходяща свободна стая с поне <beds> на брой легла в периода от <from> до <to>.
//        При наличие на повече свободни стаи се предпочитат такива с по-малко на брой легла.
    }

    public void findImportant() throws Exception {
        if(!(find().isEmpty())){
            return;
        }

        int numberOfBeds = Integer.parseInt(arguments.get(0));
        LocalDate from = LocalDate.parse(arguments.get(1));
        LocalDate to = LocalDate.parse(arguments.get(2));

        List<Room> roomList = new ArrayList<>();

        for(Room room : Hotel.getHotelRooms()){
            if(room.getNumberOfBeds() >= numberOfBeds){
                roomList.add(room);
            }
        }

        for(Room fromRoom : roomList){
            if(fromRoom.getBusyReservation(from,to) == null){
                continue;
            }
            for(Room toRoom : roomList){
                if(fromRoom.equals(toRoom)){
                    continue;
                }

                if(fromRoom.getBusyReservation(from, to).getNumberOfGuests() <= toRoom.getNumberOfBeds() && toRoom.getFreeReservation(from, to) != null){
                    System.out.println("It is possible to move reservation from " + fromRoom + " to " + toRoom + ". Do you wish to do it? Yes/No");
                }
            }
        }

//        Да се реализира алгоритъм, който предлага спешно намиране на стая за важен гост в случай на липса на свободни стаи за даден период.
//        Алгоритъмът да предлага разместване на настанените от най-много две стаи.
    }

    public void unavailable() throws Exception {
        long id = Long.parseLong(arguments.get(0));
        LocalDate from = LocalDate.parse(arguments.get(1));
        LocalDate to = LocalDate.parse(arguments.get(2));
        String note = arguments.get(3);

        for(Room room : Hotel.getHotelRooms()){
            if(room.getNumber() == id){
                if(!room.addReservation(new Reservation(from, to, note, 0))){
                    throw new Exception("There is already a restriction to this room");
                }
                break;
            }
        }

//        Обявява стаята с номер <room> от дата <from> до дата <to> за временно недостъпна и се добавя бележка <note>.
//        В стаята няма регистриран гост, но никой не може да бъде настанен в нея.
//        Пример: unavailable 200 2018-06-01 2019-03-01 Under construction
    }
}