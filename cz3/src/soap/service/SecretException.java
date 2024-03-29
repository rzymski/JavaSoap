package soap.service;

public class SecretException extends Exception {

    public SecretException() {
        super();
    }

    public SecretException(String message) {
        super(message);
    }

    public SecretException(String message, Throwable cause) {
        super(message, cause);
    }

    public SecretException(Throwable cause) {
        super(cause);
    }
}
