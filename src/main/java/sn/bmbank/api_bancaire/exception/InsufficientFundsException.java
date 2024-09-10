package sn.bmbank.api_bancaire.exception;

public class InsufficientFundsException  extends RuntimeException{
    public InsufficientFundsException(String message) {
        super(message);
    }
}
