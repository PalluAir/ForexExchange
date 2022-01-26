package com.trainingapps.forex.exchangerate.exceptions;

public class CurrencyNotAvailableException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CurrencyNotAvailableException(String message) {
        super(message);
    }
}
