import cli.enums.DefaultCommands;
import cli.factories.DefaultCommandFactory;
import exceptions.commands.InvalidCommandException;
import models.hotel.commands.enums.HotelCommands;
import models.hotel.commands.factories.HotelCommandsFactory;
import models.services.HotelService;
import utils.parsers.xml.JAXBParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        JAXBParser jaxbParser = new JAXBParser();
        HotelService hotelService = new HotelService(jaxbParser);
        DefaultCommandFactory commandFactory = new DefaultCommandFactory(hotelService);
        HotelCommandsFactory hotelCommandsFactory = new HotelCommandsFactory(hotelService);
        // create an engine

        String input;
        List<String> arguments;
        Enum<?> command;

        while (true) {
            System.out.print(">");
            input = scanner.nextLine().toLowerCase();

            arguments = new ArrayList<>(List.of(input.split("\\s+(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)")));

            try {
                command = commandParsingMethod(arguments.get(0));

                if (command instanceof DefaultCommands) {
                    commandFactory.createCommand((DefaultCommands) command, arguments.subList(1, arguments.size())).execute();
                } else if (command instanceof HotelCommands) {
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
