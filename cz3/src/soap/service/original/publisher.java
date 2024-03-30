package soap.service.original;

import javax.xml.ws.Endpoint;


public class publisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/ws/server", new ServerImpl());
        System.out.println("Web service działa...");
        System.out.println("Możesz sprawdzić na: http://localhost:9999/ws/server?wsdl");
    }
}
