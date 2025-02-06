package br.com.fiap.hackaton.authorization.excepetion;

public class BusinessException extends RuntimeException {
 
    public BusinessException(final String message) {
        super(message);
    }
}
