package soap.lavasoft;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.ws.Service;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;

public class GeoIpServiceClient {

    public static String getValueFromXml(String xmlString, String tagName){
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
            NodeList tagNodes = doc.getElementsByTagName(tagName);
            if (tagNodes.getLength() > 0) {
                Element tagElement = (Element) tagNodes.item(0);
                return tagElement.getTextContent();
            } else { return null; }
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        try {
            URL url = new URL("http://wsgeoip.lavasoft.com/ipservice.asmx?WSDL");
            QName qname = new QName("http://lavasoft.com/", "GeoIPService");
            // Utworzenie serwisu
            Service service = Service.create(url, qname);
            // Pobranie portu serwisu
            GeoIPServiceSoap geoIPServiceSoap = service.getPort(GeoIPServiceSoap.class);
            // Wysłanie zapytania o lokalizację na podstawie adresu IP
            String result = geoIPServiceSoap.getLocation();
            System.out.println("Wynik getLocation(): " + result);
            // Wyświetlenie wyniku
            String ipAddress = "109.231.61.2";
            System.out.println("Lokalizacja dla adresu IP " + ipAddress + ":");
            String result2 = geoIPServiceSoap.getIpLocation(ipAddress);
            System.out.println("Wynik getIpLocation(ipAddress): " + result2);

            String countryId = getValueFromXml(result, "Country");
            System.out.println("Identyfikator kraju: " + countryId);

            String countryNameXml = geoIPServiceSoap.getCountryNameByISO2(countryId);
            System.out.println("Wynik getCountryNameByISO2(countryId): " + countryNameXml);
            String countryName = getValueFromXml(countryNameXml, "Country");
            System.out.println("Nazwa kraju: " + countryName);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
