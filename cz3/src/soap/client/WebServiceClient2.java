package soap.client;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.PortInfo;
import java.net.URL;
import java.util.*;


import soap.handler.MacAddressInjectHandler;
import soap.wizard.wsdl.classes.Server;
import soap.wizard.wsdl.classes.ServerImplService;



public class WebServiceClient2 {
    // private static final String WS_URL = "http://localhost:8080/ws/server"; // przy użyciu SoapUi httpMonitor tunnel ustawionym na porcie 8080
    private static final String WS_URL = "http://localhost:9999/ws/server"; // jeśli nie używamy SoaupUi

    public static void main(String[] args) throws Exception {
//        URL url = new URL(WS_URL);
//        QName qname = new QName("http://service.soap/", "ServerImplService");
//
//        Service service = Service.create(url, qname);
//        // Manually add handler to header
//        HandlerResolver handlerResolver = new HandlerResolver() {
//            @Override
//            public List<Handler> getHandlerChain(PortInfo portInfo) {
//                List<Handler> handlerChain = new ArrayList<>();
//                handlerChain.add(new MacAddressInjectHandler()); // Add your handler here
//                return handlerChain;
//            }
//        };
//        service.setHandlerResolver(handlerResolver);
//
//        Server server = service.getPort(Server.class);
//
//        // Set the endpoint address
//        Map<String, Object> req_ctx = ((BindingProvider) server).getRequestContext();
//        req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WS_URL);
//        // Set the HTTP headers for authentication
//        Map<String, List<String>> headers = new HashMap<>();
//        headers.put("Username", Collections.singletonList("pizza"));
//        headers.put("Password", Collections.singletonList("Trudne123!"));
//        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
//        // Call the service method
//        try{
//            System.out.println(server.calculator("*", 3.15, 2.71));
//        } catch (Exception e) {
//            System.out.println("Wystąpił wyjątek: " + e.getMessage());
//        }

        // Alternatywna wersja

        ServerImplService serverService = new ServerImplService();
        Server server = serverService.getServerImplPort();

        // wywołanie metody zwracającej nazwe serwera
        System.out.println("Nazwa serwera = " + server.getServerName());

        // ustawienie przekierowania (wykorzystywane przy testowaniu przez SoapUi)
        Map<String, Object> req_ctx = ((BindingProvider)server).getRequestContext();
        req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WS_URL);

        // dodanie nazwy użytkownika i hasła do nagłówka
        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        headers.put("Username", Collections.singletonList("pizza"));
        headers.put("Password", Collections.singletonList("Trudne123!"));
        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

        // wywołanie kalkulatora
        try {
            System.out.println(server.calculator("*", 3.15, 2.71));
        } catch (Exception e) {
            System.out.println("Wystąpił wyjątek: " + e.getMessage());
        }
    }
}
