
package soap.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use = SOAPBinding.Use.LITERAL) //optional
public interface Server {
    @WebMethod
    String getServerName();

    @WebMethod
    String getReverseMessage(String message);

    @WebMethod
    Double calculator(String operation, Double firstValue, Double secondValue) throws SecretException;
}
