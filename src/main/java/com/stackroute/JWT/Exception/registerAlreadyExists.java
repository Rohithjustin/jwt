package com.stackroute.JWT.Exception;

public class registerAlreadyExists extends RuntimeException {
    public registerAlreadyExists (String message) {
        super(message);
    }
}