package models.hotel.commands.enums;

public enum HotelCommands {
    CHECKIN("checkin"),
    AVAILABILITY("availability"),
    CHECKOUT("checkout"),
    REPORT("report"),
    FIND("find"),
    FINDIMPORTANT("findimportant"),
    UNAVAILABLE("unavailable");

    private String choice;

    HotelCommands(String choice) {
        this.choice = choice;
    }

    @Override
    public String toString() {
        return this.choice;
    }

    public String getChoice() {
        return choice;
    }
}
