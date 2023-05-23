package models.rooms;

import exceptions.reservations.ReservationAlreadyExistsException;
import exceptions.rooms.NoRoomFoundException;
import models.reservations.Reservation;
import models.reservations.enums.ReservationStatus;

import javax.xml.bind.annotation.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@XmlAccessorType(XmlAccessType.FIELD)
public class Room implements Comparable<Room> {
    @XmlAttribute(name = "id")
    private long number;

    @XmlElement(name = "numberOfBeds")
    private int numberOfBeds;

    @XmlElementWrapper(name = "reservations")
    @XmlElement(name = "reservation")
    private Set<Reservation> reservations;

    public Room() {
        this.reservations = new HashSet<>();
    }

    @SuppressWarnings("All")
    public boolean addReservation(Reservation reservation) throws ReservationAlreadyExistsException {
        return reservations.add(reservation);
    }

    public boolean removeReservation(Reservation reservation) {
        return reservations.remove(reservation);
    }

    @SuppressWarnings("All")
    public boolean checkReservationStatus(LocalDate date) {
        for (Reservation reservation : reservations) {
            LocalDate startDate = reservation.getStartDate();
            LocalDate endDate = reservation.getEndDate();

            if (date.compareTo(startDate) >= 0 && date.compareTo(endDate) <= 0) {
                return false;
            }
        }
        return true;
    }

    public void updateRoomStatusCheckedOut() throws NoRoomFoundException {
        for(Reservation reservation : reservations){
            if(reservation.getStatus() == ReservationStatus.CURRENT){
                reservation.setStatus(ReservationStatus.PAST);
                return;
            }
        }
        throw new NoRoomFoundException("No room found");
    }

    public boolean checkRoomIfAvailable(LocalDate from, LocalDate to) {
        for (Reservation reservation : reservations) {
            if (!reservation.checkCompatability(from, to)) {
                return false;
            }
        }
        return true;
    }

    public Reservation getFreeReservation(LocalDate from, LocalDate to){
        for(Reservation reservation : reservations){
            if((reservation.getStartDate().isBefore(from) && reservation.getEndDate().isBefore(from)) || (reservation.getStartDate().isAfter(to) && reservation.getEndDate().isAfter(to))){
                return reservation;
            }
        }return null;
    }

    public Reservation getBusyReservation(LocalDate from, LocalDate to){
        for(Reservation reservation : reservations){
            if(reservation.getStartDate().isAfter(from) && reservation.getEndDate().isBefore(to)){
                return reservation;
            }
        }return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Room number: ").append(this.number).append("\n");
        stringBuilder.append("Number of beds: ").append(this.numberOfBeds).append("\n");

        for (Reservation reservation : this.reservations) {
            stringBuilder.append("Reservations: \n").append(reservation).append("\n");
        }

        return String.valueOf(stringBuilder);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        return number == room.number;
    }

    @Override
    public int compareTo(Room o) {
        return this.getNumberOfBeds() - (o.getNumberOfBeds());
    }

    @Override
    public int hashCode() {
        return (int) (number ^ (number >>> 32));
    }

    public long getNumber() {
        return number;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Set<Reservation> getReservations() {
        return this.reservations;
    }

    public void setNumber(long number) {
        this.number = number;
    }
}