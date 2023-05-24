package models.rooms;

public class DoubleRoom extends Room {
    public DoubleRoom() {
        setNumberOfBeds(2);
    }

    @SuppressWarnings("All")
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("This is a Double Room").append("\n");
        stringBuilder.append("Room number: ").append(getNumber()).append("\n");
        stringBuilder.append("Number of beds: ").append(getNumberOfBeds()).append("\n");

        return String.valueOf(stringBuilder);
    }
}