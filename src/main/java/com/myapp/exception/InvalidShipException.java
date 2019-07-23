package com.myapp.exception;

public class InvalidShipException extends RuntimeException {

    public InvalidShipException(String message) {
        super(message);
    }

}
