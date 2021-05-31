package com.springboot.creditcard.error;

public class CardAlreadyExistException extends Exception{

    public CardAlreadyExistException() {
        super();
    }

    public CardAlreadyExistException(String message) {
        super(message);
    }

    public CardAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public CardAlreadyExistException(Throwable cause) {
        super(cause);
    }

    protected CardAlreadyExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
