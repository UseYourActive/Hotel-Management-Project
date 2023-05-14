package models.rooms;

import exceptions.rooms.NoRoomFoundException;
import exceptions.reservations.ReservationAlreadyExistsException;
import models.reservation.Reservation;
import models.reservation.enums.ReservationStatus;

import javax.xml.bind.annotation.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@XmlAccessorType(XmlAccessType.FIELD)
public class Room implements Comparable<Room>{
    @XmlTransient
    private static final AtomicInteger _ID = new AtomicInteger(0);
    @XmlAttribute(name = "number")
    private final long number;
    @XmlElement(name = "numberOfBeds")
    private int numberOfBeds;
    @XmlTransient
    private Set<Reservation> reservations;

    public Room() {
        this.number = _ID.incrementAndGet();
        reservations = new HashSet<>();
    }

    public boolean addReservation(Reservation reservation) throws ReservationAlreadyExistsException {
        return reservations.add(reservation);
    }

    public boolean removeReservation(Reservation reservation){
        return reservations.remove(reservation);
    }

    public boolean method(LocalDate date){
        for(Reservation reservation : reservations){
            if (!(date.isAfter(reservation.getStartDate()) && date.isBefore(reservation.getEndDate()))) {
                return true;
            }
        }
        return false;
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
        for(Reservation reservation : reservations){
            if(reservation.getStatus() == ReservationStatus.CURRENT){
                if((reservation.getStartDate().isBefore(from) && reservation.getEndDate().isBefore(from)) || (reservation.getStartDate().isAfter(to) && reservation.getEndDate().isAfter(to))){
                    return true;
                }
            }
        } return false;
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

    @SuppressWarnings("All")
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Room number: ").append(this.number).append("\n");
        stringBuilder.append("Number of beds: ").append(this.numberOfBeds).append("\n");
        stringBuilder.append("Reservations: ").append(this.reservations).append("\n");

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

    @XmlElement(name = "reservation")
    public Set<Reservation> getReservations() {
        return this.reservations;
    }
}