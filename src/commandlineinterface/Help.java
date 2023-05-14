package commandlineinterface;

import commandlineinterface.contractors.DefaultCommand;

public class Help implements DefaultCommand {
    private static Help instance;

    private Help(){}

    public static Help getInstance() {
        if(instance == null) {
            instance = new Help();
            return instance;
        }
        return instance;
    }

    public void execute() {
        System.out.println("""
                The following default commands are supported:
                open <file>                                     opens <file>.
                close                                           closes currently opened file.
                save                                            saves the currently open file.
                saveas <file>                                   saves the currently open file in <file>.
                help                                            prints this information.
                exit                                            exits the program.
                checkin <room> <from> <to> <note> [<guests>]    check-in a <room> with dates <from> <to> and add a <note>.
                availability <date>                             check room availability on <date>.
                checkout <room>                                 checkout of <room>.
                report <from> <to>                              check all rooms availability <from> date <to> date.
                find <beds> <from> <to>                         find number of <beds> on dates <from> <to>.
                findimportant <beds> <from> <to>                find and move reservations for important guests with number of <beds> on dates <from> <to>.
                unavailable <room> <from> <to> <note>           mark a room as unavailable <room> <from> <to> <note>.
                """);
    }
}