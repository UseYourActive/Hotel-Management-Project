import commandlineinterface.*;
import errorlogger.ErrorLogWriter;
import errorlogger.ErrorWritable;

import java.util.Scanner;

public class TestvamCLI
{
    private static String currentFileName = "";
    private static boolean isFileOpen = false;

    public static void main(String[] args)
    {
        ErrorWritable errorLogWriter = new ErrorLogWriter();

        Command save = Save.getInstance();
        Command open = Open.getInstance();
        Command close = Close.getInstance();
        Help help = Help.getInstance();
        Command exit = Exit.getInstance();
        Command saveAs = SaveAs.getInstance();

        //CommandService commandService = new CommandService(open, close, save, saveAs, help, exit);

        Scanner scanner = new Scanner(System.in);
        String command;
        do {
            System.out.print("> ");

            command = scanner.nextLine();

            String[] commandParts = command.split("\\s+");

            if (commandParts[0].equalsIgnoreCase("open"))
            {
                if (commandParts.length != 2)
                {
                    System.out.println("Usage: open <filename>");
                    continue;
                }
                openFile(commandParts[1]);
            }

            else if (commandParts[0].equalsIgnoreCase("close"))
            {
                closeFile();
            }

            else if (commandParts[0].equalsIgnoreCase("save"))
            {
                saveFile(currentFileName);
            }

            else if (commandParts[0].equalsIgnoreCase("save as"))
            {
                if (commandParts.length != 2)
                {
                    System.out.println("Usage: save as <filename>");
                    continue;
                }
                saveFile(commandParts[1]);
            }

            else if (commandParts[0].equalsIgnoreCase("help"))
            {
                help.execute();
            }

            else if (!commandParts[0].equalsIgnoreCase("exit"))
            {
                System.out.println("Unknown command. Type 'help' for a list of commands.");
            }
        }
        while (!command.equalsIgnoreCase("exit"));
        scanner.close();
    }

    private static void openFile(String fileName)
    {
        if (isFileOpen)
        {
            System.out.println("A file is already open. Close it first.");
            return;
        }
        currentFileName = fileName;
        System.out.println("Opened file " + currentFileName);
        isFileOpen = true;
    }

    private static void closeFile() {
        if (!isFileOpen) {
            System.out.println("No file is currently open.");
            return;
        }
        System.out.println("Closed file " + currentFileName);
        currentFileName = "";
        isFileOpen = false;
    }

    private static void saveFile(String fileName)
    {
        if (!isFileOpen)
        {
            System.out.println("No file is currently open.");
            return;
        }
        System.out.println("Saved file as " + fileName);
        currentFileName = fileName;
    }

    private static void printHelp() {
        System.out.println("Available commands:");
        System.out.println("open <filename> - Open a file");
        System.out.println("close - Close the current file");
        System.out.println("save - Save the current file");
        System.out.println("save as <filename> - Save the current file with a new name");
        System.out.println("help - Display this help message");
        System.out.println("exit - Exit the program");
    }
}