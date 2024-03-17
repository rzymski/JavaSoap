package soap.webserviceclient;

import soap.HelloWorld;
import soap.HelloWorldImplService;

public class WebServiceClient {
    public static void main(String[] args) {
        HelloWorldImplService helloService = new HelloWorldImplService();
        HelloWorld hello = helloService.getHelloWorldImplPort();

        String zapytanie = "To ja - KLIENT";
        String response = hello.getHelloWorldAsString(zapytanie);
        System.out.println("Klient wysłał: " + zapytanie);
        System.out.println("Klient otrzymał: " + response);
    }
}
