public class Guest
{
    /* Members of the class. */
    private String firstName;
    private String secondName;
    private String lastName;
    private String identificationNumber; // ЕГН
    private String phoneNumber;
    private String email;
    private String gender;
    /*----------------------------------------------------------------------*/

    /* Builder of the class. */
    public static class Builder
    {
        private final String firstName;
        private String secondName;
        private final String lastName;
        private final String identificationNumber;
        private String phoneNumber;
        private String email;
        private String gender;

        public Builder(String firstName, String lastName, String identificationNumber)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.identificationNumber = identificationNumber;
        }

        public Builder withSecondName(String secondName)
        {
            this.secondName = secondName;
            return this;
        }

        public Builder withPhoneNumber(String phoneNumber)
        {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder withEmail(String email)
        {
            this.email = email;
            return this;
        }

        public Builder withGender(String gender)
        {
            this.gender = gender;
            return this;
        }

        public Guest build()
        {
            return new Guest(firstName, secondName, lastName, identificationNumber, phoneNumber, email, gender);
        }
    }
    /*----------------------------------------------------------------------*/

    /* Constructor of the class. */
    private Guest(String firstName, String secondName, String lastName, String identificationNumber, String phoneNumber, String email, String gender)
    {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.identificationNumber = identificationNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
    }
    /*----------------------------------------------------------------------*/

    /* Methods of the class. */

    /*----------------------------------------------------------------------*/

    /* Overrides. */
    @Override
    public String toString()
    {
       StringBuilder stringBuilder = new StringBuilder();

       if(this.firstName != null && !this.firstName.isEmpty())
       {
           stringBuilder.append("First name: ")                 .append(this.firstName)             .append("\n");
       }
       if(this.secondName != null && !this.secondName.isEmpty())
       {
           stringBuilder.append("Second name: ")                .append(this.secondName)            .append("\n");
       }
       if(this.lastName != null && !this.lastName.isEmpty())
       {
           stringBuilder.append("Last name: ")                  .append(this.lastName)              .append("\n");
       }
       if(this.identificationNumber != null && !this.identificationNumber.isEmpty())
       {
           stringBuilder.append("Identification number: ")      .append(this.identificationNumber)  .append("\n");
       }
       if(this.phoneNumber != null && !this.phoneNumber.isEmpty())
       {
           stringBuilder.append("Phone number: ")               .append(this.phoneNumber)           .append("\n");
       }
       if(this.email != null && !this.email.isEmpty())
       {
           stringBuilder.append("Email: ")                      .append(this.email)                 .append("\n");
       }
       if(this.gender != null && !this.gender.isEmpty())
       {
           stringBuilder.append("Gender: ")                     .append(this.gender)                .append("\n");
       }

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
    public String getIdentificationNumber()
    {
        return identificationNumber;
    }
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    public String getEmail()
    {
        return email;
    }
    public String getGender()
    {
        return gender;
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
    public void setIdentificationNumber(String identificationNumber)
    {
        this.identificationNumber = identificationNumber;
    }
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public void setGender(String gender)
    {
        this.gender = gender;
    }
    /*----------------------------------------------------------------------*/
}