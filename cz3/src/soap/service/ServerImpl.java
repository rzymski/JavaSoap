package soap.service;

import javax.jws.HandlerChain;
import javax.jws.WebService;

@WebService(endpointInterface = "soap.service.Server")
@HandlerChain(file= "getMacHandler.xml")
public class ServerImpl implements Server {

    @Override
    public String getServerName() {
        return "Server laptop";
    }

    @Override
    public String getReverseMessage(String message) {
        String reversed = "";
        for (int i = message.length() - 1; i >= 0; i--) { reversed += message.charAt(i); }
        return reversed;
    }
}
