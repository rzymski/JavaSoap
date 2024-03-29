package soap.service.original;

import javax.annotation.Resource;
import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.util.List;
import java.util.Map;

@WebService(endpointInterface = "soap.service.original.Server")
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
    public String calculator(String operation, String firstValue, String secondValue) {
        if(authorization()){ System.out.println("Witaj! Zalogowano się prawidłowo."); }
        else { System.out.println("Błędne dane. Nie udało się zalogować. "); }

        try {
            double first = Double.parseDouble(firstValue);
            double second = Double.parseDouble(secondValue);
            if (Double.isInfinite(first) || Double.isInfinite(second) || Double.isNaN(first) || Double.isNaN(second)) {
                throw new ArithmeticException("Invalid input: Infinite or NaN values are not allowed.");
            }
            double result;
            switch (operation) {
                case "+":
                    result = first + second;
                    break;
                case "-":
                    result = first - second;
                    break;
                case "*":
                    result = first * second;
                    break;
                case "/":
                    if (second == 0) {
                        throw new ArithmeticException("Division by zero is not allowed.");
                    }
                    result = first / second;
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported operation: " + operation);
            }
            System.out.println("Kalkulator wykonuje operacje dla" + first + " " + operation + " " + second +". Wynik: " + result + ".");
            return String.valueOf(result);
        } catch (NumberFormatException e) {
            return "Invalid input: Please provide valid numeric values.";
        } catch (ArithmeticException e) {
            return "Arithmetic error: " + e.getMessage();
        } catch (Exception e) {
            return "Unexpected error: " + e.getMessage();
        }
    }
}
