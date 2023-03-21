import errorlogger.ErrorLogWriter;
import errorlogger.ErrorWritable;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        // Error logger-a ne suzdava fail - mamka mu

        ErrorWritable errorLogWriter = new ErrorLogWriter();
        RoomFactory factory = new RoomFactory();
        try
        {
            factory.createNotification(RoomTypes.SINGLE_ROOM);
        }
        catch (InvalidRoomSelectionException e)
        {
            errorLogWriter.writeToErrorLog(e);
        }
    }
}
// ideq: da si napravq klasa guest s factory i da ima razlichen tip guests - pensioneer, child, businessman and more. A room da bude s builder?

// Dates
//    public static void main(String[] args) {
//        Application.execute();
//
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
//            Document doc = documentBuilder.parse("neshto.xml");
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
