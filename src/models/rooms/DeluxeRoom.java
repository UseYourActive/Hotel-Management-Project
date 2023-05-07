package models.rooms;

public class DeluxeRoom extends Room {

    public DeluxeRoom() {
        setNumberOfBeds(3);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("This is a Deluxe Room").append("\n");
        stringBuilder.append("Room number: ").append(getNumber()).append("\n");
        stringBuilder.append("Number of beds: ").append(getNumberOfBeds()).append("\n");

        return String.valueOf(stringBuilder);
    }
}