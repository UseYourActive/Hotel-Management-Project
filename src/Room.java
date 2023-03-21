import java.util.HashSet;
import java.util.Set;

public class Room
{
    /* Members of the class. */
    private final int number;
    private int numberOfBeds;
    private int numberOfGuests; // Не е задължителен параметър -> трябва функция
    private String note;
    private boolean isAvailable;
    private Set<Guest> guestList = new HashSet<>();
    private WriteError errorlog;
    /*----------------------------------------------------------------------*/

    /* Constructor of the class. */
    public Room(int number, int numberOfBeds, WriteError errorlog)
    {
        this.number = number;
        this.numberOfBeds = numberOfBeds;
        this.errorlog = errorlog;
        this.numberOfGuests = 0;
        this.isAvailable = true;
    }
    /*----------------------------------------------------------------------*/

    /* Methods of the class. */
    public void addGuest(Guest guest) {
        if(guestList.contains(guest))
        {
            try {
                throw new GuestAlreadyInRoomException("This guest is already in assigned in the room!", new RuntimeException());
            } catch (GuestAlreadyInRoomException e) {
                errorlog.writeToErrorLog(e);
            }
        }
        else
        {
            guestList.add(guest);
        }
    }
    /*----------------------------------------------------------------------*/

    /* Overrides. */
    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();

        if(!(this.number <= 0))
        {
            stringBuilder.append("Number of room: ")        .append(this.number)                .append("\n");
        }

        if(!(this.numberOfBeds <= 0))
        {
            stringBuilder.append("Number of beds: ")        .append(this.numberOfBeds)          .append("\n");
        }

        if(!(this.numberOfGuests <= 0))
        {
            stringBuilder.append("Number of guests: ")      .append(this.numberOfGuests)        .append("\n");
        }

        if(this.note != null && !this.note.isEmpty())
        {
            stringBuilder.append("Note: ")                  .append(this.note)                  .append("\n");
        }

        stringBuilder.append("Is available: ")              .append(this.isAvailable)           .append("\n");

        return String.valueOf(stringBuilder);
    }
    /*----------------------------------------------------------------------*/

    /* Accessors and Mutators of the class. */
    public int getNumber()
    {
        return number;
    }

    public int getNumberOfBeds()
    {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds)
    {
        this.numberOfBeds = numberOfBeds;
    }

    public int getNumberOfGuests()
    {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests)
    {
        this.numberOfGuests = numberOfGuests;
    }

    public String getNote()
    {
        return note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }

    public boolean isAvailable()
    {
        return isAvailable;
    }

    public void setAvailable(boolean available)
    {
        isAvailable = available;
    }
    /*----------------------------------------------------------------------*/
}