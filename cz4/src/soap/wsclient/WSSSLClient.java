package soap.wsclient;

import soap.glassfish.client.HelloWorld;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import java.net.URL;
import java.util.Map;

public class WSSSLClient {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:8080/JavaSoap/HelloWorldImplService?wsdl");
        // URL url = new URL("http://localhost:8181/JavaSoap/HelloWorldImplService?wsdl");
        QName qname = new QName("http://soap/", "HelloWorldImplService");

        Service service = Service.create(url, qname);
        HelloWorld hello = service.getPort(HelloWorld.class);

        BindingProvider bindProv = (BindingProvider) hello;
        Map<String, Object> context = bindProv.getRequestContext();
        context.put("javax.xml.ws.security.auth.username", "admin");
        context.put("javax.xml.ws.security.auth.password", "admin");

        try {
            String zapytanie = "wiadomosc klienta";
            String response = hello.getHelloWorldAsString(zapytanie);
            System.out.println("Klient wysłał: " + zapytanie);
            System.out.println("Klient otrzymał: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

