import exceptions.GuestAlreadyInRoomException;
import guest.Guest;
import rooms.Room;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class Reservation {
    private LocalDate from;
    private LocalDate to;
    private int roomNumber;
    private List<Guest> guests;
    private List<Room> rooms;
    private String note;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");

    public void checkIn(int roomNumber, LocalDate from, LocalDate to, String note, List<Guest> guestList, int numberOfGuests) throws GuestAlreadyInRoomException {
        for(Room room : rooms) {
            if(roomNumber == room.getNumber() && numberOfGuests <= room.getNumberOfBeds()) {
                for(Guest guest : guestList) {
                    room.addGuest(guest);
                }
                room.setNote(note);
                room.setAvailable(false);
                this.from = from;
                this.to = to;
            }
        }
//        Регистриране в стая с номер <room> от дата <from> до дата <to> и се добавя бележка <note>.
//        Незадължителният параметър <guests> задава броя на гостите, настанени в стаята.
//        Ако той не е указан, се счита, че броят на настанените гости е равен на броя на леглата в стаята.
//        Пример: checkin 229 2020-03-23 2020-03-31 The Simpsons
    }

    public void checkIn(int roomNumber, LocalDate from, LocalDate to, String note, List<Guest> guestList) throws GuestAlreadyInRoomException {
        for(Room room : rooms) {
            int numberOfGuests = room.getNumberOfBeds();
            if(roomNumber == room.getNumber() && numberOfGuests == room.getNumberOfBeds()) {
                for(Guest guest : guestList) {
                    room.addGuest(guest);
                }
                room.setNote(note);
                room.setAvailable(false);
                this.from = from;
                this.to = to;
            }
        }
//        Регистриране в стая с номер <room> от дата <from> до дата <to> и се добавя бележка <note>.
//        Незадължителният параметър <guests> задава броя на гостите, настанени в стаята.
//        Ако той не е указан, се счита, че броят на настанените гости е равен на броя на леглата в стаята.
//        Пример: checkin 229 2020-03-23 2020-03-31 The Simpsons
    }

    public void availability(LocalDate date) {
//        Извежда списък на свободните стаи на дата <date>, ако не е зададена, се използва текущата дата.
    }

    public void availability() {
        LocalDate today = LocalDate.now();

        for(Room room : rooms) {
            room.isAvailable();
        }

//        Извежда списък на свободните стаи на дата <date>, ако не е зададена, се използва текущата дата.
    }

    public void checkOut(Room room) {
//        Освобождаване на заета стая с номер <room>.
    }

    public void report(Date from, Date to) {
//        Извежда справка за използването на стаи в периода от дата <from> до <to>.
//        Извежда се списък, в който за всяка стая, използвана в дадения период, се извежда и броя на дните, в които е била използвана.
    }

    public String find(int numberOfBeds, Date from, Date to) {
//        Намиране на подходяща свободна стая с поне <beds> на брой легла в периода от <from> до <to>.
//        При наличие на повече свободни стаи се предпочитат такива с по-малко на брой легла.

        StringBuilder availableRooms = new StringBuilder();

        for (Room room : rooms) {
            if (room.isAvailable()) {
                availableRooms.append("\n").append("\n").append(room);
            }
        }

        return String.valueOf(availableRooms);
    }

    public String find() {
//        Намиране на подходяща свободна стая с поне <beds> на брой легла в периода от <from> до <to>.
//        При наличие на повече свободни стаи се предпочитат такива с по-малко на брой легла.


        LocalDate today = LocalDate.now();

        StringBuilder availableRooms = new StringBuilder();
        for (Room room : rooms) {
            if(room.isAvailable()) {
                availableRooms.append("\n").append("\n").append(room);
            }
        }
        return String.valueOf(availableRooms);
    }

    public String findImportant(int numberOfBeds, Date from, Date to) {
//        Да се реализира алгоритъм, който предлага спешно намиране на стая за важен гост в случай на липса на свободни стаи за даден период.
//        Алгоритъмът да предлага разместване на настанените от най-много две стаи.

        StringBuilder availableRooms = new StringBuilder();

        for (Room room : rooms) {
            if (room.isAvailable()) {
                availableRooms.append("\n").append("\n").append(room);
            }
        }

        return String.valueOf(availableRooms);
    }

    public void unavailable(Room room, Date from, Date to, String note) {
//        Обявява стаята с номер <room> от дата <from> до дата <to> за временно недостъпна и се добавя бележка <note>.
//        В стаята няма регистриран гост, но никой не може да бъде настанен в нея.
//        Пример: unavailable 200 2018-06-01 2019-03-01 Under construction
    }
}