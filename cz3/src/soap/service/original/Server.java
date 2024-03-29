package soap.service.original;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.DOCUMENT, use = SOAPBinding.Use.LITERAL) //optional
public interface Server {
    @WebMethod
    String getServerName();

    @WebMethod
    String getReverseMessage(String message);

    @WebMethod
    String calculator(String operation, String firstValue, String secondValue);
}