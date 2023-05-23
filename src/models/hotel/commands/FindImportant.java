package models.hotel.commands;

import exceptions.reservations.NotAValidReservationDateRangeException;
import models.Hotel;
import models.hotel.commands.contracts.HotelCommand;
import models.reservations.Reservation;
import models.reservations.enums.ReservationStatus;
import models.rooms.Room;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class FindImportant extends Find implements HotelCommand {
    private Hotel hotel;

    public FindImportant(List<String> arguments, Hotel hotel) {
        super(arguments, hotel);
        this.hotel = hotel;
    }

    @Override
    public void execute() throws NotAValidReservationDateRangeException {
        List<Room> foundedRooms = super.getRoomList(getNumberOfBeds(), getFrom(), getTo());

        if (!foundedRooms.isEmpty()) {
            for (Room room : foundedRooms) {
                System.out.println(room.getNumber());
            }
        } else {
            System.out.println("No available rooms have been found. We must attempt to move someone else's reservation!");

            foundedRooms = getHotelRooms();
            Collections.sort(foundedRooms);

            for (Room room : foundedRooms) {
                if (room.getNumberOfBeds() >= getNumberOfBeds()) {
                    for (Reservation reservation : room.getReservations()) {
                        if (!reservation.checkIfReservationBusy(getFrom(), getTo())) {
                            continue;
                        }

                        if (reservation.getStatus() == ReservationStatus.UNAVAILABLE) {
                            continue;
                        }

                        System.out.println("Room number: " + room.getNumber());
                        System.out.println(reservation);
                        System.out.println("Do you want to move this reservation to other date or room ?(y/n):\n");

                        if (userPrompt()) {
                            redoReservation(room, reservation);

                            room.getReservations().remove(reservation);
                            System.out.println("Make sure the VIP reservation has been made to this room, because we kicked old guests:\n" + room);

                            return;
                        } else {
                            break;
                        }
                    }
                }
            }

            System.out.println("No changes have been made!");
        }
//        Да се реализира алгоритъм, който предлага спешно намиране на стая за важен гост в случай на липса на свободни стаи за даден период.
//        Алгоритъмът да предлага разместване на настанените от най-много две стаи.
    }

    private boolean userPrompt() {
        Scanner scanner = new Scanner(System.in);

        String userInput = scanner.nextLine().toLowerCase();

        while (true) {
            if (Objects.equals(userInput, "y")) {
                return true;
            }
            if (Objects.equals(userInput, "n")) {
                return false;
            }
        }
    }

    private void redoReservation(Room room, Reservation reservation) {
        System.out.println("Please enter new start and end date of the reservation!");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                String userInput = scanner.nextLine();
                List<String> arguments = List.of(userInput.split("\\s+"));

                LocalDate startDate = LocalDate.parse(arguments.get(0));
                LocalDate endDate = LocalDate.parse(arguments.get(1));

                Reservation newReservation = new Reservation(startDate, endDate, reservation.getNote(), reservation.getNumberOfGuests());

                if (room.addReservation(newReservation)) {
                    break;
                }

                System.out.println("Such reservation already exists!");
            } catch (NotAValidReservationDateRangeException ignored) {
                System.out.println("Please enter valid data!");
            }
        }
    }
}
