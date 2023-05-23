package models;

public class Guest {
    private String firstName;
    private String secondName;
    private String lastName;
    private String uniqueIdentificationNumber; // ЕГН

    public Guest(String firstName, String secondName, String lastName, String uniqueIdentificationNumber) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.uniqueIdentificationNumber = uniqueIdentificationNumber;
    }

    @Override
    public String toString() {
       StringBuilder stringBuilder = new StringBuilder();

       stringBuilder.append("First name: ")                 .append(this.firstName)                      .append("\n");
       stringBuilder.append("Second name: ")                .append(this.secondName)                     .append("\n");
       stringBuilder.append("Last name: ")                  .append(this.lastName)                       .append("\n");
       stringBuilder.append("Identification number: ")      .append(this.uniqueIdentificationNumber)     .append("\n");

       return String.valueOf(stringBuilder);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Guest guest = (Guest) o;

        return uniqueIdentificationNumber.equals(guest.uniqueIdentificationNumber);
    }

    @Override
    public int hashCode() {
        return uniqueIdentificationNumber.hashCode();
    }

    public String getFirstName() {
        return firstName;
    }
    public String getSecondName() {
        return secondName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getUniqueIdentificationNumber() {
        return uniqueIdentificationNumber;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setUniqueIdentificationNumber(String uniqueIdentificationNumber) {
        this.uniqueIdentificationNumber = uniqueIdentificationNumber;
    }
}