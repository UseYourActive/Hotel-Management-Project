package models.rooms;

public class SingleRoom extends Room {
    public SingleRoom() {
        setNumberOfBeds(1);
    }

    @SuppressWarnings("All")
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("This is a Single Room").append("\n");
        stringBuilder.append("Room number: ").append(getNumber()).append("\n");
        stringBuilder.append("Number of beds: ").append(getNumberOfBeds()).append("\n");

        return String.valueOf(stringBuilder);
    }
}