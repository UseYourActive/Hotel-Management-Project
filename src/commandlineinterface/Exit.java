package commandlineinterface;

import xmlparsers.JAXBParser;

public class Exit implements Command {
    private JAXBParser jaxbParser;
    private static Exit instance;

    private Exit(JAXBParser jaxbParser){
        this.jaxbParser = jaxbParser;
    }

    public static Exit getInstance(JAXBParser jaxbParser) {
        if(instance == null) {
            instance = new Exit(jaxbParser);
            return instance;
        }
        return instance;
    }

    public void execute(){
        jaxbParser.setHotel(null);
        jaxbParser.setFile(null);
        jaxbParser = null;
        System.out.println("Exiting program...");
        System.exit(0);
    }
}