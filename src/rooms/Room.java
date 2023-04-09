package rooms;

import exceptions.GuestAlreadyInRoomException;
import guest.Guest;

import java.util.ArrayList;
import java.util.List;

public abstract class Room implements RoomCreator
{
    /* Members of the class. */
    private final long number;
    private static long roomCounter;
    private int numberOfBeds;
    private int numberOfGuests; // Не е задължителен параметър -> трябва функция
    private String note;
    private boolean isAvailable;
    private List<Guest> guestList;
    /*----------------------------------------------------------------------*/

    /* Constructor of the class. */
    public Room(int numberOfBeds)
    {
        roomCounter++;
        number = roomCounter;
        this.numberOfBeds = numberOfBeds;
        this.numberOfGuests = 0;
        this.isAvailable = true;
        guestList = new ArrayList<>();
    }
    /*----------------------------------------------------------------------*/

    /* Methods of the class. */
    public void addGuest(Guest guest) throws GuestAlreadyInRoomException
    {
        if(guestList.contains(guest))
        {
            throw new GuestAlreadyInRoomException("This guest is already assigned in a room!", new RuntimeException());
        }
        else
        {
            guestList.add(guest);
            this.numberOfGuests++;
        }
    }
    /*----------------------------------------------------------------------*/

    /* Overrides. */
    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Number of room: ")            .append(this.number)                .append("\n");

        if(!(this.numberOfBeds <= 0))
        {
            stringBuilder.append("Number of beds: ")        .append(this.numberOfBeds)          .append("\n");
        }

        if(!(this.numberOfGuests <= 0))
        {
            stringBuilder.append("Number of guests: ")      .append(this.numberOfGuests)        .append("\n");
        }

        if((this.note != null) && !(this.note.isEmpty()))
        {
            stringBuilder.append("Note: ")                  .append(this.note)                  .append("\n");
        }

        stringBuilder.append("Is available: ")              .append(this.isAvailable)           .append("\n");

        return String.valueOf(stringBuilder);
    }
    /*----------------------------------------------------------------------*/

    /* Accessors and Mutators of the class. */
    public long getNumber()
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

    public List<Guest> getGuestList()
    {
        return guestList;
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