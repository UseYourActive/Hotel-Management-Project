package models.rooms;

public class PresidentRoom extends Room {
    public PresidentRoom() {
        setNumberOfBeds(4);
    }

    @SuppressWarnings("All")
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("This is a President Room").append("\n");
        stringBuilder.append("Room number: ").append(getNumber()).append("\n");
        stringBuilder.append("Number of beds: ").append(getNumberOfBeds()).append("\n");

        return String.valueOf(stringBuilder);
    }
}