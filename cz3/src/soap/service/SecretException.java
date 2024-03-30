package soap.service;

import javax.xml.ws.WebFault;

@WebFault(name = "SecretException")
public class SecretException extends Exception {

    private static String explanation = "Ten kalkulator nie może mnożyć pi * ln, ponieważ tak wymyślił autor.";


    public SecretException(String message) {
        super(message);
    }

    public SecretException(String message, String explanation) {
        super(message);
        this.explanation = explanation;
    }

    public SecretException(String message, String explanation, Throwable cause) {
        super(message, cause);
        this.explanation = explanation;
    }

    public String getExplanation() {
        return explanation;
    }
}