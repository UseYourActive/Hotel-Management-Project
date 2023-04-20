package rooms;

public class SingleRoom extends Room {
    //imashe parametur za int numberOfBeds i go setvashe sus super i vuv factorito s 1
    public SingleRoom() {
        setNumberOfBeds(1);
    }

    @SuppressWarnings("All")
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("This is a Single Room").append("\n");
        stringBuilder.append("ID: ").append(getNumber()).append("\n");
        stringBuilder.append("Number of beds: ").append(getNumberOfBeds()).append("\n");
        stringBuilder.append("Note: ").append(getNote()).append("\n");
        stringBuilder.append("Number of guests: ").append(getNumberOfGuests()).append("\n");
        //stringBuilder.append("Guest list: ").append(getGuestList()).append("\n");

        return String.valueOf(stringBuilder);
    }
}