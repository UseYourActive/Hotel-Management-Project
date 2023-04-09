package guest;

public class Guest
{
    /* Members of the class. */
    private final long id;
    private static long guestCounter;
    private String firstName;
    private String secondName;
    private String lastName;
    private String uniqueIdentificationNumber; // ЕГН
    private String phoneNumber;
    /*----------------------------------------------------------------------*/

    /* Builder of the class. */
    public static class Builder
    {
        private long id;
        private static long guestCounter;
        private final String firstName;
        private final String secondName;
        private final String lastName;
        private final String uniqueIdentificationNumber; // ЕГН
        private final String phoneNumber;

        public Builder(String firstName, String secondName, String lastName, String uniqueIdentificationNumber, String phoneNumber)
        {
            this.firstName = firstName;
            this.secondName = secondName;
            this.lastName = lastName;
            this.uniqueIdentificationNumber = uniqueIdentificationNumber;
            this.phoneNumber = phoneNumber;
            guestCounter++;
            this.id = guestCounter;
        }

        public Builder withID(long id)
        {
            this.id = id;
            return this;
        }
        public Guest build()
        {
            return new Guest(firstName,secondName,lastName,uniqueIdentificationNumber,phoneNumber);
        }
    }
    /*----------------------------------------------------------------------*/

    /* Constructor of the class. */
    private Guest(String firstName, String secondName, String lastName, String uniqueIdentificationNumber, String phoneNumber)
    {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.uniqueIdentificationNumber = uniqueIdentificationNumber;
        this.phoneNumber = phoneNumber;
        guestCounter++;
        this.id = guestCounter;
    }
    /*----------------------------------------------------------------------*/

    /* Methods of the class. */
    /*----------------------------------------------------------------------*/

    /* Overrides. */
    @Override
    public String toString()
    {
       StringBuilder stringBuilder = new StringBuilder();

       stringBuilder.append("ID: ")                         .append(this.id)                             .append("\n");
       stringBuilder.append("First name: ")                 .append(this.firstName)                      .append("\n");
       stringBuilder.append("Second name: ")                .append(this.secondName)                     .append("\n");
       stringBuilder.append("Last name: ")                  .append(this.lastName)                       .append("\n");
       stringBuilder.append("Identification number: ")      .append(this.uniqueIdentificationNumber)     .append("\n");
       stringBuilder.append("Phone number: ")               .append(this.phoneNumber)                    .append("\n");

       return String.valueOf(stringBuilder);
    }
    /*----------------------------------------------------------------------*/

    /* Accessors and Mutators of the class. */
    public String getFirstName()
    {
        return firstName;
    }
    public String getSecondName()
    {
        return secondName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public String getUniqueIdentificationNumber()
    {
        return uniqueIdentificationNumber;
    }
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    public long getId()
    {
        return id;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public void setSecondName(String secondName)
    {
        this.secondName = secondName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    public void setUniqueIdentificationNumber(String uniqueIdentificationNumber)
    {
        this.uniqueIdentificationNumber = uniqueIdentificationNumber;
    }
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    /*----------------------------------------------------------------------*/
}