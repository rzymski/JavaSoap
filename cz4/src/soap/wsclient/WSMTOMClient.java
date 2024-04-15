package soap.wsclient;

import soap.wizard.wsdl.classes.Server;
import soap.wizard.wsdl.classes.ServerImplService;

import javax.swing.*;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.MTOMFeature;
import javax.xml.ws.soap.SOAPBinding;
import java.util.Map;

public class WSMTOMClient {
    // private static final String WS_URL = "http://localhost:8080/ws/server"; // przy użyciu SoapUi httpMonitor tunnel ustawionym na porcie 8080
    private static final String WS_URL = "http://localhost:9999/ws/server"; // jeśli nie używamy SoaupUi

    public static void main(String[] args) {
        ServerImplService serverService = new ServerImplService();
        Server imageServer = serverService.getServerImplPort(new MTOMFeature());

        // ustawienie przekierowania dla serwera z obrazkami (wykorzystywane przy testowaniu przez SoapUi)
        Map<String, Object> req_ctxImage = ((BindingProvider)imageServer).getRequestContext();
        req_ctxImage.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WS_URL);

        // sprawdzanie czy mtom jest włączony
        SOAPBinding binding = (SOAPBinding) ((BindingProvider) imageServer).getBinding();
        //binding.setMTOMEnabled(true);
        boolean mtomEnabled = binding.isMTOMEnabled();
        System.out.println("mtomEnabled = " + mtomEnabled);

        String text = "PIZZA";
        System.out.println("Wysłano do serwera: " + text);
        System.out.println(imageServer.echo(text));
        binding.setMTOMEnabled(true);

        try {
            String screenName = "addMaven.jpg";
            byte [] image = imageServer.downloadImage(screenName);

            JFrame frame = new JFrame();
            frame.setSize(300, 300);
            JLabel label = new JLabel(new ImageIcon(image));
            frame.add(label);
            frame.setVisible(true);

            System.out.println("imageServer.downloadImage(" + screenName + ") : Download Successful!");
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Error: Najprawdopodobniej nie ma obrazka o takiej nazwie.");
        }
    }
}
