package rooms;

public class DoubleRoom extends Room {
    public DoubleRoom() {
        setNumberOfBeds(2);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("This is a Double Room").append("\n");
        stringBuilder.append("ID: ").append(getNumber()).append("\n");
        stringBuilder.append("Number of beds: ").append(getNumberOfBeds()).append("\n");
        stringBuilder.append("Note: ").append(getNote()).append("\n");
        stringBuilder.append("Number of guests: ").append(getNumberOfGuests()).append("\n");
        //stringBuilder.append("Guest list: ").append(getGuestList()).append("\n");

        return String.valueOf(stringBuilder);
    }
}