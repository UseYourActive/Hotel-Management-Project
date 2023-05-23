package utils.adapters;

import models.reservations.enums.ReservationStatus;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class ReservationStatusAdapter extends XmlAdapter<String, ReservationStatus> {
    @Override
    public ReservationStatus unmarshal(String s){
        return ReservationStatus.valueOf(s.toUpperCase());
    }

    @Override
    public String marshal(ReservationStatus reservationStatus){
        return reservationStatus.toString();
    }
}
