package handlers;

public class ValuesExceptions extends Exception {

    public ValuesExceptions() {
        super();
    }

    public ValuesExceptions(String message) {
        super(message);
    }

    public ValuesExceptions(String message, Throwable cause) {
        super(message, cause);
    }

}