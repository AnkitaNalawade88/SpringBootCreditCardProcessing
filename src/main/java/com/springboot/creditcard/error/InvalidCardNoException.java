package com.springboot.creditcard.error;

public class InvalidCardNoException extends Exception{

    public InvalidCardNoException() {
        super();
    }

    public InvalidCardNoException(String message) {
        super(message);
    }

    public InvalidCardNoException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCardNoException(Throwable cause) {
        super(cause);
    }

    protected InvalidCardNoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
