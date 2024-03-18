package soaporiginal;

import javax.jws.WebService;

@WebService(endpointInterface = "soaporiginal.HelloWorld")
public class HelloWorldImpl implements HelloWorld {
    @Override
    public String getHelloWorldAsString(String name) {
        return "Witaj świecie JAX-WS: " + name;
    }
}
