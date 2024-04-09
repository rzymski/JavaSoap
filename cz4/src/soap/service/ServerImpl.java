package soap.service;

import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.MTOM;
import javax.xml.ws.soap.SOAPBinding;
import java.awt.*;
import java.io.File;
import java.io.IOException;

@MTOM
@WebService(endpointInterface = "soap.service.Server")
@BindingType(value = SOAPBinding.SOAP11HTTP_MTOM_BINDING)
public class ServerImpl implements Server {
    @Override
    public String echo(String text) {
        return "Serwer zwraca otrzymany text: " + text;
    }

    @Override
    public Image downloadImage(String fileName) {
        try{
            File image = new File("D:\\programowanie\\java\\rsi\\JavaSoap\\screens\\" + fileName);
            return ImageIO.read(image);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
