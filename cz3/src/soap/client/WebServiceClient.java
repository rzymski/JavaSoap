package soap.client;

import soap.wizard.wsdl.classes.Server;
import soap.wizard.wsdl.classes.ServerImplService;

public class WebServiceClient {
    public static void main(String[] args) {
        ServerImplService serverService = new ServerImplService();
        Server server = serverService.getServerImplPort();

        System.out.println("Nazwa serwera = " + server.getServerName());

        String zapytanie = "Ala ma kota";
        String response = server.getReverseMessage(zapytanie);
        System.out.println("Klient wysłał: " + zapytanie);
        System.out.println("Klient otrzymał: " + response);
    }
}
