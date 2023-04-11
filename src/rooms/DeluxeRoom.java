package rooms;

public class DeluxeRoom extends Room // za 3ma
{
    //region Members of the class
    //endregion

    //region Constructor of the class
    public DeluxeRoom(int numberOfBeds)
    {
        super(numberOfBeds);
    }
    //endregion

    //region Methods of the class
    //endregion

    //region Overrides
    @Override
    public String createRoom()
    {
        return this.toString();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("This is a Deluxe Room").append("\n");
        stringBuilder.append("ID: ").append(getNumber()).append("\n");
        stringBuilder.append("Number of beds: ").append(getNumberOfBeds()).append("\n");
        stringBuilder.append("Note: ").append(getNote()).append("\n");
        stringBuilder.append("Number of guests: ").append(getNumberOfGuests()).append("\n");
        stringBuilder.append("Guest list: ").append(getGuestList()).append("\n");

        return String.valueOf(stringBuilder);
    }
    //endregion

    //region Accessors and Mutators of the class
    //endregion
}