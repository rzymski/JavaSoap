package soap;

//Service Implementation
import javax.jws.WebService;
@WebService(endpointInterface = "soap.HelloWorld")
public class HelloWorldImpl implements HelloWorld {
    @Override
    public String getHelloWorldAsString(String name) {
        return "Witaj świecie JAX-WS: " + name;
    }
}
