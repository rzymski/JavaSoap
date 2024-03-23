package soap.webserviceclient;

import soap.webserviceclient.GeoIPServiceSoap;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class GeoIpServiceClient {
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
            // Wyświetlenie wyniku
            String ipAddress = "109.231.61.2";
            System.out.println("Lokalizacja dla adresu IP " + ipAddress + ":");
            System.out.println("Wynik getLocation() " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
