package models.reservation;

import adapters.LocalDateAdapter;
import adapters.ReservationStatusAdapter;
import exceptions.NotAValidBookingDateRangeException;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

public class Reservation {
    @XmlElement
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate startDate;
    @XmlElement
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate endDate;
    @XmlElement
    private String note;
    @XmlElement
    private int numberOfGuests;
    @XmlJavaTypeAdapter(ReservationStatusAdapter.class)
    private ReservationStatus status;

    public Reservation(){}

    public Reservation(LocalDate startDate, LocalDate endDate, String note, int numberOfGuests) throws NotAValidBookingDateRangeException {
        if(startDate.isAfter(endDate)){
            throw new NotAValidBookingDateRangeException("Unavailable booking");
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
