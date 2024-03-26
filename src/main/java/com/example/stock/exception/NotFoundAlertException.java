package com.example.stock.exception;

public class NotFoundAlertException extends RuntimeException {

    public NotFoundAlertException(String message) {
        super(message);
    }

    public NotFoundAlertException(String message, Throwable cause) {
        super(message, cause);
    }
}


