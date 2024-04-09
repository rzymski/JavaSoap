package soap.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.MTOM;
import java.awt.*;

@MTOM
@WebService(endpointInterface = "soap.service.Server")
//@BindingType(value = SOAPBinding.SOAP11HTTP_MTOM_BINDING)
public interface Server {
    @WebMethod
    String echo(String text);

    @WebMethod
    Image downloadImage(String fileName);
}
