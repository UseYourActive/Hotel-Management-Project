package models.hotel.commands;

import models.Hotel;
import models.hotel.commands.contracts.HotelCommand;
import models.reservations.Reservation;
import models.rooms.Room;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Report implements HotelCommand {
    private final LocalDate from;
    private final LocalDate to;
    private final List<Room> hotelRooms;

    public Report(List<String> arguments, Hotel hotel) {
        this.hotelRooms = hotel.getHotelRooms();
        this.from = LocalDate.parse(arguments.get(0)).minusDays(1);
        this.to = LocalDate.parse(arguments.get(1)).plusDays(1);
    }

    @Override
    public void execute() {
        Map<Long, Long> map = new HashMap<>();

        for (Room room : this.hotelRooms) {
            long numberOfDays = 0;
            for (Reservation reservation : room.getReservations()) {
                LocalDateTime start = reservation.getStartDate().atStartOfDay();
                LocalDateTime end = reservation.getEndDate().atStartOfDay();

                if (start.isAfter(from.atStartOfDay()) && end.isBefore(to.atStartOfDay())) {
                    numberOfDays += Duration.between(start, end).toDays();
                }
            }

            map.put(room.getNumber(), numberOfDays);
        }

        print(map);

//        Извежда справка за използването на стаи в периода от дата <from> до <to>.
//        Извежда се списък, в който за всяка стая, използвана в дадения период, се извежда и броя на дните, в които е била използвана.
    }

    private void print(Map<Long, Long> map) {
        for (Map.Entry<Long, Long> record : map.entrySet()) {
            long roomNumber = record.getKey();
            long numberOfDaysOccupied = record.getValue();

            if (numberOfDaysOccupied > 0) {
                System.out.println("Room: " + roomNumber + " Number of days occupied in the period: " + numberOfDaysOccupied);
            }
        }
    }
}
