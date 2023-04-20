import guest.Guest;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class XMLParser {
    private final static String XML_GUESTS_FILE_PATHWAY = String.valueOf(Paths.get("guests.xml"));
    private final static String XML_ROOMS_FILE_PATHWAY = String.valueOf(Paths.get("rooms.xml"));

    public void defaultSettings(File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        fileWriter.close();
    }

    public List<Guest> readXML() throws ParserConfigurationException, IOException, SAXException {
        List<Guest> guestList = new ArrayList<>();
        File filePathway = new File(XML_GUESTS_FILE_PATHWAY);

        if (!filePathway.exists()) {
            System.err.println("File not found: " + filePathway.getAbsolutePath());
            throw new FileNotFoundException();
        }

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(filePathway);

        document.getDocumentElement().normalize();

        Element root = document.getDocumentElement();

        NodeList nodeList = root.getElementsByTagName("guest");

        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element guest = (Element) nodeList.item(i);

                long id = Long.parseLong(guest.getAttribute("id"));
                String firstName = guest.getElementsByTagName("firstName").item(0).getTextContent();
                String secondName = guest.getElementsByTagName("secondName").item(0).getTextContent();
                String lastName = guest.getElementsByTagName("lastName").item(0).getTextContent();
                String uniqueIdentificationNumber = guest.getElementsByTagName("uniqueIdentificationNumber").item(0).getTextContent();
                String phoneNumber = guest.getElementsByTagName("phoneNumber").item(0).getTextContent();

                Guest guest1 = new Guest.Builder(firstName, secondName, lastName, uniqueIdentificationNumber, phoneNumber)
                        .withID(id)
                        .build();

                guestList.add(guest1);
            }
        }
        return guestList;
    }
}