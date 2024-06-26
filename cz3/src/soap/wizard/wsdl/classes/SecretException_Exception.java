
package soap.wizard.wsdl.classes;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "SecretException", targetNamespace = "http://service.soap/")
public class SecretException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private SecretException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public SecretException_Exception(String message, SecretException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public SecretException_Exception(String message, SecretException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: soap.wizard.wsdl.classes.SecretException
     */
    public SecretException getFaultInfo() {
        return faultInfo;
    }

}
