package models.reservations.enums;

public enum ReservationStatus {
    CURRENT("Current"),

    PAST("Past"),

    FUTURE("Future"),

    NONE("None"),
    UNAVAILABLE("Unavailable");

    private final String status;

    ReservationStatus(String name) {
        this.status = name;
    }

    @Override
    public String toString() {
        return this.status;
    }
}
