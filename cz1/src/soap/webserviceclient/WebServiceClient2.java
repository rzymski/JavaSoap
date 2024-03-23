package soap.webserviceclient;

import soap.HelloWorld;
import soap.HelloWorldImplService;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import java.net.URL;

public class WebServiceClient2 {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:8080/ws/hello?wsdl");
        QName qname = new QName("http://soap/", "HelloWorldImplService");

        Service service = Service.create(url, qname);
        HelloWorld hello = service.getPort(HelloWorld.class);

        String zapytanie = "To ja - KLIENT2";
        String response = hello.getHelloWorldAsString(zapytanie);
        System.out.println("Klient wysłał: " + zapytanie);
        System.out.println("Klient otrzymał: " + response);


        String endpointURL = "http://127.0.0.1:9999/ws/hello?wsdl";
        BindingProvider bp = (BindingProvider)hello;
        String address = (String) bp.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY);
        address = address.replaceFirst("8080", "9999");
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, address);
        System.out.println("Server said: " + hello.getHelloWorldAsString("Czesc"));
    }
}
