
package soap.glassfish.client;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "HelloWorld", targetNamespace = "http://soap/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface HelloWorld {


    /**
     * 
     * @return
     *     returns java.util.List<soap.glassfish.client.Product>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getProducts", targetNamespace = "http://soap/", className = "soap.glassfish.client.GetProducts")
    @ResponseWrapper(localName = "getProductsResponse", targetNamespace = "http://soap/", className = "soap.glassfish.client.GetProductsResponse")
    @Action(input = "http://soap/HelloWorld/getProductsRequest", output = "http://soap/HelloWorld/getProductsResponse")
    public List<Product> getProducts();

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getHelloWorldAsString", targetNamespace = "http://soap/", className = "soap.glassfish.client.GetHelloWorldAsString")
    @ResponseWrapper(localName = "getHelloWorldAsStringResponse", targetNamespace = "http://soap/", className = "soap.glassfish.client.GetHelloWorldAsStringResponse")
    @Action(input = "http://soap/HelloWorld/getHelloWorldAsStringRequest", output = "http://soap/HelloWorld/getHelloWorldAsStringResponse")
    public String getHelloWorldAsString(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
