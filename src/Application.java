import cli.contracts.DefaultCommand;
import cli.enums.DefaultCommands;
import cli.factories.DefaultCommandFactory;
import exceptions.commands.InvalidCommandException;
import models.hotel.commands.contracts.HotelCommand;
import models.hotel.commands.enums.HotelCommands;
import models.hotel.commands.factories.HotelCommandsFactory;
import models.services.HotelService;
import utils.parsers.xml.JAXBParser;

import java.util.*;

public class Application {
    private static final Map<DefaultCommands, DefaultCommandFactory> defaultCommandFactoryMap;
    private static final Map<HotelCommands, HotelCommandsFactory> hotelCommandsFactoryMap;

    static {
        JAXBParser jaxbParser = new JAXBParser();
        HotelService hotelService = new HotelService(jaxbParser);

        defaultCommandFactoryMap = new EnumMap<>(DefaultCommands.class);
        hotelCommandsFactoryMap = new EnumMap<>(HotelCommands.class);

        defaultCommandFactoryMap.put(DefaultCommands.OPEN, new DefaultCommandFactory(hotelService));
        defaultCommandFactoryMap.put(DefaultCommands.CLOSE, new DefaultCommandFactory(hotelService));
        defaultCommandFactoryMap.put(DefaultCommands.SAVE, new DefaultCommandFactory(hotelService));
        defaultCommandFactoryMap.put(DefaultCommands.SAVEAS, new DefaultCommandFactory(hotelService));
        defaultCommandFactoryMap.put(DefaultCommands.HELP, new DefaultCommandFactory(hotelService));
        defaultCommandFactoryMap.put(DefaultCommands.EXIT, new DefaultCommandFactory(hotelService));

        hotelCommandsFactoryMap.put(HotelCommands.CHECKIN, new HotelCommandsFactory(hotelService));
        hotelCommandsFactoryMap.put(HotelCommands.AVAILABILITY, new HotelCommandsFactory(hotelService));
        hotelCommandsFactoryMap.put(HotelCommands.CHECKOUT, new HotelCommandsFactory(hotelService));
        hotelCommandsFactoryMap.put(HotelCommands.REPORT, new HotelCommandsFactory(hotelService));
        hotelCommandsFactoryMap.put(HotelCommands.FIND, new HotelCommandsFactory(hotelService));
        hotelCommandsFactoryMap.put(HotelCommands.FINDIMPORTANT, new HotelCommandsFactory(hotelService));
        hotelCommandsFactoryMap.put(HotelCommands.UNAVAILABLE, new HotelCommandsFactory(hotelService));
    }

    public static void runEngine() {
        Scanner scanner = new Scanner(System.in);

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
                    DefaultCommandFactory defaultCommandFactory = defaultCommandFactoryMap.get(command);
                    DefaultCommand defaultCommand = defaultCommandFactory.createCommand((DefaultCommands) command, arguments.subList(1, arguments.size()));
                    defaultCommand.execute();
                } else if (command instanceof HotelCommands) {
                    HotelCommandsFactory hotelCommandsFactory = hotelCommandsFactoryMap.get(command);
                    HotelCommand hotelCommand = hotelCommandsFactory.createCommand((HotelCommands) command, arguments.subList(1, arguments.size()));
                    hotelCommand.execute();
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