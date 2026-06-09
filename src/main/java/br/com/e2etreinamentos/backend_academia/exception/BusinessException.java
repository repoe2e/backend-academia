package br.com.e2etreinamentos.backend_academia.exception;

public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }
}