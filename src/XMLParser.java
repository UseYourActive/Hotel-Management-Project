import guest.Guest;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class XMLParser
{
    /* Members of the class. */
    private final static String XML_GUESTS_FILE_PATHWAY = String.valueOf(Paths.get("guests.xml"));
    private final static String XML_ROOMS_FILE_PATHWAY = String.valueOf(Paths.get("rooms.xml"));
    /*----------------------------------------------------------------------*/

    /* Constructor of the class. */
    /*----------------------------------------------------------------------*/

    /* Methods of the class. */
    public void writeXML()
    {

    }

    public void defaultSettings(File file) throws IOException
    {
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        fileWriter.close();
    }

    public List<Guest> readXML() throws ParserConfigurationException, IOException, SAXException
    {
        List<Guest> guestList = new ArrayList<>();
        File filePathway = new File(XML_GUESTS_FILE_PATHWAY);

        if (!filePathway.exists())
        {
            System.err.println("File not found: " + filePathway.getAbsolutePath());
            throw new FileNotFoundException();
        }

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(filePathway);

        document.getDocumentElement().normalize();

        Element root = document.getDocumentElement();

        NodeList nodeList = root.getElementsByTagName("guest");

        for (int i = 0; i < nodeList.getLength(); i++)
        {
            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE)
            {
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

    public List<Guest> sysOutXMl() throws ParserConfigurationException, IOException, SAXException // da priema kato parametur guest i da moje da go dobavi kym xml-a
    {
        List<Guest> guestList = new ArrayList<>();
        File filePathway = new File(XML_GUESTS_FILE_PATHWAY);

        if (!filePathway.exists())
        {
            System.err.println("File not found: " + filePathway.getAbsolutePath());
            System.err.println("Will be created upon next start.");
            throw new FileNotFoundException();
        }

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(filePathway);

        document.getDocumentElement().normalize();

        Element root = document.getDocumentElement();

        NodeList nodeList = root.getElementsByTagName("guest");

        for (int temp = 0; temp < nodeList.getLength(); temp++) {
            Node nNode = nodeList.item(temp);

            if (nNode.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) nNode;
                System.out.println("id : " + eElement.getAttribute("id"));
                System.out.println("firstName : " + eElement.getElementsByTagName("firstName").item(0).getTextContent());
                System.out.println("secondName : " + eElement.getElementsByTagName("secondName").item(0).getTextContent());
                System.out.println("lastName : " + eElement.getElementsByTagName("lastName").item(0).getTextContent());
                System.out.println("uniqueIdentificationNumber : " + eElement.getElementsByTagName("uniqueIdentificationNumber").item(0).getTextContent());
                System.out.println("phoneNumber : " + eElement.getElementsByTagName("phoneNumber").item(0).getTextContent());
            }
        }
        return guestList;
    }

    public void writeToXML(Guest guest) throws ParserConfigurationException, IOException, SAXException, TransformerException // da priema kato parametur guest i da moje da go dobavi kym xml-a
    {
        
    }
    /*----------------------------------------------------------------------*/

    /* Overrides. */
    /*----------------------------------------------------------------------*/

    /* Accessors and Mutators of the class. */
    /*----------------------------------------------------------------------*/
}