package com.trainingapps.forex.exchangerate.exceptions;

public class ExchangeValueIdNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ExchangeValueIdNotFoundException(String message) {
        super(message);
    }
}
