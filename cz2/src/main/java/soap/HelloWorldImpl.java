package soap;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.BindingType;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "soap.HelloWorld")
public class HelloWorldImpl implements HelloWorld {
    @Override
    public String getHelloWorldAsString(String name) {
        return "Witaj świecie JAX-WS: " + name;
    }

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<Product>();
        Product p1 = new Product("Pizza", "Pizza jest bardzo smaczna.", 25);
        Product p2 = new Product("Car", "Brum brum", 100000);
        Product p3 = new Product("Gun", "Pif paf", 500);
        products.add(p1);
        products.add(p2);
        products.add(p3);
        return products;
    }
}
