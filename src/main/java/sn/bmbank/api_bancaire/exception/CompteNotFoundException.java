package sn.bmbank.api_bancaire.exception;

public class CompteNotFoundException  extends RuntimeException{
    public CompteNotFoundException(String message) {
        super(message);
    }
}
