package models.reservations.enums;

public enum ReservationStatus {
    CURRENT("Current"),
    PAST("Past"),
    FUTURE("Future"),
    NONE("None");

    private final String name;

    ReservationStatus(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
