package pt.ist.fenixframework.example.bank.domain;

public class InsufficientFundsException extends RuntimeException {

    private static final long serialVersionUID = -4435957392777041342L;

    public InsufficientFundsException(String message) {
        super(message);
    }

}
