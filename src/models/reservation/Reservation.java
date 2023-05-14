package models.reservation;

import models.reservation.enums.ReservationStatus;
import utils.adapters.LocalDateAdapter;
import utils.adapters.ReservationStatusAdapter;
import exceptions.reservations.NotAValidReservationDateRangeException;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)
public class Reservation {
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @XmlElement(name = "startDate")
    private LocalDate startDate;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @XmlElement(name = "endDate")
    private LocalDate endDate;
    @XmlElement(name = "note")
    private String note;
    @XmlElement(name = "numberOfGuests")
    private int numberOfGuests;
    @XmlJavaTypeAdapter(ReservationStatusAdapter.class)
    @XmlAttribute(name = "status")
    private ReservationStatus status;

    public Reservation(){}

    public Reservation(LocalDate startDate, LocalDate endDate, String note, int numberOfGuests) throws NotAValidReservationDateRangeException {
        if(startDate.isAfter(endDate)){
            throw new NotAValidReservationDateRangeException("models.hotelcommands.Unavailable booking");
        }
        this.startDate = startDate;
        this.endDate = endDate;
        this.note = note;
        this.numberOfGuests = numberOfGuests;
        this.status = defineStatus();
    }

    public ReservationStatus defineStatus(){
        if(LocalDate.now().isBefore(startDate)){
            return ReservationStatus.FUTURE;
        } else if(LocalDate.now().isAfter(endDate)){
            return ReservationStatus.PAST;
        }else {
            return ReservationStatus.CURRENT;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation that = (Reservation) o;

        if (!startDate.equals(that.startDate)) return false;
        if (!endDate.equals(that.endDate)) return false;
        return status == that.status;
    }

    @Override
    public int hashCode() {
        int result = startDate.hashCode();
        result = 31 * result + endDate.hashCode();
        result = 31 * result + status.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Start date: ").append(this.startDate).append("\n");
        stringBuilder.append("End date: ").append(this.endDate).append("\n");
        stringBuilder.append("Note: ").append(this.note).append("\n");
        stringBuilder.append("Number of guests: ").append(this.numberOfGuests).append("\n");

        return String.valueOf(stringBuilder);
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }
}
