package rooms;

public class SingleRoom extends Room // za 1
{
    /* Members of the class. */
    /*----------------------------------------------------------------------*/

    /* Constructor of the class. */
    public SingleRoom(int numberOfBeds)
    {
        super(numberOfBeds);
    }
    /*----------------------------------------------------------------------*/

    /* Methods of the class. */
    /*----------------------------------------------------------------------*/

    /* Overrides. */
    @Override
    public SingleRoom createRoom()
    {
        return this;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("This is a Single Room").append("\n");
        stringBuilder.append("ID: ").append(getNumber()).append("\n");
        stringBuilder.append("Number of beds: ").append(getNumberOfBeds()).append("\n");
        stringBuilder.append("Note: ").append(getNote()).append("\n");
        stringBuilder.append("Number of guests: ").append(getNumberOfGuests()).append("\n");
        stringBuilder.append("Guest list: ").append(getGuestList()).append("\n");

        return String.valueOf(stringBuilder);
    }
    /*----------------------------------------------------------------------*/

    /* Accessors and Mutators of the class. */
    /*----------------------------------------------------------------------*/
}