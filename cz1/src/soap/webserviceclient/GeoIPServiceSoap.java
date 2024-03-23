package soap.webserviceclient;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

//@WebService
//@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL)
@WebService(targetNamespace = "http://lavasoft.com/")
public interface GeoIPServiceSoap {
    //@WebMethod
    @WebMethod(operationName = "GetLocation", action = "http://lavasoft.com/GetLocation")
    @WebResult(name = "GetLocationResult", targetNamespace = "http://lavasoft.com/")
    @RequestWrapper(localName = "GetLocation", targetNamespace = "http://lavasoft.com/", className = "com.lavasoft.GetLocation")
    @ResponseWrapper(localName = "GetLocationResponse", targetNamespace = "http://lavasoft.com/", className = "com.lavasoft.GetLocationResponse")
    String getLocation();
}
