package soap.service.original;

import javax.annotation.Resource;
import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.util.List;
import java.util.Map;

@WebService(endpointInterface = "soap.service.Server")
@HandlerChain(file= "getMacHandler.xml")
public class ServerImpl implements Server {
    @Resource
    WebServiceContext wsctx;

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

    private boolean authorization() {
        MessageContext mctx = wsctx.getMessageContext();
        Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
        List userList = (List) http_headers.get("Username");
        List passList = (List) http_headers.get("Password");
        String username = "";
        String password = "";
        if(userList!=null){ username = userList.get(0).toString();}
        if(passList!=null){ password = passList.get(0).toString(); }
        return (username.equals("pizza") && password.equals("Trudne123!"));
    }

    @Override
    public Double calculator(String operation, Double firstValue, Double secondValue) throws IllegalArgumentException, ArithmeticException, SecurityException, SecretException {
        System.out.println("DZIALA dla: " + operation + " " + firstValue + " " + secondValue);
        if (authorization()){ System.out.println("Witaj! Zalogowano się prawidłowo."); }
        else {
            System.out.println("Błędne dane. Nie udało się zalogować. ");
            throw new SecurityException("Authorization failed: invalid login credentials");
        }

        Double result;
        if (operation == null || firstValue == null || secondValue == null){
            throw new NullPointerException("One of the arguments is null. Operation = " + operation + " first value = " + firstValue + " second value = " + secondValue);
        }
        if (!operation.matches("[+\\-*/]")) {
            throw new IllegalArgumentException("Unsupported operation: " + operation);
        }
        if (Double.isInfinite(firstValue) || Double.isInfinite(secondValue) || Double.isNaN(firstValue) || Double.isNaN(secondValue)) {
            throw new ArithmeticException("Invalid input: Infinite or NaN values are not allowed.");
        }
        if (operation.equals("*") && firstValue.equals(3.14) && secondValue.equals(2.71)) {
            System.out.println("ODKRYWCA");
            throw new SecretException("Congratulation you discovered secret exception.");
        }
        switch (operation) {
            case "+":
                result = firstValue + secondValue;
                break;
            case "-":
                result = firstValue - secondValue;
                break;
            case "*":
                result = firstValue * secondValue;
                break;
            case "/":
                if (secondValue == 0) {
                    throw new ArithmeticException("Division by zero is not allowed.");
                }
                result = firstValue / secondValue;
                break;
            default:
                throw new IllegalArgumentException("Unsupported operation: " + operation);
        }
        return result;
    }
}
