import commandlineinterface.*;
import errorlogger.ErrorLogWriter;
import errorlogger.ErrorWritable;
import models.hotel.Hotel;
import models.hotel.HotelService;
import models.reservation.Reservation;
import xmlparsers.JAXBParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().toLowerCase();
        List<String> arguments = new ArrayList<>(List.of(input.split(" ")));

        ErrorWritable errorLogWriter = new ErrorLogWriter();
        Hotel hotel = Hotel.getInstance();
        HotelService hotelService = new HotelService(hotel, arguments.subList(1, arguments.size()));
        JAXBParser jaxbParser = new JAXBParser(hotel);
        Reservation reservation = new Reservation();

        CommandFactory commandFactory = new CommandFactory(jaxbParser, errorLogWriter);
        commandFactory.createCommand(DefaultCommands.SAVE, arguments);
        commandFactory.createCommand(DefaultCommands.OPEN, arguments);
        commandFactory.createCommand(DefaultCommands.CLOSE, arguments);
        commandFactory.createCommand(DefaultCommands.HELP, arguments);
        commandFactory.createCommand(DefaultCommands.EXIT, arguments);
        commandFactory.createCommand(DefaultCommands.SAVE_AS, arguments);

        switch (arguments.get(0)){
            case "checkin":
                hotelService.checkIn();
                break;
            case "availability":
                hotelService.availability();
                break;
            case "checkout":
                hotelService.checkOut();
                break;
            case "report":
                hotelService.report();
                break;
            case "find":
                hotelService.find();
                break;
            case "findimportant":
                hotelService.findImportant();
                break;
            case "unavailable":
                hotelService.unavailable();
                break;
            default:
                break;
        }
    }
}