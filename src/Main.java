import guest.Guest;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        String firstName = scanner.nextLine();
//        String secondName = scanner.nextLine();
//        String lastName = scanner.nextLine();
//        String uniqueIdentificationNumber = scanner.nextLine();
//        String phoneNumber = scanner.nextLine();

        Guest guest = new Guest.Builder("Test1","Test1","Test1","Test1","Test1").build();
        XMLParser xmlParser = new XMLParser();

    }
}
// ideq: da si napravq klasa guest s factory i da ima razlichen tip guests - pensioneer, child, businessman and more. A room da bude s builder?

// Dates
//    public static void main(String[] args) {
//        Application.execute();
//
//        LocalDate data = LocalDate.parse(scanner.nextLine()); // Storevame ot string v localdate
//        Scanner scanner = new Scanner(System.in); // get user input
//
//        LocalDate today = LocalDate.now(); // shows the day today
//
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
//
//        // Pokazva dneshnata data
//        String textToday = today.format(dateTimeFormatter);
//        //System.out.println(textToday);
//
//        // Get user input
//        int myMonth = scanner.nextInt();
//        int myDay = scanner.nextInt();
//        int myYear = scanner.nextInt(); // If we don't are what year they were born: today.GetYear();
//
//        int thisMonth = today.getMonthValue(); // gets this month
//
//        LocalDate birthday = LocalDate.of(myYear, myMonth,myDay); // assigns info to when it's someones birthday
//
//        if(birthday.isBefore(today))
//        {
//            birthday = birthday.plusYears(1);
//        }
//
//        String nextBirthday = birthday.format(dateTimeFormatter); // calculate days until next bday
//
//        long daysToBirthday = today.until(birthday, ChronoUnit.DAYS);
//
//        if(myMonth == thisMonth && myDay == today.getMonthValue())
//        {
//            System.out.println("Happy b day!");
//        }
//        else
//        {
//            System.out.println("Your next bday is " + nextBirthday);
//            System.out.println("There are " + daysToBirthday + " days until your next bday!");
//        }
//    }

        //////////////////////////////////////////////
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//
//        try
//        {
//            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
//            Document doc = documentBuilder.parse("guests.xml");
//        }
//        catch (ParserConfigurationException e)
//        {
//            throw new RuntimeException(e);
//        }
//        catch (IOException e)
//        {
//            throw new RuntimeException(e);
//        }
//        catch (SAXException e)
//        {
//            throw new RuntimeException(e);
//        }
