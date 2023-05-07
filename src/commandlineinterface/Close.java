package commandlineinterface;

import xmlparsers.JAXBParser;

public class Close implements Command {
    private JAXBParser jaxbParser;
    private static Close instance;

    private Close(JAXBParser jaxbParser){
        this.jaxbParser = jaxbParser;
    }

    public static Close getInstance(JAXBParser jaxbParser) {
        if(instance == null) {
            instance = new Close(jaxbParser);
            return instance;
        }
        return instance;
    }

    @Override
    public void execute() {
        if(jaxbParser.getHotel() != null && jaxbParser.getFile().exists()){
            jaxbParser.setHotel(null);
            jaxbParser.setFile(null);
            System.out.println("File has been successfully closed: "+ jaxbParser.getFile().getAbsolutePath());
        }
    }
}