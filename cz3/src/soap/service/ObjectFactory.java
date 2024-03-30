
package soap.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the soap.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetReverseMessageResponse_QNAME = new QName("http://service.soap/", "getReverseMessageResponse");
    private final static QName _GetReverseMessage_QNAME = new QName("http://service.soap/", "getReverseMessage");
    private final static QName _GetServerName_QNAME = new QName("http://service.soap/", "getServerName");
    private final static QName _GetServerNameResponse_QNAME = new QName("http://service.soap/", "getServerNameResponse");
    private final static QName _SecretException_QNAME = new QName("http://service.soap/", "SecretException");
    private final static QName _Calculator_QNAME = new QName("http://service.soap/", "calculator");
    private final static QName _CalculatorResponse_QNAME = new QName("http://service.soap/", "calculatorResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: soap.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SecretException }
     * 
     */
    public SecretException createSecretException(String message) {
        return new SecretException(message);
    }

    /**
     * Create an instance of {@link Calculator }
     * 
     */
    public Calculator createCalculator() {
        return new Calculator();
    }

    /**
     * Create an instance of {@link CalculatorResponse }
     * 
     */
    public CalculatorResponse createCalculatorResponse() {
        return new CalculatorResponse();
    }

    /**
     * Create an instance of {@link GetReverseMessageResponse }
     * 
     */
    public GetReverseMessageResponse createGetReverseMessageResponse() {
        return new GetReverseMessageResponse();
    }

    /**
     * Create an instance of {@link GetServerName }
     * 
     */
    public GetServerName createGetServerName() {
        return new GetServerName();
    }

    /**
     * Create an instance of {@link GetServerNameResponse }
     * 
     */
    public GetServerNameResponse createGetServerNameResponse() {
        return new GetServerNameResponse();
    }

    /**
     * Create an instance of {@link GetReverseMessage }
     * 
     */
    public GetReverseMessage createGetReverseMessage() {
        return new GetReverseMessage();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReverseMessageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap/", name = "getReverseMessageResponse")
    public JAXBElement<GetReverseMessageResponse> createGetReverseMessageResponse(GetReverseMessageResponse value) {
        return new JAXBElement<GetReverseMessageResponse>(_GetReverseMessageResponse_QNAME, GetReverseMessageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReverseMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap/", name = "getReverseMessage")
    public JAXBElement<GetReverseMessage> createGetReverseMessage(GetReverseMessage value) {
        return new JAXBElement<GetReverseMessage>(_GetReverseMessage_QNAME, GetReverseMessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServerName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap/", name = "getServerName")
    public JAXBElement<GetServerName> createGetServerName(GetServerName value) {
        return new JAXBElement<GetServerName>(_GetServerName_QNAME, GetServerName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServerNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap/", name = "getServerNameResponse")
    public JAXBElement<GetServerNameResponse> createGetServerNameResponse(GetServerNameResponse value) {
        return new JAXBElement<GetServerNameResponse>(_GetServerNameResponse_QNAME, GetServerNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SecretException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap/", name = "SecretException")
    public JAXBElement<SecretException> createSecretException(SecretException value) {
        return new JAXBElement<SecretException>(_SecretException_QNAME, SecretException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Calculator }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap/", name = "calculator")
    public JAXBElement<Calculator> createCalculator(Calculator value) {
        return new JAXBElement<Calculator>(_Calculator_QNAME, Calculator.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculatorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap/", name = "calculatorResponse")
    public JAXBElement<CalculatorResponse> createCalculatorResponse(CalculatorResponse value) {
        return new JAXBElement<CalculatorResponse>(_CalculatorResponse_QNAME, CalculatorResponse.class, null, value);
    }

}
