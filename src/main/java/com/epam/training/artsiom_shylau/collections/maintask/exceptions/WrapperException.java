package com.epam.training.artsiom_shylau.collections.maintask.exceptions;

public class WrapperException extends Exception {

    public WrapperException() {}

    public WrapperException(String message) {
        super(message);
    }

    public WrapperException(Throwable throwable) {
        super(throwable);
    }

    public WrapperException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
