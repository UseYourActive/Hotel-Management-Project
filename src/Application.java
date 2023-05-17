import commandlineinterface.factories.DefaultCommandFactory;
import commandlineinterface.enums.DefaultCommands;
import utils.services.HotelService;
import models.Hotel;
import models.hotelcommands.enums.HotelCommands;
import models.hotelcommands.factories.HotelCommandsFactory;
import utils.errorlogger.ErrorLogWriter;
import exceptions.commands.InvalidCommandException;
import utils.parsers.xml.JAXBParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void run(){
        Scanner scanner = new Scanner(System.in);
        ErrorLogWriter errorLogWriter = new ErrorLogWriter();
        JAXBParser jaxbParser = new JAXBParser();
        Hotel hotel = Hotel.getInstance(errorLogWriter);
        HotelService hotelService = new HotelService(errorLogWriter, jaxbParser);
        DefaultCommandFactory commandFactory = new DefaultCommandFactory(hotelService, errorLogWriter);
        HotelCommandsFactory hotelCommandsFactory = new HotelCommandsFactory(hotelService, errorLogWriter);

        String input;
        List<String> arguments;
        Enum<?> command;

        while(true){
            input = scanner.nextLine().toLowerCase();
            arguments = new ArrayList<>(List.of(input.split(" ")));
            try {
                command = commandParsingMethod(arguments.get(0));
                if(command instanceof DefaultCommands){
                    commandFactory.createCommand((DefaultCommands) command, arguments.subList(1, arguments.size())).execute();
                }else if(command instanceof HotelCommands){
                    hotelCommandsFactory.createCommand((HotelCommands) command, arguments.subList(1, arguments.size())).execute();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Enum<?> commandParsingMethod(String command) throws InvalidCommandException {
        for(DefaultCommands value : DefaultCommands.values()) {
            if (value.getCommand().equals(command)) {
                return DefaultCommands.valueOf(command.toUpperCase());
            }
        }

        for(HotelCommands value : HotelCommands.values()) {
            if (value.getChoice().equals(command)) {
                return HotelCommands.valueOf(command.toUpperCase());
            }
        }

        throw new InvalidCommandException(command + " is not recognized as an internal command!");
    }
}
